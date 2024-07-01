/**
 * BaekJoon_2565, 전깃줄
 *  - 문제 분류: 다이나믹 프로그래밍
 */
const solution = () => {
  /* 변수 관리 */
  const input = require('fs').readFileSync('./dev/stdin/2565.txt').toString().trim().split('\n');
  const N = +input[0];
  const arr = input.slice(1).map((line) => line.split(' ').map(Number));
  const dp = Array.from({ length: N }, () => 0);

  arr.sort((a, b) => a[0] - b[0]);

  /* 메인 로직 */
  for (let i = 0; i < N; i++) {
    dp[i] = 1;
    for (let j = 0; j < i; j++) {
      if (arr[i][1] < arr[j][1]) continue;
      dp[i] = Math.max(dp[i], dp[j] + 1);
    }
  }

  /* 정답 반환 */
  return N - Math.max(...dp);
};

console.log(solution());

