/**
 * BaekJoon_10282, 해킹
 *  - 문제 분류: 최단 거리 알고리즘, 그래프 탐색
 */
const solution = () => {
  class Heap {
    constructor() {
      this.arr = [null];
      this.size = 0;
    }

    offer(node) {
      this.arr.push(node);
      this.size++;

      let pointer = this.size;
      while (pointer > 1) {
        const parent = Math.floor(pointer / 2);
        if (parent === 0) break;
        if (this.arr[parent][1] <= this.arr[pointer][1]) break;
        this.swap(parent, pointer);
        pointer = parent;
      }
    }

    poll() {
      if (this.size < 1) return null;
      this.swap(1, this.size);
      const result = this.arr.pop();
      this.size--;

      let pointer = 1;
      while (pointer < this.size) {
        const [left, right] = [pointer * 2, pointer * 2 + 1];
        if (left > this.size) break;
        const next = right > this.size ? left : this.arr[left][1] < this.arr[right][1] ? left : right;

        if (this.arr[pointer][1] <= this.arr[next][1]) break;
        this.swap(next, pointer);
        pointer = next;
      }

      return result;
    }

    swap(i, j) {
      const temp = this.arr[i];
      this.arr[i] = this.arr[j];
      this.arr[j] = temp;
    }

    getSize() {
      return this.size;
    }
  }

  /* 변수 관리 */
  const input = require('fs').readFileSync('./dev/stdin/10282.txt').toString().trim().split('\n');
  const T = +input[0];
  let pointer = 1;
  const answer = [];

  /* 메인 로직 */
  for (let i = 1; i <= T; i++) {
    const [n, d, c] = input[pointer++].split(' ').map(Number);
    const list = Array.from({ length: n + 1 }, () => []);
    for (let j = 0; j < d; j++) {
      const [a, b, s] = input[pointer++].split(' ').map(Number);
      list[b].push([a, s]);
    }

    const [count, time] = dijkstra(c, n, list);
    answer.push([count, time]);
  }

  /* 정답 반환 */
  return answer.map((t) => t.join(' ')).join('\n');

  // 다익스트라
  function dijkstra(s, n, adjList) {
    let count = 0;
    let time = 0;
    const v = Array.from({ length: n + 1 }, () => false);
    const heap = new Heap();
    heap.offer([s, 0]);

    while (heap.getSize() > 0) {
      const [curr, t] = heap.poll();
      if (v[curr]) continue;
      v[curr] = true;
      count++;
      time = Math.max(time, t);

      for (const [next, d] of adjList[curr]) {
        heap.offer([next, t + d]);
      }
    }

    return [count, time];
  }
};

console.log(solution());
