/**
 * BaekJoon_14728, 벼락치기
 *  - 문제 분류: 다이나믹 프로그래밍, 배낭 문제
 */
const solution = () => {
  /* 변수 관리 */
  const input = require('fs').readFileSync('./dev/stdin/14728.txt').toString().trim().split('\n');
  const [N, T] = input[0].split(' ').map(Number);
  const arr = input.slice(1).map((line) => line.split(' ').map(Number));
  const dp = Array.from({ length: N + 1 }, () => Array.from({ length: T + 1 }, () => 0));

  /* 메인 로직 */
  for (let i = 1; i <= N; i++) {
    const [K, S] = arr[i - 1];
    for (let j = 1; j <= T; j++) {
      dp[i][j] = dp[i - 1][j];
      if (j < K) continue;
      dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - K] + S);
    }
  }

  /* 정답 반환 */
  return dp[N][T];
};

console.log(solution());
