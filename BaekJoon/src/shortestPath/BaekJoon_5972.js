/**
 * BaekJoon_5972, 택배 배송
 *  - 문제 분류: 그래프 탐색, 최단거리 알고리즘
 */
const solution = () => {
  /* 최소 힙 구현 */
  class Heap {
    constructor() {
      this.arr = [null];
      this.size = 0;
    }

    poll() {
      if (this.size === 0) return null;
      this.swap(1, this.size);
      const result = this.arr.pop();
      this.size--;

      let pointer = 1;
      while (true) {
        let [left, right] = [pointer * 2, pointer * 2 + 1];
        if (left > this.size) break;
        if (right <= this.size) {
          let next;
          if (this.arr[left][1] <= this.arr[right][1]) {
            next = left;
          } else {
            next = right;
          }

          if (this.arr[pointer][1] < this.arr[next][1]) break;
          this.swap(pointer, next);
          pointer = next;
        } else {
          if (this.arr[pointer][1] < this.arr[left][1]) break;
          this.swap(pointer, left);
          pointer = left;
        }
      }

      return result;
    }

    offer(node) {
      this.size++;
      this.arr.push(node);
      let pointer = this.size;
      let parent = Math.floor(pointer / 2);

      while (parent > 0 && this.arr[parent][1] >= this.arr[pointer][1]) {
        this.swap(pointer, parent);
        pointer = parent;
        parent = Math.floor(pointer / 2);
      }
    }

    swap(i, j) {
      const temp = [...this.arr[i]];
      this.arr[i] = [...this.arr[j]];
      this.arr[j] = temp;
    }
  }

  /* 변수 초기화 */
  const input = require("fs").readFileSync("./dev/stdin/5972.txt").toString().split("\n");
  const [N, M] = input[0].split(" ").map((item) => +item);
  const INF = Number.MAX_SAFE_INTEGER;
  let answer = INF;
  const adjList = Array.from({ length: N + 1 }, () => []);
  for (let i = 0; i < M; i++) {
    const [s, e, w] = input[i + 1].split(" ").map((item) => +item);
    adjList[s].push([e, w]);
    adjList[e].push([s, w]);
  }

  /* 메인 로직 */
  answer = getDist(1, N);

  /* 정답 반환 */
  return answer;

  /**
   * s에서 e까지의 최단 거리 반환
   */
  function getDist(s, e) {
    const dist = Array.from({ length: N + 1 }, () => INF);
    dist[s] = 0;
    const pq = new Heap();
    pq.offer([s, 0]);

    while (pq.size > 0) {
      const curr = pq.poll();
      if (curr[0] === e) {
        return curr[1];
      }

      for (const next of adjList[curr[0]]) {
        if (dist[next[0]] <= curr[1] + next[1]) continue;
        dist[next[0]] = curr[1] + next[1];
        pq.offer([next[0], dist[next[0]]]);
      }
    }

    return INF;
  }
};

console.log(solution());
