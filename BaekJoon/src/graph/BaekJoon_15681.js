/**
 * BaekJoon_15681, 트리와 쿼리
 *  - 문제 분류: 그래프 탐색
 */
const solution = () => {
  /* 변수 관리 */
  const input = require('fs').readFileSync('./dev/stdin/15681.txt').toString().trim().split('\n');
  const [N, R, Q] = input[0].split(' ').map(Number);
  const adjList = Array.from({ length: N + 1 }, () => []);
  const counts = Array.from({ length: N + 1 }, () => 0);
  const v = Array.from({ length: N + 1 }, () => false);
  const answer = [];

  /* 메인 로직 */
  for (let i = 1; i < N; i++) {
    const [u, v] = input[i].split(' ').map(Number);
    adjList[u].push(v);
    adjList[v].push(u);
  }

  dfs(R);

  for (let i = N; i < N + Q; i++) {
    answer.push(counts[+input[i]]);
  }

  /* 정답 반환 */
  return answer.join('\n');

  // dfs
  function dfs(node) {
    if (v[node]) return counts[node];
    v[node] = true;
    counts[node] = 1;

    for (const next of adjList[node]) {
      if (v[next]) continue;
      counts[node] += dfs(next);
    }

    return counts[node];
  }
};

console.log(solution());

