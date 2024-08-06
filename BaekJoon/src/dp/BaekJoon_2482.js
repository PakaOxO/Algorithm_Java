/**
 * BaekJoon_2482, 색상환
 *  - 문제 분류: 다이나믹 프로그래밍
 */
const solution = () => {
  /* 변수 관리 */
  const [N, K] = require('fs').readFileSync('./dev/stdin/2482.txt').toString().trim().split('\n').map(Number);
  const dp = Array.from(new Array(N + 1), (_, i) =>
    Array.from(new Array(K + 1), (_, j) => (j === 0 ? 1 : j === 1 ? i : 0))
  );
  const INF = 1000000003;

  /* 메인 로직 */
  for (let i = 2; i < N; i++) {
    for (let j = 2; j <= K; j++) {
      dp[i][j] = (dp[i - 2][j - 1] + dp[i - 1][j]) % INF;
    }
  }

  /* 정답 반환 */
  return (dp[N - 1][K] + dp[N - 3][K - 1]) % INF;
};

console.log(solution());

