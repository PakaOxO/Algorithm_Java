/**
 * BaekJoon_2225, 합분해
 *  - 문제 분류: 다이나믹 프로그래밍
 */
const solution = () => {
  /* 변수 관리 */
  const [N, K] = require("fs").readFileSync("./dev/stdin/2225.txt").toString().trim().split(" ").map(Number);
  const dp = Array.from({ length: K }, () => Array.from({ length: N + 1 }, () => 0));
  const INF = 1000000000;
  dp[0].fill(1);

  /* 메인 로직 */
  for (let i = 1; i < K; i++) {
    for (let j = 0; j <= N; j++) {
      for (let k = 0; k <= j; k++) {
        dp[i][j] = (dp[i][j] + dp[i - 1][j - k]) % INF;
      }
    }
  }

  /* 정답 반환 */
  return dp[K - 1][N];
};

console.log(solution());

