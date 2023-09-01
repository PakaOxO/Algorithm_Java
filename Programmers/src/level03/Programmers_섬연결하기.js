/**
 * Programmers_섬 연결하기
 *    1. 문제 분류 : 그리디, MST
 *    2. 접근 방법
 *      - 프림 알고리즘을 사용해 모든 정점들을 이을 때까지 반복
 */
const solution = (n, costs) => {
  /* 최소 힙 구현 */
  class Heap {
    constructor() {
      this.arr = [null];
      this.size = 0;
    }

    getSize() {
      return this.size;
    }

    offer(간선) {
      this.size++;
      let pointer = this.size;
      let parent = Math.floor(pointer / 2);
      this.arr.push(간선);

      while (parent !== 0 && this.arr[parent][1] > this.arr[pointer][1]) {
        this.swap(parent, pointer);
        pointer = parent;
        parent = Math.floor(pointer / 2);
      }
    }

    poll() {
      if (this.size === 0) return null;
      this.swap(1, this.size);
      this.size--;
      const result = this.arr.pop();

      if (this.size > 0) {
        let pointer = 1;

        while (pointer < this.size) {
          let [left, right] = [pointer * 2, pointer * 2 + 1];
          if (right <= this.size) {
            if (this.arr[left][1] < this.arr[right][1]) {
              if (this.arr[left][1] < this.arr[pointer][1]) {
                this.swap(pointer, left);
                pointer = left;
              } else {
                break;
              }
            } else {
              if (this.arr[right][1] < this.arr[pointer][1]) {
                this.swap(pointer, right);
                pointer = right;
              } else {
                break;
              }
            }
          } else if (left <= this.size) {
            if (this.arr[left][1] < this.arr[pointer][1]) {
              this.swap(pointer, left);
              pointer = left;
            } else {
              break;
            }
          } else {
            break;
          }
        }
      }

      return result;
    }

    swap(i, j) {
      const [ni, ci] = this.arr[i];
      this.arr[i] = [this.arr[j][0], this.arr[j][1]];
      this.arr[j] = [ni, ci];
    }
  }

  /* 변수 초기화 */
  let answer = 0;
  const adjList = Array.from({ length: n }, () => []);

  /* 메인 로직 */
  for (const [from, to, cost] of costs) {
    adjList[from].push([to, cost]);
    adjList[to].push([from, cost]);
  }

  answer = prim(0);

  /* 정답 반환 */
  return answer;

  /* bfs */
  function prim(start) {
    const queue = new Heap();
    const v = Array.from({ length: n }, () => false);
    queue.offer([start, 0]);
    let sum = 0;
    let count = 0;

    while (queue.getSize() > 0) {
      const edge = queue.poll();
      if (v[edge[0]]) continue;
      v[edge[0]] = true;
      count++;
      sum += edge[1];
      if (count === n) break;

      for (const [next, cost] of adjList[edge[0]]) {
        if (v[next]) continue;
        queue.offer([next, cost]);
      }
    }

    return sum;
  }
};

console.log(
  solution(4, [
    [0, 1, 1],
    [0, 2, 2],
    [1, 2, 5],
    [1, 3, 1],
    [2, 3, 8],
  ])
);

