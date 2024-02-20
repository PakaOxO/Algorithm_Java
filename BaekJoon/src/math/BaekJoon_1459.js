/**
 * BaekJoon_1459, 걷기
 *  - 문제 분류: 수학, 많은 조건 분기
 */
const solution = () => {
  /* 변수 관리 */
  let [X, Y, W, S] = require("fs").readFileSync("./dev/stdin/1459.txt").toString().trim().split(" ").map(Number);
  let answer = 0;

  /* 메인 로직 */
  const d = Math.min(X, Y);
  answer += Math.min(d * 2 * W, d * S);
  X -= d;
  Y -= d;

  if (Y === 0) {
    if (X % 2 > 0) {
      X--;
      answer += W;
    }
    answer += Math.min(X * W, X * S);
  } else if (X === 0) {
    if (Y % 2 > 0) {
      Y--;
      answer += W;
    }
    answer += Math.min(Y * W, Y * S);
  }

  /* 정답 반환 */
  return answer;
};

console.log(solution());

