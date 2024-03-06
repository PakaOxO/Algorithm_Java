/**
 * BaekJoon_13398, 연속합 2
 *  - 문제 분류: 다이나믹 프로그래밍
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/13398.txt").toString().trim().split("\n");
  const N = +input[0];
  const arr = input[1].split(" ").map(Number);
  const dp = [[arr[0], arr[0]]];
  let answer = -1001;

  /* 메인 로직 */
  for (let i = 1; i < N; i++) {
    dp.push([]);

    dp[i].push(Math.max(dp[i - 1][0] + arr[i], arr[i]));
    dp[i].push(Math.max(dp[i - 1][0], dp[i - 1][1] + arr[i]));
  }

  for (let i = 0; i < N; i++) {
    answer = Math.max(answer, ...dp[i]);
  }

  /* 정답 반환 */
  return answer;
};

console.log(solution());
