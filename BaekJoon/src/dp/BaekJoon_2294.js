/**
 * BaekJoon_2294, 동전 2
 *  - 문제 분류: 다이나믹 프로그래밍
 */
const solution = () => {
  /* 변수 관리 */
  const input = require('fs').readFileSync('./dev/stdin/2294.txt').toString().trim().split('\n');
  const [N, K] = input[0].split(' ').map(Number);
  const coin = input.slice(1).map(Number);
  const INF = K + 1;
  const dp = Array.from({ length: K + 1 }, () => INF);

  /* 메인 로직 */
  dp[0] = 0;
  for (let i = 1; i <= N; i++) {
    const value = coin[i - 1];
    for (let j = 0; j <= K; j++) {
      if (j < value) continue;
      dp[j] = Math.min(dp[j], dp[j - value] + 1);
    }
  }

  /* 정답 반환 */
  return dp[K] === INF ? -1 : dp[K];
};

console.log(solution());

