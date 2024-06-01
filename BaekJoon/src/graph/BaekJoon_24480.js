/**
 * BaekJoon_24480, 알고리즘 수업 - 깊이 우선 탐색 2
 *  - 문제 분류: 그래프 탐색
 */
const solution = () => {
  /* 변수 관리 */
  const input = require('fs').readFileSync('./dev/stdin/24480.txt').toString().trim().split('\n');
  const [N, M, R] = input[0].split(' ').map(Number);
  const adjList = Array.from({ length: N + 1 }, () => []);
  const v = Array.from({ length: N + 1 }, () => 0);

  for (let i = 1; i <= M; i++) {
    const [from, to] = input[i].split(' ').map(Number);
    adjList[from].push(to);
    adjList[to].push(from);
  }
  adjList.forEach((list) => list.sort((a, b) => b - a));

  /* 메인 로직 */
  let count = 1;
  v[R] = count;
  dfs(R, 1);

  /* 정답 반환 */
  return v.slice(1).join('\n');

  // dfs
  function dfs(node) {
    for (const next of adjList[node]) {
      if (v[next] > 0) continue;
      v[next] = ++count;
      dfs(next);
    }
  }
};

console.log(solution());

