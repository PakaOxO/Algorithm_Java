const solution = () => {
  const fs = require("fs");
  const input = fs.readFileSync("./dev/stdin/28071.txt").toString().split("\n");

  const [N, M, K] = input[0].split(" ").map((item) => +item);
  const candies = input[1].split(" ").map((item) => +item);

  let answer = 0;
  const dp = [];
  dp.push(new Array(K).fill(0));

  const bfs = (box, res) => {
    return 0;
  };

  for (let i = 1; i <= M; i++) {
    dp[i] = [];
    for (let j = 0; j < K; j++) {
      dp[i].push(bfs(i, j));
    }
  }

  return answer;
};

console.log(solution());
