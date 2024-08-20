/**
 * BaekJoon_18427, 함께 블록 쌓기
 *  - 문제 분류: 다이나믹 프로그래밍
 */
const solution = () => {
  /* 변수 관리 */
  const input = require('fs').readFileSync('./dev/stdin/18427.txt').toString().trim().split('\n');
  const [N, , H] = input[0].split(' ').map(Number);
  const dp = Array.from(new Array(H + 1), () => 0);
  const INF = 10007;

  /* 메인 로직 */
  dp[0] = 1;
  for (let i = 1; i <= N; i++) {
    const hs = input[i].split(' ').map(Number);
    hs.sort((a, b) => a - b);

    for (let j = H; j > 0; j--) {
      for (const h of hs) {
        if (j - h < 0) break;
        dp[j] = (dp[j] + dp[j - h]) % INF;
      }
    }
  }

  /* 정답 반환 */
  return dp[H];
};

console.log(solution());

