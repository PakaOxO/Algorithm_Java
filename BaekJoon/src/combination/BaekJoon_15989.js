/**
 * BaekJoon_15989, 1,2,3 더하기 4
 *  - 문제 분류: 조합, 다이나믹 프로그래밍
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/15989.txt").toString().split("\n");
  const N = +input[0];
  const MAX_NUM = 10000;
  const dp = Array.from({ length: MAX_NUM + 1 }, () => 0);
  let answer = [];

  /* 메인 로직 */
  dp[0] = 1;
  for (let i = 1; i <= 3; i++) {
    for (let j = 1; j <= MAX_NUM; j++) {
      if (j - i < 0) continue;
      dp[j] += dp[j - i];
    }
  }

  for (let i = 0; i < N; i++) {
    answer.push(dp[+input[i + 1]]);
  }

  /* 정답 반환 */
  return answer.join("\n");
};

console.log(solution());
