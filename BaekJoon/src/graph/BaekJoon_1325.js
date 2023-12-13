/**
 * BaekJoon_1325, 효율적인 해킹
 *  - 문제 분류: 그래프 탐색
 */
const solution = () => {
  class Node {
    constructor(idx, depth, start) {
      this.idx = idx;
      this.depth = depth;
      this.start = start;
    }
  }

  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/1325.txt").toString().split("\n");
  const [N, M] = input[0].split(" ").map(Number);
  const adjList = Array.from({ length: N + 1 }, () => [[], []]);
  let v = null;
  let dp = null;
  let max = 0;
  const list = [];
  const answer = [];

  /* 메인 로직 */
  for (let i = 1; i <= M; i++) {
    const [from, to] = input[i].split(" ").map(Number);
    adjList[from][0].push(to);
    adjList[to][1].push(from);
  }

  for (let i = 1; i <= N; i++) {
    if (adjList[i][0].length > 0) continue;
    v = Array.from({ length: N + 1 }, () => false);
    dp = Array.from({ length: N + 1 }, () => 0);
    v[i] = true;
    const count = dfs(i, i);

    if (count > max) max = count;
    list.push([i, count]);
  }

  for (const [idx, count] of list) {
    if (count === max) answer.push(idx);
  }

  /* 정답 반환 */
  return answer.join(" ");

  // bfs
  function dfs(node, start) {
    let count = 1;

    for (const next of adjList[node][1]) {
      if (v[next]) continue;
      if (dp[next] > 0) {
        count += dp[next];
        continue;
      }

      // console.log(node, "에서 ", next, "로 감");
      v[next] = true;
      count += dfs(next, start);
    }

    dp[node] = count;
    return count;
  }
};

console.log(solution());
