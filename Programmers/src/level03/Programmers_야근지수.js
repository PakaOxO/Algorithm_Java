/*
  Schetch Idea
    1. 최대 힙 + 그리디 기법을 사용해 최대한 큰 숫자부터 줄여나가는 문제
    2. JS에서 최대 힙 구현은 귀찮으니 일단 매 작업 전 정렬을 하는 방식으로 구현해보자
      -> 예상했던대로 최대 힙을 사용하지 않으니 시간초과
*/

function solution(n, works) {
  const heap = new MaxHeap();
  for (const w of works) {
    heap.add(w);
  }

  while (n > 0 && heap.size > 0) {
    const max = heap.pop();
    if (max > 1) heap.add(max - 1);
    n--;
  }

  let answer = 0;
  while (heap.size > 0) {
    const max = heap.pop();
    answer += max ** 2;
  }

  return answer;
}

class MaxHeap {
  constructor() {
    this.arr = [null];
    this.size = 0;
  }

  pop() {
    if (this.size === 0) return null;
    this.swap(1, this.size--);
    const result = this.arr.pop();

    let curr = 1;
    while (curr < this.size) {
      const [left, right] = [curr * 2, curr * 2 + 1];
      let next = null;
      if (right <= this.size) {
        if (this.arr[left] >= this.arr[right]) {
          if (this.arr[curr] < this.arr[left]) {
            next = left;
          }
        } else {
          if (this.arr[curr] < this.arr[right]) {
            next = right;
          }
        }
      } else if (left <= this.size) {
        if (this.arr[curr] < this.arr[left]) {
          next = left;
        }
      }

      if (!next) break;
      this.swap(curr, next);
      curr = next;
    }

    return result;
  }

  add(val) {
    let pointer = ++this.size;
    let parent = Math.floor(pointer / 2);
    this.arr[pointer] = val;

    while (parent > 0 && this.arr[pointer] > this.arr[parent]) {
      this.swap(pointer, parent);
      pointer = parent;
      parent = Math.floor(parent / 2);
    }
  }

  swap(x, y) {
    const copyX = this.arr[x];
    this.arr[x] = this.arr[y];
    this.arr[y] = copyX;
  }
}

console.log(solution(4, [4, 3, 3]));
console.log(solution(1, [2, 1, 2]));
console.log(solution(3, [1, 1]));
console.log(solution(999, [800, 100, 55, 45]));
