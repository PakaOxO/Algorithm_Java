/**
 * BaekJoon_11057, 오르막 수
 *  - 문제 분류: 다이나믹 프로그래밍
 */
const solution = () => {
  /* 변수 관리 */
  const N = +require('fs').readFileSync('./dev/stdin/11057.txt').toString().trim().split('\n');
  const dp = Array.from({ length: N }, () => Array.from({ length: 10 }, () => 0));
  const MOD = 10007;

  /* 메인 로직 */
  dp[0].fill(1);
  for (let i = 1; i < N; i++) {
    let acc = 0;
    for (let j = 0; j < 10; j++) {
      acc = (acc + dp[i - 1][j]) % MOD;
      dp[i][j] = acc;
    }
  }

  /* 정답 반환 */
  return dp[N - 1].reduce((acc, curr) => (acc + curr) % MOD, 0);
};

console.log(solution());

