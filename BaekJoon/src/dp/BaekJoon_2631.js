/**
 * BaekJoon_2631, 줄 세우기
 *    1. 문제 분류 : 다이나믹 프로그래밍
 *    2. 접근 방법
 *      - 가장 긴 증가하는 부분 수열을 구한 다음 전체 길이에서 가장 긴 증가하는 부분 수열 길이 만큼을 빼면 정답
 */
const solution = () => {
  /* 변수 초기화 */
  const input = require("fs").readFileSync("./dev/stdin/2631.txt").toString().trim().split("\n");
  const N = +input[0];
  const arr = [-1];
  const dp = Array.from({ length: N + 1 }, () => 0);
  dp[0][0] = -1;
  for (let i = 1; i <= N; i++) {
    arr.push(+input[i]);
  }
  let answer = N;

  for (let i = 1; i <= N; i++) {
    let maxIdx = i - 1;
    let max = -1;
    for (let j = i - 1; j >= 0; j--) {
      if (arr[j] > arr[i]) continue;
      if (dp[j] > max) {
        max = dp[j];
        maxIdx = j;
      }
    }
    dp[i] = dp[maxIdx] + 1;

    answer = Math.min(answer, N - dp[i]);
  }

  return answer;
};

console.log(solution());
