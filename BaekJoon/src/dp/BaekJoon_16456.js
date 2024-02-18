/**
 * BaekJoon_16456, 하와와 대학생쨩 하와이로 가는 거시와요~
 *  - 문제 분류: 다이나믹 프로그래밍
 */
const solution = () => {
  /* 변수 관리 */
  const N = +require("fs").readFileSync("./dev/stdin/16456.txt").toString().trim();
  const dp = Array.from({ length: N }, () => 0);
  const v = Array.from({ length: N }, () => false);
  const INF = 1000000009;

  /* 메인 로직 */
  if (N >= 1) dp[N - 1] = 1;
  if (N >= 2) dp[N - 2] = 1;

  for (let i = N - 1; i >= 0; i--) {
    if (i + 1 < N) dp[i + 1] = (dp[i + 1] + dp[i]) % INF;
    if (i - 1 >= 0) dp[i - 1] = (dp[i - 1] + dp[i]) % INF;
    if (i - 2 >= 0) dp[i - 2] = (dp[i - 2] + dp[i]) % INF;
  }
  console.log(dp);

  /* 정답 반환 */
  return dp[0];
};

console.log(solution());

