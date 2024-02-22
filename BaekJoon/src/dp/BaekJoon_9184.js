/**
 * BaekJoon_9184, 신나는 함수 실행
 *  - 문제 분류: 다이나믹 프로그래밍
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/9184.txt").toString().trim().split("\n");
  let pointer = 0;
  const MAX = 20;
  const dp = Array.from({ length: MAX + 1 }, () =>
    Array.from({ length: MAX + 1 }, () => Array.from({ length: MAX + 1 }, () => 0))
  );
  const answer = [];

  /* 메인 로직 */
  dp[0][0][0] = 1;
  while (true) {
    const [a, b, c] = input[pointer++].split(" ").map(Number);
    if (a === -1 && b === -1 && c === -1) break;
    answer.push(`w(${a}, ${b}, ${c}) = ${w(a, b, c)}`);
  }

  /* 정답 반환 */
  return answer.join("\n");

  // func
  function w(a, b, c) {
    if (a <= 0 || b <= 0 || c <= 0) {
      return 1;
    }

    if (a > 20 || b > 20 || c > 20) {
      return w(20, 20, 20);
    }

    if (dp[a][b][c] > 0) return dp[a][b][c];

    if (a < b && b < c) {
      dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
    } else {
      dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
    }

    return dp[a][b][c];
  }
};

console.log(solution());
