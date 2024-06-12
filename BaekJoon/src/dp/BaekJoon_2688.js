/**
 * BaekJoon_2688, 줄어들지 않아
 *  - 문제 분류: 다이나믹 프로그래밍
 */
const solution = () => {
  /* 변수 관리 */
  const input = require('fs').readFileSync('./dev/stdin/2688.txt').toString().trim().split('\n');
  const T = +input[0];
  const LIMIT = 64;
  const dp = Array.from({ length: LIMIT }, () => Array.from({ length: 10 }, () => 0));
  const answer = [];

  /* 메인 로직 */
  dp[0].fill(1);
  for (let i = 1; i < LIMIT; i++) {
    let acc = 0;
    for (let j = 0; j < 10; j++) {
      acc += dp[i - 1][j];
      dp[i][j] = acc;
    }
  }

  for (let i = 1; i <= T; i++) {
    const n = +input[i];
    answer.push(dp[n - 1].reduce((acc, curr) => acc + curr, 0));
  }

  /* 정답 반환 */
  return answer.join('\n');
};

console.log(solution());
