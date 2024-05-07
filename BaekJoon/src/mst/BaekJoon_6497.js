/**
 * BaekJoon_6497, 전력난
 *  - 문제 분류: 최소 스패닝 트리, 그래프 탐색
 */
const solution = () => {
  // 최소 힙
  class Heap {
    // private
    #arr;

    constructor() {
      this.#arr = [null];
    }

    push(node) {
      this.#arr.push(node);

      let curr = this.#arr.length - 1;
      let parent = Math.floor(curr / 2);

      while (parent > 0) {
        const flag = this.#arr[curr][1] < this.#arr[parent][1];
        if (!flag) break;

        this.#swap(parent, curr);
        curr = parent;
        parent = Math.floor(curr / 2);
      }
    }

    poll() {
      if (this.#arr.length === 1) return null;

      this.#swap(1, this.#arr.length - 1);
      const result = this.#arr.pop();

      let curr = 1;
      while (true) {
        let [left, right] = [curr * 2, curr * 2 + 1];
        if (left >= this.#arr.length) break;

        let next = left;
        if (right < this.#arr.length && this.#arr[right][1] <= this.#arr[left][1]) {
          next = right;
        }

        const flag = this.#arr[curr][1] > this.#arr[next][1];
        if (!flag) break;

        this.#swap(next, curr);
        curr = next;
      }

      return result;
    }

    size() {
      return this.#arr.length - 1;
    }

    #swap(i, j) {
      const temp = this.#arr[i];
      this.#arr[i] = this.#arr[j];
      this.#arr[j] = temp;
    }
  }

  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/6497.txt").toString().trim().split("\n");
  let pointer = 0;
  const answer = [];

  while (true) {
    const [M, N] = input[pointer++].split(" ").map(Number);
    if (M === 0 && N === 0) break;
    const adjList = Array.from({ length: M }, () => []);
    let sum = 0;

    for (let i = 1; i <= N; i++) {
      const [from, to, dist] = input[pointer++].split(" ").map(Number);
      adjList[from].push([to, dist]);
      adjList[to].push([from, dist]);

      sum += dist;
    }

    /* 메인 로직 */
    // Prim 알고리즘
    const pq = new Heap();
    const v = Array.from({ length: M }, () => false);
    pq.push([0, 0]);

    let count = 0;
    while (pq.size() > 0) {
      const [curr, dist] = pq.poll();
      if (v[curr]) continue;
      v[curr] = true;
      count++;
      sum -= dist;

      if (count === M) break;

      for (const [next, d] of adjList[curr]) {
        if (v[next]) continue;
        pq.push([next, d]);
      }
    }

    answer.push(sum);
  }

  /* 정답 반환 */
  return answer.join("\n");
};

console.log(solution());

