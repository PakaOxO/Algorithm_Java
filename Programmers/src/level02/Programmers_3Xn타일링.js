/**
 * Programmers_3Xn 타일림
 *    1. 문제 분류 : 다이나믹 프로그래밍
 *    2. 접근 방법
 *      -
 */
const solution = (n) => {
  const INF = 1000000007;
  const dp = Array.from({ length: n + 1 }, () => 0);
  dp[0] = 1;
  if (n % 2 === 1) {
    return 0;
  } else {
    n = ~~(n / 2);
    for (let i = 1; i <= n; i++) {
      dp[i] = (dp[i] + dp[i - 1] * 3) % INF;
      for (let j = 2; j <= i; j++) {
        dp[i] = (dp[i] + dp[i - j] * 2) % INF;
      }
    }
  }

  return dp[n];
};

console.log(solution(2));
console.log(solution(4));
console.log(solution(6));
console.log(solution(8));

