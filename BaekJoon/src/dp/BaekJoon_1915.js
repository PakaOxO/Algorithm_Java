/**
 * BaekJoon_1915, 가장 큰 정사각형
 *  - 문제 분류: 다이나믹 프로그래밍(누적합으로도 해결, acc경로)
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/1915.txt").toString().trim().split("\n");
  const [n, m] = input[0].split(" ").map(Number);
  const dp = input.slice(1).map((line) => line.split("").map(Number));
  let answer = 0;

  /* 메인 로직 */
  for (let i = 0; i < n; i++) {
    for (let j = 0; j < m; j++) {
      if (i === 0 || j === 0 || !dp[i][j]) {
        answer = Math.max(answer, dp[i][j]);
        continue;
      }
      dp[i][j] += Math.min(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]);
      answer = Math.max(answer, dp[i][j]);
    }
  }

  /* 정답 반환 */
  return answer * answer;
};

console.log(solution());

