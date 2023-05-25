/*
  BaekJoon_28017, 게임을 클리어 하자
  Sketch Idea
    1. 현재 사용할 아이템과 다른 시간의 최소값을 읽어와 합산, dp
*/
const solution = () => {
  let fs = require("fs");
  let input = fs.readFileSync("./dev/stdin/28017.txt").toString().split("\n");

  /* 초기값 */
  const [N, M] = input[0].split(" ").map((item) => +item);
  const effciencies = [];
  const dp = new Array(N);
  for (let i = 1; i <= N; i++) {
    const efficiency = [];
    const nextLine = input[i].split(" ").map((item) => +item);
    for (let j = 0; j < M; j++) {
      efficiency.push(nextLine[j]);
    }
    effciencies.push(efficiency);
  }

  /* 메인 로직 */
  for (let i = 0; i < N; i++) {
    dp[i] = [];
    for (let j = 0; j < M; j++) {
      if (i === 0) {
        dp[i].push(effciencies[i][j]);
        continue;
      }
      let prevMin = Number.MAX_VALUE;
      for (let k = 0; k < M; k++) {
        if (k === j) continue;
        prevMin = Math.min(prevMin, dp[i - 1][k]);
      }
      dp[i].push(effciencies[i][j] + prevMin);
    }
  }

  return dp[N - 1].reduce((curr, acc) => Math.min(curr, acc));
};

console.log(solution());
