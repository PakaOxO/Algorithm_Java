/**
 * BaekJoon_10164, 격자상의 경로
 *  - 문제 분류: 그래프 탐색, 메모이제이션
 */
const solution = () => {
  /* 변수 관리 */
  const [N, M, K] = require("fs").readFileSync("./dev/stdin/10164.txt").toString().trim().split(" ");
  const x = Math.floor((K - 1) / M);
  const y = K - x * M - 1;
  const dp = Array.from({ length: N }, () => Array.from({ length: M }, () => [0, 0]));
  dp[0][0][0] = 1;

  /* 메인 로직 */
  for (let i = 0; i < N; i++) {
    for (let j = 0; j < M; j++) {
      if (j - 1 >= 0) {
        dp[i][j][0] += dp[i][j - 1][0];
        dp[i][j][1] += dp[i][j - 1][1];
        if (i === x && j === y) {
          dp[i][j][1] += dp[i][j - 1][0];
        }
      }

      if (i - 1 >= 0) {
        dp[i][j][0] += dp[i - 1][j][0];
        dp[i][j][1] += dp[i - 1][j][1];
        if (i === x && j === y) {
          dp[i][j][1] += dp[i - 1][j][0];
        }
      }
    }
  }

  /* 정답 반환 */
  return K > 0 ? dp[N - 1][M - 1][1] : dp[N - 1][M - 1][0];
};

console.log(solution());

