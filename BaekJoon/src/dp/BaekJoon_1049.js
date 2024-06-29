/**
 * BaekJoon_1049, 기타줄
 *  - 문제 분류: 다이나믹 프로그래밍
 */
const solution = () => {
  /* 변수 관리 */
  const input = require('fs').readFileSync('./dev/stdin/1049.txt').toString().trim().split('\n');
  const [N, M] = input[0].split(' ').map(Number);
  const INF = Number.MAX_SAFE_INTEGER;
  const dp = Array.from({ length: N + 1 }, () => INF);
  let minPackPrice = INF;
  let minPrice = INF;
  let answer = INF;

  /* 메인 로직 */
  for (let i = 1; i <= M; i++) {
    const [packPrice, price] = input[i].split(' ').map(Number);
    if (packPrice < minPackPrice) minPackPrice = packPrice;
    if (price < minPrice) minPrice = price;
  }

  dfs(N);

  /* 정답 반환 */
  return dp[N];

  // dfs
  function dfs(count) {
    if (count <= 0) return 0;
    if (dp[count] < INF) return dp[count];
    dp[count] = Math.min(dfs(count - 6) + minPackPrice, dfs(count - 1) + minPrice);
    return dp[count];
  }
};

console.log(solution());

