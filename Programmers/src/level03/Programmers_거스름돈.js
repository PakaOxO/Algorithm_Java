/**
 * Programmers_거스름돈
 *  - 문제 분류 : 다이나믹 프로그래밍
 */
const solution = (n, money) => {
  /* 변수 초기화 */
  const dp = Array.from({ length: n + 1 }, () => 0);
  const N = money.length;
  const INF = 1000000007;

  /* 메인 로직 */
  for (let i = 0; i < N; i++) {
    const m = money[i];
    for (let j = m; j <= n; j++) {
      if (j === m) {
        dp[j] = (dp[j] + 1) % INF;
        continue;
      }
      dp[j] = (dp[j] + dp[j - m]) % INF;
    }
  }

  /* 결과 반환 */
  return dp[n];
};

console.log(solution(5, [1, 2, 5]));

