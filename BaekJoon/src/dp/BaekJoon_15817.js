/**
 * BaekJoon_15817, 배수 공사
 *  - 문제 분류: 다이나믹 프로그래밍, 배낭 문제
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/15817.txt").toString().split("\n");
  const [N, x] = input[0].split(" ").map(Number);
  const dp = Array.from({ length: x + 1 }, () => 0);

  /* 메인 로직 */
  dp[0] = 1;
  for (let i=1; i<=N; i++) {
    const [len, cnt] = input[i].split(" ").map(Number);
    for (let j=x; j>0; j--) {
      for (let k=1; k<=cnt; k++) {
        const multipleLen = len * k;
        if (j - multipleLen < 0) break;
        dp[j] += dp[j - multipleLen];
      }
    }
  }

  /* 경우의 수 반환 */
  return dp[x];
}

console.log(solution());