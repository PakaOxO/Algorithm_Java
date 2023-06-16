const solution = () => {
  const fs = require("fs");
  const input = fs.readFileSync("./dev/stdin/28071.txt").toString().split("\n");

  const [N, M, K] = input[0].split(" ").map((item) => +item);
  const candies = input[1].split(" ").map((item) => +item);
  candies.sort((a, b) => a - b);

  const dp = [];
  dp.push(new Array(K).fill(0));

  const getDp = (box) => {
    for (let i = 0; i < K; i++) {
      for (let j = 0; j < K; j++) {
        const res = (i + j) % K;
        if (dp[box - 1][i] < 1 || dp[1][j] < 1) continue;
        dp[box][res] = Math.max(dp[box][res], dp[box - 1][i] + dp[1][j]);
      }
    }
  };

  let answer = 0;
  for (let i = 1; i <= M; i++) {
    dp.push(new Array(K).fill(0));

    if (i === 1) {
      for (let j = 0; j < N; j++) {
        const res = candies[j] % K;
        dp[i][res] = candies[j];
      }
    } else {
      getDp(i);
    }
    answer = Math.max(answer, dp[i][0]);
  }

  return answer < K ? 0 : answer;
};

console.log(solution());
