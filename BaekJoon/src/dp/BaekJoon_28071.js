const solution = () => {
  const fs = require("fs");
  const input = fs.readFileSync("./dev/stdin/28071.txt").toString().split("\n");

  const [N, M, K] = input[0].split(" ").map((item) => +item);
  const candies = input[1].split(" ").map((item) => +item);

  const dp = new Array(M + 1).fill(0);
  let answer = 0;

  for (let i = 1; i <= M; i++) {
    for (let j = 0; j < i; j++) {
      for (let k = 0; k < N; k++) {
        const next = dp[j] + candies[k];
        if (next % K > 0) continue;
        dp[i] = Math.max(dp[i], next);
        answer = Math.max(dp[i], answer);
      }
    }
  }

  console.log(dp);
  return answer;
};

console.log(solution());
