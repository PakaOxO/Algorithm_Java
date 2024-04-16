/**
 * BaekJoon_10039, 평균 점수
 *  - 문제 분류: 수학, 구현
 */
const solution = () => {
  /* 변수 관리 */
  const score = require("fs").readFileSync("./dev/stdin/10039.txt").toString().trim().split("\n").map(Number);

  /* 정답 반환 */
  return score.reduce((acc, num) => (num >= 40 ? acc + num : acc + 40), 0) / 5;
};

console.log(solution());

