/**
 * BaekJoon_24005, Cake
 *  - 문제 분류: 다이나믹 프로그래밍
 */
const solution = () => {
  /* 변수 관리 */
  const input = require('fs').readFileSync('./dev/stdin/24005.txt').toString().trim().split('\n');
  const T = +input[0];
  const limit = 10000;
  const dp = Array.from({ length: limit + 1 }, () => limit);
  const answer = [];

  /* 메인 로직 */
  for (let i = 1; i <= limit; i++) {
    const sqrt = Math.floor(Math.sqrt(i));
    if (sqrt * sqrt === i) {
      dp[i] = 1;
      continue;
    }

    for (let j = sqrt; j >= 1; j--) {
      const double = j * j;
      dp[i] = Math.min(dp[i], dp[double] + dp[i - double]);
    }
  }

  for (let i = 1; i <= T; i++) {
    const N = +input[i];
    answer.push(`Case #${i}: ${dp[N]}`);
  }

  /* 정답 반환 */
  return answer.join('\n');
};

console.log(solution());

