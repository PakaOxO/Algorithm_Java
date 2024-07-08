/**
 * BaekJoon_31861, 비밀번호 만들기
 *  - 문제 분류: 다이나믹 프로그래밍
 */
const solution = () => {
  /* 변수 관리 */
  const INF = 1000000007;
  const ALPHA_LEN = 26;
  const [N, M] = require('fs').readFileSync('./dev/stdin/31861.txt').toString().trim().split(' ').map(Number);
  const dp = Array.from({ length: M }, () => Array.from({ length: ALPHA_LEN }, () => 0));

  /* 메인 로직 */
  dp[0].fill(1);
  for (let i = 1; i < M; i++) {
    for (let j = 0; j < ALPHA_LEN; j++) {
      for (let k = 0; k <= j - N; k++) {
        dp[i][j] = (dp[i][j] + dp[i - 1][k]) % INF;
      }

      for (let k = j + N + (N === 0 ? 1 : 0); k < ALPHA_LEN; k++) {
        dp[i][j] = (dp[i][j] + dp[i - 1][k]) % INF;
      }
    }
  }

  /* 정답 반환 */
  return dp[M - 1].reduce((acc, curr) => (acc + curr) % INF, 0);
};

console.log(solution());
