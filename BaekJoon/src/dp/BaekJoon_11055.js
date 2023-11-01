/**
 * BaekJoon_11055, 가장 큰 증가하는 부분 수열
 *  - 문제 분류: 다이나믹 프로그래밍, LIS
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/11055.txt").toString().trim().split("\n");
  const N = +input[0];
  const arr = input[1].split(" ").map((item) => +item);
  const dp = Array.from({ length: N }, () => 0);
  let answer = dp[0];

  /* 메인 로직 */
  for (let i=0; i<N; i++) {
    let max = arr[i];
    for (let j=i-1; j>=0; j--) {
      if (arr[j] >= arr[i]) continue;
      max = Math.max(max, arr[i] + dp[j]);
    }
    dp[i] = max;
    answer = Math.max(answer, dp[i])
  }

  /* 정답 반환 */
  return answer;
}

console.log(solution());