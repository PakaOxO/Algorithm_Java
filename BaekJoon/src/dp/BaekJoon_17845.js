/**
 * BaekJoon_17845, 수강 과목
 *   - 문제 분류 : 다이나믹 프로그래밍, 배낭 문제
 */
const solution = () => {
  /* 변수 선언부 */
  const input = require("fs").readFileSync("./dev/stdin/17845.txt").toString().trim().split("\n");
  const [N, K] = input[0].split(" ").map((item) => +item);
  const dp = Array.from({ length: N + 1 }, () => 0);

  /* 메인 로직 */
  for (let i = 1; i <= K; i++) {
    const [point, time] = input[i].split(" ").map((item) => +item);
    for (let j = N; j > 0; j--) {
      if (j >= time) {
        dp[j] = Math.max(dp[j], dp[j - time] + point);
      }
    }
  }

  /* 정답 반환 */
  return dp[N];
};

console.log(solution());

