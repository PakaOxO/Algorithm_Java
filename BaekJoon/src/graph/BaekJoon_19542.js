/**
 * BaekJoon_19542, 전단지 돌리기
 *  - 문제 분류: 그래프 탐색, 트리
 */
const solution = () => {
  /* 변수 관리 */
  const input = require('fs').readFileSync('./dev/stdin/19542.txt').toString().trim().split('\n');
  const [N, S, D] = input[0].split(' ').map(Number);
  const adjList = Array.from({ length: N + 1 }, () => []);
  const v = Array.from({ length: N + 1 }, () => false);
  let count = 0;

  /* 메인 로직 */
  for (let i = 1; i < N; i++) {
    const [s, e] = input[i].split(' ').map(Number);
    adjList[s].push(e);
    adjList[e].push(s);
  }

  v[S] = true;
  dfs(S, 0);
  if (count === 0) count++;

  /* 정답 반환 */
  return (count - 1) * 2;

  // dfs
  function dfs(node) {
    let d = 0;

    for (const next of adjList[node]) {
      if (v[next]) continue;
      v[next] = true;
      d = Math.max(d, dfs(next));
    }

    if (d >= D) {
      count += 1;
    }

    return d + 1;
  }
};

console.log(solution());

