/**
 * BaekJoon_23029, 시식 코너는 나의 것
 *  - 문제 분류: 다이나믹 프로그래밍
 */
const solution = () => {
  /* 변수 관리 */
  const input = require('fs').readFileSync('./dev/stdin/23029.txt').toString().trim().split('\n');
  const N = +input[0];
  const dp = Array.from({ length: N }, () => Array.from({ length: 3 }, () => 0));
  const arr = input.slice(1).map((item) => +item);

  /* 메인 로직 */
  dp[0][1] = arr[0];
  for (let i = 1; i < N; i++) {
    dp[i][0] = Math.max(...dp[i - 1]);
    dp[i][1] = dp[i - 1][0] + arr[i];
    dp[i][2] = dp[i - 1][1] + Math.floor(arr[i] / 2);
  }

  /* 정답 반환 */
  return Math.max(...dp[N - 1]);
};

console.log(solution());

