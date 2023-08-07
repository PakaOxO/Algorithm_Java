/**
 * Programmers_디펜스 게임
 *    1. 문제 분류 : 힙, 우선순위 큐
 *    2. 접근 방법
 *      - 우선순위 큐를 사용해 우선순위 큐에 담겨있는 위치는 무적기를 쓴다고 가정, 우선순위 큐는 최소힙
 *      - 우선순위 큐에 우선 앞에서 k개만큼 적 배열에서 꺼내 넣는다
 *        - 만약 적이 나타나는 수를 N이라 할때
 *          -> N이 k보다 작을 경우 바로 N를 정답으로
 *      - k개 이후 k+1을 포인터(다음에 등장할 적)로 지정하고 게임 스타트
 *        -> 포인터에 나타나는 적이 우선순위 큐 최소값보다 크다면 큐의 최소값을 꺼내 n을 줄여줌
 *          -> 만약 꺼내려는데 n보다 크다면 더 이상 진행 X
 *        -> 포인터에 나타나는 적이 큐 최소값보다 작다면 n에서 포인터의 값을 빼고 포인터 +1 증가
 *          -> 마찬가지로 포인터의 값이 남은 n보다 크다면 더 이상 진행 X
 */
const solution = (n, k, enemy) => {
  /* 최소 힙 구현 */
  class Heap {
    constructor() {
      this.arr = [null];
      this.size = 0;
    }

    offer(num) {
      this.arr.push(num);
      this.size++;
      let idx = this.size;
      let parent = ~~(idx / 2);
      while (parent > 0) {
        if (this.arr[parent] < this.arr[idx]) break;
        this.swap(idx, parent);
        idx = parent;
        parent = ~~(idx / 2);
      }
    }

    poll() {
      if (this.size < 1) return null;
      this.swap(1, this.size);
      const min = this.arr.pop();
      this.size--;

      let pointer = 1;
      let [left, right] = [pointer * 2, pointer * 2 + 1];
      while (left <= this.size) {
        let next = left;
        if (this.size >= right && this.arr[right] < this.arr[left]) {
          next = right;
        }

        if (this.arr[next] >= this.arr[pointer]) break;
        this.swap(pointer, next);
        pointer = next;
        left = pointer * 2;
        right = pointer * 2 + 1;
      }

      return min;
    }

    peek() {
      if (this.size < 1) return null;
      return this.arr[1];
    }

    swap(i, j) {
      const temp = this.arr[i];
      this.arr[i] = this.arr[j];
      this.arr[j] = temp;
    }
  }

  /* 변수 선언부 */
  const N = enemy.length;
  let pointer = 0;

  /* 메인 로직 */
  if (k < N) {
    pointer = k;
    const pq = new Heap();
    for (let i = 0; i < k; i++) {
      pq.offer(enemy[i]);
    }
    while (n >= 0 && pointer < N) {
      if (pq.peek() < enemy[pointer]) {
        if (n - pq.peek() < 0) break;
        n -= pq.poll();
        pq.offer(enemy[pointer++]);
      } else {
        if (n - enemy[pointer] < 0) break;
        n -= enemy[pointer++];
      }
    }
  } else {
    pointer = N;
  }

  return pointer;
};

console.log(solution(7, 3, [4, 2, 4, 5, 3, 3, 1]));
console.log(solution(2, 4, [3, 3, 3, 3]));

