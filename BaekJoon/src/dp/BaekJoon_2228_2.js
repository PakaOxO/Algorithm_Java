/**
 * BaekJoon_2228, 구간 나누기
 *  - 문제 분류: 다이나믹 프로그래밍, 누적합
 */
const solution = () => {
  /* 변수 관리 */
  const input = require('fs').readFileSync('./dev/stdin/2228.txt').toString().trim().split('\n');
  const [N, M] = input[0].split(' ').map(Number);
  const acc = [0];
  const MIN = -32768 * N;
  const dp = Array.from({ length: N + 1 }, () => Array.from({ length: M + 1 }, (_, i) => (i === 0 ? 0 : MIN)));

  /* 메인 로직 */
  for (let i = 1; i <= N; i++) {
    const num = +input[i];
    acc.push(num + acc[i - 1]);
  }

  for (let i = 1; i <= N; i++) {
    for (let j = 1; j <= M; j++) {
      dp[i][j] = dp[i - 1][j];
      if (j === 1) dp[i][j] = Math.max(dp[i][j], acc[i]);

      for (let k = 0; k < i - 1; k++) {
        dp[i][j] = Math.max(dp[i][j], dp[k][j - 1] + acc[i] - acc[k + 1]);
      }
    }
  }

  /* 정답 반환 */
  return dp[N][M];
};

console.log(solution());

