/**
 * BaekJoon_2011, 암호코드
 *  - 문제 분류: 다이나믹 프로그래밍, 조합
 */
const solution = () => {
  /* 변수 관리 */
  const input = require('fs').readFileSync('./dev/stdin/2011.txt').toString().trim();
  const len = input.length;
  const dp = Array.from(new Array(len + 1), () => 0);
  const DIV = 1000000;

  /* 메인 로직 */
  if (+input.charAt(0) === 0) return 0;
  dp[0] = dp[1] = 1;

  for (let i = 2; i <= len; i++) {
    const overTen = +(input.charAt(i - 2) + input.charAt(i - 1));
    if (overTen >= 10 && overTen <= 26) {
      dp[i] = (dp[i] + dp[i - 2]) % DIV;
    }
    if (+input.charAt(i - 1) > 0) {
      dp[i] = (dp[i] + dp[i - 1]) % DIV;
    }

    if (dp[i] + dp[i - 1] === 0) break;
  }

  /* 정답 반환 */
  return dp[len];
};

console.log(solution());

