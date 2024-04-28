/**
 * BaekJoon_1965, 상자넣기
 *  - 문제 분류: 다이나믹 프로그래밍
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/1965.txt").toString().trim().split("\n");
  const N = +input[0];
  const box = input[1].split(" ").map(Number);
  const dp = Array.from({ length: N }, () => 0);
  let answer = 1;

  /* 메인 로직 */
  dp[0] = 1;
  for (let i = 1; i < N; i++) {
    dp[i] = 1;
    for (let j = i - 1; j >= 0; j--) {
      if (box[j] >= box[i]) continue;
      dp[i] = Math.max(dp[i], dp[j] + 1);
      answer = Math.max(answer, dp[i]);
    }
  }

  /* 정답 반환 */
  return answer;
};

console.log(solution());

