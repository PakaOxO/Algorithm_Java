const solution = () => {
  const fs = require("fs");
  const input = fs.readFileSync("./dev/stdin/1106.txt").toString().split("\n");

  const [C, N] = input[0].split(" ").map((item) => +item);
  const INF = Number.MAX_VALUE;
  const limit = Math.min(1000, C + 100);
  const dp = new Array(limit + 1).fill(INF);
  dp[0] = 0;
  for (let i = 1; i <= N; i++) {
    const [price, cnt] = input[i].split(" ").map((item) => +item);
    if (dp[cnt] === 0) dp[cnt] = price;
    else dp[cnt] = Math.min(dp[cnt], price);
  }
  let min = INF;
  for (let i = limit; i > 0; i--) {
    min = Math.min(dp[i], min);
    dp[i] = min;
  }

  let answer = INF;
  for (let i = 1; i <= limit; i++) {
    for (let j = 1; j < i; j++) {
      if (dp[j] === INF) continue;
      dp[i] = Math.min(dp[i], dp[i - j] + dp[j]);
    }
    if (i >= C && dp[i] < answer) {
      answer = dp[i];
    }
  }
  return answer;
};

console.log(solution());
