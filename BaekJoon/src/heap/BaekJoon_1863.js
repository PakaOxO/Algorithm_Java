/**
 * BaekJoon_1863, 스카이라인 쉬운거
 *  - 문제 분류: 자료구조, 힙
 */
const solution = () => {
  /* 최소 힙 구현 */
  class PriorityQueue {
    constructor(MAX_SIZE) {
      this.arr = [null];
      this.visited = Array.from({ length: MAX_SIZE + 1 }, () => false);
      this.size = 0;
    }

    offer(height) {
      this.arr.push(height);
      this.visited[height] = true;
      this.size++;

      let pointer = this.size;
      let parent = Math.floor(pointer / 2);
      while (parent > 0 && this.arr[parent] < this.arr[pointer]) {
        this.swap(pointer, parent);
        pointer = parent;
        parent = Math.floor(pointer / 2);
      }
    }

    poll() {
      if (this.size === 0) return;
      this.swap(1, this.size);
      this.size--;
      const result = this.arr.pop();
      this.visited[result] = false;

      let pointer = 1;
      while (true) {
        const [left, right] = [pointer * 2, pointer * 2 + 1];
        let next;
        if (left > this.size) break;
        if (right <= this.size) {
          next = this.arr[left] >= this.arr[right] ? left : right;
        } else {
          next = left;
        }

        if (this.arr[pointer] >= this.arr[next]) break;
        this.swap(pointer, next);
        pointer = next;
      }

      return result;
    }

    peek() {
      if (this.size === 0) return null;
      return this.arr[1];
    }

    hasNum(height) {
      return this.visited[height];
    }

    swap(i, j) {
      const temp = this.arr[i];
      this.arr[i] = this.arr[j];
      this.arr[j] = temp;
    }
  }

  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/1863.txt").toString().split("\n");
  const N = +input[0];
  const MAX_HEIGHT = 500000;
  const skylines = [];
  const pq = new PriorityQueue(MAX_HEIGHT);
  let answer = 0;

  /* 메인 로직 */
  for (let i = 1; i <= N; i++) {
    skylines.push(input[i].split(" ").map((item) => +item));
  }
  skylines.sort((a, b) => a[0] - b[0]);

  for (let i = 0; i < N; i++) {
    const [_, y] = skylines[i];

    while (pq.peek() !== null && pq.peek() > y) {
      pq.poll();
      answer++;
    }

    if (y === 0 || pq.hasNum(y)) continue;
    pq.offer(y);
  }

  answer += pq.size;

  /* 정답 반환 */
  return answer;
};

console.log(solution());

