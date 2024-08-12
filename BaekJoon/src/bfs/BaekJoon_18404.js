/**
 * BaekJoon_18404, 현명한 나이트
 *  - 문제 분류: 너비 우선 탐색, 그래프 이론
 */
const solution = () => {
  /* 변수 관리 */
  const input = require('fs').readFileSync('./dev/stdin/18404.txt').toString().trim().split('\n');
  const [N, M] = input[0].split(' ').map(Number);
  const INF = Number.MAX_VALUE;
  const v = Array.from(new Array(N), () => Array.from(new Array(N), () => INF));
  const drc = [
    [-2, 1],
    [-2, -1],
    [-1, 2],
    [-1, -2],
    [1, 2],
    [1, -2],
    [2, -1],
    [2, 1],
  ];
  const answer = [];

  /* 메인 로직 */
  const [ir, ic] = input[1].split(' ').map(Number);
  v[ir - 1][ic - 1] = 0;
  const q = [[ir - 1, ic - 1]];

  while (q.length > 0) {
    const [r, c] = q.shift();
    for (const [dr, dc] of drc) {
      const [nr, nc] = [r + dr, c + dc];
      if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
      if (v[nr][nc] <= v[r][c] + 1) continue;
      v[nr][nc] = v[r][c] + 1;
      q.push([nr, nc]);
    }
  }

  for (let i = 2; i < M + 2; i++) {
    const [r, c] = input[i].split(' ').map(Number);
    answer.push(v[r - 1][c - 1]);
  }

  /* 정답 반환 */
  return answer.join(' ');
};

console.log(solution());

