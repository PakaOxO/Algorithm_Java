const solution = (n) => {
  const INF = 1000000007;
  const dp = new Array(n + 1);
  dp[1] = 1;
  dp[2] = 2;

  for (let i = 3; i <= n; i++) {
    dp[i] = (dp[i - 1] + dp[i - 2]) % INF;
  }

  return dp[n];
};

console.log(solution(60000));
