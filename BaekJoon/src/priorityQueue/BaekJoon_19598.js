/**
 * BaekJoon_19598, 최소 회의실 개수
 *  - 문제 분류: 자료구조(힙), 그리디
 */
const solution = () => {
  // 최소 힙
  class PriorityQueue {
    constructor() {
      this.arr = [null];
      this.size = 0;
    }

    offer(endTime) {
      this.arr.push(endTime);
      this.size++;

      let pointer = this.size;
      let parent = Math.floor(pointer / 2);
      while (parent > 0) {
        if (this.arr[pointer] >= this.arr[parent]) break;
        this.swap(parent, pointer);
        pointer = parent;
        parent = Math.floor(pointer / 2);
      }
    }

    poll() {
      if (this.size === 0) return null;
      this.swap(1, this.size);
      const result = this.arr.pop();
      this.size--;

      let pointer = 1;
      while (true) {
        const [left, right] = [pointer * 2, pointer * 2 + 1];
        if (left > this.size) break;

        let next;
        if (right <= this.size) {
          next = this.arr[left] <= this.arr[right] ? left : right;
        } else {
          next = left;
        }

        if (next === undefined || this.arr[pointer] <= this.arr[next]) break;
        this.swap(pointer, next);
        pointer = next;
      }

      return result;
    }

    peek() {
      if (this.size === 0) return null;
      return this.arr[1];
    }

    getSize() {
      return this.size;
    }

    swap(i, j) {
      const temp = this.arr[i];
      this.arr[i] = this.arr[j];
      this.arr[j] = temp;
    }
  }

  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/19598.txt").toString().split("\n");
  const N = +input[0];
  const meetings = [];
  const pq = new PriorityQueue();
  let pointer = 0;
  let answer = 0;

  /* 메인 로직 */
  for (let i = 1; i <= N; i++) meetings.push(input[i].split(" ").map((item) => +item));
  meetings.sort((a, b) => {
    if (a[0] === b[0]) return a[1] - b[1];
    return a[0] - b[0];
  });

  while (pointer < meetings.length) {
    while (pq.getSize() > 0 && pq.peek() <= meetings[pointer][0]) {
      pq.poll();
    }

    pq.offer(meetings[pointer++][1]);
    answer = Math.max(answer, pq.getSize());
  }

  /* 최소 회의실 개수 반환 */
  return answer;
};

console.log(solution());

