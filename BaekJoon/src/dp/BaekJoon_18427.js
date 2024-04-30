/**
 * BaekJoon_18427, 함께 블록 쌓기
 *  - 문제 분류: 다이나믹 프로그래밍
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/18427.txt").toString().trim().split("\n");
  const [N, M, H] = input[0].split(" ").map(Number);
  const blocks = [];
  const dp = Array.from({ length: N + 1 }, () => Array.from({ length: H + 1 }, () => 0));
  const INF = 10007;

  for (let i = 1; i <= N; i++) {
    blocks.push(input[i].split(" ").map(Number));
  }
  dp[0][0] = 1;

  /* 메인 로직 */
  for (let i = 1; i <= N; i++) {
    for (let j = 0; j <= H; j++) {
      dp[i][j] += dp[i - 1][j];

      for (const h of blocks[i - 1]) {
        if (j - h < 0) continue;
        dp[i][j] = (dp[i][j] + dp[i - 1][j - h]) % INF;
      }
    }
  }

  /* 정답 반환 */
  return dp[N][H];
};

console.log(solution());

