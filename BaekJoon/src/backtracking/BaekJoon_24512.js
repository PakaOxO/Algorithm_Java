/**
 * BaekJoon_24512, Bottleneck Travelling Salesman Problem (Small)
 *  - 문제 분류: 백트래킹, 완전 탐색
 */
const solution = () => {
  /* 변수 관리 */
  const input = require('fs').readFileSync('./dev/stdin/24512.txt').toString().trim().split('\n');
  const [N, M] = input[0].split(' ').map(Number);
  const adjList = Array.from({ length: N + 1 }, () => []);
  const v = Array.from({ length: N + 1 }, () => false);
  let answer = [Infinity, ''];
  const comb = [];

  for (let i = 1; i <= M; i++) {
    const [u, v, c] = input[i].split(' ').map(Number);
    adjList[u].push([v, c]);
  }

  /* 메인 로직 */
  for (let i = 1; i <= N; i++) {
    v[i] = true;
    dfs(i, i, 1, [i], 0);
    v[i] = false;
  }

  if (answer[0] === Infinity) answer[0] = -1;

  /* 정답 반환 */
  return answer.join('\n').trim();

  // dfs
  function dfs(curr, start, depth, route, max) {
    if (depth === N) {
      let flag = 0;
      for (const [next, price] of adjList[curr]) {
        if (next === start) {
          flag = price;
          break;
        }
      }
      if (!flag) return;

      max = Math.max(max, flag);
      if (max >= answer[0]) return;

      answer[0] = max;
      answer[1] = route.join(' ');
      return;
    }

    for (const [next, price] of adjList[curr]) {
      if (v[next]) continue;
      v[next] = true;
      dfs(next, start, depth + 1, [...route, next], Math.max(max, price));
      v[next] = false;
    }
  }
};

console.log(solution());

