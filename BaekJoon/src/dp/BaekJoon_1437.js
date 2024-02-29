/**
 * BaekJoon_1437, 수 분해
 *  - 문제 분류: 다이나믹 프로그래밍, 그리디
 */
const solution = () => {
  /* 변수 관리 */
  const N = +require("fs").readFileSync("./dev/stdin/1437.txt").toString().trim();
  const dp = Array.from({ length: N + 1 }, () => 0);
  const INF = 10007;

  /* 메인 로직 */
  dp[1] = 1;
  dp[2] = 2;
  dp[3] = 3;
  dp[4] = 4;
  for (let i = 5; i <= N; i++) {
    dp[i] = (dp[i - 3] * 3) % INF;
  }

  /* 정답 반환 */
  return dp[N];
};

console.log(solution());

