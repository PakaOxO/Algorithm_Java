/**
 * BaekJoon_14217, 그래프 탐색
 *  - 문제 분류: 그래프 탐색, 최단 경로
 */
const solution = () => {
  class Queue {
    constructor() {
      this.arr = [];
      this.head = 0;
    }

    size() {
      return this.arr.length - this.head;
    }

    add(node) {
      this.arr.push(node);
    }

    remove() {
      if (this.size() === 0) return null;
      return this.arr[this.head++];
    }
  }

  /* 변수 관리 */
  const input = require('fs').readFileSync('./dev/stdin/14217.txt').toString().trim().split('\n');
  const [N, M] = input[0].split(' ').map(Number);
  const Q = +input[M + 1];
  const adjList = Array.from({ length: N }, () => []);
  const answer = [];

  for (let i = 1; i <= M; i++) {
    let [s, e] = input[i].split(' ').map(Number);
    s--, e--;
    adjList[s].push(e);
    adjList[e].push(s);
  }

  /* 메인 로직 */
  for (let i = M + 2; i < M + 2 + Q; i++) {
    let [op, s, e] = input[i].split(' ').map(Number);
    s--, e--;
    if (op === 1) {
      adjList[s].push(e);
      adjList[e].push(s);
    } else {
      adjList[s] = adjList[s].filter((to) => to !== e);
      adjList[e] = adjList[e].filter((to) => to !== s);
    }
    answer.push(bfs(0));
  }

  /* 정답 반환 */
  return answer.map((line) => line.join(' ')).join('\n');

  // 수도에서 다른 도시로 이동하는 최단 경로
  function bfs(start) {
    const INF = Number.MAX_SAFE_INTEGER;
    const dist = Array.from({ length: N }, () => INF);
    const q = new Queue();
    q.add([start, 0]);
    let count = 0;

    while (q.size() > 0) {
      const [node, acc] = q.remove();
      if (dist[node] < acc) continue;
      dist[node] = acc;
      count++;
      if (count === N) break;

      for (const next of adjList[node]) {
        if (dist[next] <= acc + 1) continue;
        dist[next] = acc + 1;
        q.add([next, dist[next]]);
      }
    }

    return dist.map((d) => (d === INF ? -1 : d));
  }
};

console.log(solution());

