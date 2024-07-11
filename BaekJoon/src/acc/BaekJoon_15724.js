/**
 * BaekJoon_15724, 주지수
 *  - 문제 분류: 누적합
 */
const solution = () => {
  /* 변수 관리 */
  const input = require('fs').readFileSync('./dev/stdin/15724.txt').toString().trim().split('\n');
  const [N, M] = input[0].split(' ').map(Number);
  const K = +input[N + 1];
  const acc = [];
  const answer = [];

  acc.push(Array.from({ length: M + 1 }, () => 0));
  for (let i = 1; i <= N; i++) {
    acc.push([0, ...input[i].split(' ').map(Number)]);
    for (let j = 1; j <= M; j++) {
      acc[i][j] = acc[i][j] + acc[i - 1][j] + acc[i][j - 1] - acc[i - 1][j - 1];
    }
  }

  /* 메인 로직 */
  for (let i = N + 2; i < N + K + 2; i++) {
    const [r1, c1, r2, c2] = input[i].split(' ').map(Number);
    answer.push(acc[r2][c2] - acc[r2][c1 - 1] - acc[r1 - 1][c2] + acc[r1 - 1][c1 - 1]);
  }

  /* 정답 반환 */
  return answer.join('\n');
};

console.log(solution());

