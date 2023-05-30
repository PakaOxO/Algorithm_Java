const solution = () => {
  const fs = require("fs");
  const input = fs.readFileSync("./dev/stdin/11052.txt").toString().split("\n");

  /* 초기값 */
  const N = +input[0];
  const arr = input[1].split(" ").map((item) => +item);

  const dp = new Array(N + 1);
  dp[0] = 0;
  for (let i = 1; i <= N; i++) {
    dp[i] = arr[i - 1];
    for (let j = 1; j < i; j++) {
      dp[i] = Math.max(dp[i], dp[i - j] + dp[j]);
    }
  }
  return dp[N];
};

console.log(solution());
