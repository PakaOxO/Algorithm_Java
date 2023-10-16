/**
 * BaekJoon_2075, N번째 큰 수
 *  - 문제 분류: 우선 순위 큐, 정렬
 */
/* 우선 순위 큐 구현 */
class PriorityQueue {
  constructor() {
    this.arr = [null];
    this.size = 0;
  }

  swap(i, j) {
    const temp = this.arr[i];
    this.arr[i] = this.arr[j];
    this.arr[j] = temp;
  }

  peek() {
    if (this.size === 0) return null;
    return this.arr[1];
  }

  offer(val) {
    this.size++;
    this.arr.push(val);

    let pointer = this.size;
    let parent = Math.floor(pointer / 2);
    while (parent > 0 && this.arr[parent] > this.arr[pointer]) {
      this.swap(pointer, parent);
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

      if (right <= this.size) {
        let next = this.arr[left] <= this.arr[right] ? left : right;
        if (this.arr[next] >= this.arr[pointer]) break;
        this.swap(next, pointer);
        pointer = next;
      } else {
        if (this.arr[left] >= this.arr[pointer]) break;
        this.swap(left, pointer);
        pointer = left;
      }
    }

    return result;
  }
}

const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let n;
let input = [];
const pq = new PriorityQueue();

rl.question("", (answer) => {
  n = +answer;

  rl.on("line", (line) => {
    if (line === "") {
      rl.close();
    }

    line.split(" ").forEach((num) => {
      num = +num;
      pq.offer(num);

      if (pq.size > n) {
        pq.poll();
      }
    });
  }).on("close", () => {
    const N = +input[0];
    const arr = [];

    for (let i = 1; i <= N; i++) {
      arr.push(input[i].split(" ").map((item) => +item));
    }

    console.log(pq.peek());
    process.exit();
  });
});
