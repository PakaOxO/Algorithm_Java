/**
 * BaekJoon_17208, 카우버거 알바생
 *  - 문제 분류: 다이나믹 프로그래밍, 배낭 문제
 */
const solution = () => {
  /* 변수 관리 */
  const input = require('fs').readFileSync('./dev/stdin/17208.txt').toString().trim().split('\n');
  const [N, M, K] = input[0].split(' ').map(Number);
  const arr = [null, ...input.slice(1).map((line) => line.split(' ').map(Number))];
  const dp = Array.from({ length: N + 1 }, () =>
    Array.from({ length: M + 1 }, () => Array.from({ length: K + 1 }, () => 0))
  );

  /* 메인 로직 */
  for (let i = 1; i <= N; i++) {
    for (let j = 1; j <= M; j++) {
      for (let k = 1; k <= K; k++) {
        dp[i][j][k] = dp[i - 1][j][k];

        if (j >= arr[i][0] && k >= arr[i][1]) {
          dp[i][j][k] = Math.max(
            dp[i][j][k],
            Math.max(dp[i][j - arr[i][0]][k - arr[i][1]], dp[i - 1][j - arr[i][0]][k - arr[i][1]] + 1)
          );
        }
      }
    }
  }

  /* 정답 반환 */
  return dp[N][M][K];
};

console.log(solution());

