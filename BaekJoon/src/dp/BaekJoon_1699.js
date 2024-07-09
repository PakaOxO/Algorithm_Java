/**
 * BaekJoon_1699, 제곱수의 합
 *  - 문제 분류: 다이나믹 프로그래밍, 수학
 */
const solution = () => {
  /* 변수 관리 */
  const N = +require('fs').readFileSync('./dev/stdin/1699.txt').toString().trim();
  const dp = Array.from({ length: N + 1 }, () => N + 1);

  /* 메인 로직 */
  dp[0] = 0;
  getDp(N);

  /* 정답 반환 */
  return dp[N];

  // getDp
  function getDp(n) {
    if (n === 0) return dp[0];
    if (dp[n] <= N) return dp[n];

    const sqrt = Math.floor(Math.sqrt(n));
    if (sqrt * sqrt === n) {
      dp[n] = 1;
      return dp[n];
    }

    for (let i = sqrt; i >= 1; i--) {
      const pow = i * i;
      dp[pow] = 1;
      dp[n] = Math.min(dp[n], getDp(n - pow) + 1);
    }

    return dp[n];
  }
};

console.log(solution());
