/**
 * BaekJoon_2156, 포도주 시식
 *  - 문제 분류: 다이나믹 프로그래밍
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/2156.txt").toString().split("\n");
  const N = +input[0];
  const arr = [];
  const dp = [];

  /* 메인 로직 */
  for (let i=1; i<=N; i++) {
    arr.push(+input[i]);
    dp.push([0, 0, 0]);
  }

  dp[0][1] = arr[0];
  for (let i=1; i<N; i++) {
    dp[i][0] = Math.max(...dp[i - 1]);
    dp[i][1] = arr[i] + dp[i - 1][0];
    dp[i][2] = arr[i] + dp[i - 1][1];
  }

  /* 정답 반환 */
  return Math.max(...dp[N - 1]);
}

console.log(solution());