/**
 * BaekJoon_10844, 쉬운 계단 수
 *  - 문제 분류: 다이나믹 프로그래밍
 */
const solution = () => {
  /* 변수 관리 */
  const N = +require("fs").readFileSync("./dev/stdin/10844.txt").toString().trim();
  const dp = Array.from({ length: N }, () => Array.from({ length: 10 }, () => 0));
  const INF = 1000000000;
  let answer = 0;

  /* 메인 로직 */
  for (let i = 1; i < 10; i++) {
    dp[0][i] = 1;
  }

  for (let i = 1; i < N; i++) {
    for (let j = 0; j < 10; j++) {
      if (j - 1 >= 0) dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % INF;
      if (j + 1 < 10) dp[i][j] = (dp[i][j] + dp[i - 1][j + 1]) % INF;
    }
  }

  answer = dp[N - 1].reduce((acc, sum) => (acc + sum) % INF, 0);

  /* 정답 반환 */
  return answer;
};

console.log(solution());

