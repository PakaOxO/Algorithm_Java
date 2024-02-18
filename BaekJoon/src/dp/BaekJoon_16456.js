/**
 * BaekJoon_16456, 하와와 대학생쨩 하와이로 가는 거시와요~
 *  - 문제 분류: 다이나믹 프로그래밍
 */
const solution = () => {
  /* 변수 관리 */
  const N = +require("fs").readFileSync("./dev/stdin/16456.txt").toString().trim();
  const dp = Array.from({ length: N }, () => 0);
  const INF = 1000000009;

  /* 메인 로직 */
  dp[0] = 1;
  if (N > 1) dp[1] = 1;
  if (N > 2) dp[2] = 1;

  for (let i = 3; i < N; i++) {
    dp[i] = (dp[i - 1] + dp[i - 3]) % INF;
  }

  /* 정답 반환 */
  return N > 2 ? (dp[N - 1] + dp[N - 3]) % INF : dp[N - 1];
};

console.log(solution());
