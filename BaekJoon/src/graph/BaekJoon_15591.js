/**
 * BaekJoon_15591, MooTube(Silver)
 *  - 문제 분류: 그래프 탐색, bfs
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/15591.txt").toString().split("\n");
  const [N, Q] = input[0].split(" ").map((item) => +item);
  const adjList = Array.from({ length: N + 1 }, () => []);
  const INF = Number.MAX_SAFE_INTEGER;
  let answer = [];

  /* 메인 로직 */
  let i = 1;
  for (; i <= N - 1; i++) {
    const [s, e, d] = input[i].split(" ").map((item) => +item);
    adjList[s].push([e, d]);
    adjList[e].push([s, d]);
  }

  for (let end = i + Q; i < end; i++) {
    const [ki, vi] = input[i].split(" ").map((item) => +item);
    bfs(ki, vi);
  }

  /* 정답 반환 */
  return answer.join("\n");

  /**
   * bfs
   */
  function bfs(k, start) {
    const queue = [[start, INF]];
    const visited = Array.from({ length: N + 1 }, () => false);
    visited[start] = true;

    let count = 0;
    while (queue.length > 0) {
      const [curr, min] = queue.shift();

      for (let [next, d] of adjList[curr]) {
        if (visited[next]) continue;
        const minDist = Math.min(min, d);
        if (minDist < k) continue;

        count++;
        visited[next] = true;
        queue.push([next, minDist]);
      }
    }

    answer.push(count);
  }
};

console.log(solution());

