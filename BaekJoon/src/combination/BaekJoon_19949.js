/**
 * BaekJoon_19949, 영재의 시험
 *  1. 문제 분류 :
 *  2. 접근 방법
 *    - 5^10 = 대충 1억 이하이므로 모든 조합을 구하자
 *    - 이전, 이~전 값과 현재 값이 모두 동일하면 pass(백트래킹)
 */
const solution = () => {
  /* 입력값 */
  const input = require("fs")
    .readFileSync("./dev/stdin/19949.txt")
    .toString()
    .split(" ")
    .map((item) => +item);

  /* 변수 선언부 */
  let answer = 0;

  /* 메인 로직 */
  combination(0, 0, 0, 0);

  return answer;

  /* 메서드 */
  function combination(depth, sum, p1, p2) {
    if (depth === 10) {
      if (sum >= 5) answer++;
      return;
    }

    for (let i = 1; i <= 5; i++) {
      if (depth > 1 && i === p1 && i === p2) continue;

      if (input[depth] === i) {
        combination(depth + 1, sum + 1, p2, i);
      } else {
        combination(depth + 1, sum, p2, i);
      }
    }
  }
};

console.log(solution());
