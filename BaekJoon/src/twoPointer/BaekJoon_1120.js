/**
 * BaekJoon_1120, 문자열
 *  - 문제 분류 : 슬라이딩 윈도우, 문자열
 */
const solution = () => {
  /* 변수 초기화 */
  const [A, B] = require("fs").readFileSync("./dev/stdin/1120.txt").toString().trim().split(" ");
  const [lenA, lenB] = [A.length, B.length];
  let answer = lenA;

  /* 메인 로직 */
  for (let i = 0; i <= lenB - lenA; i++) {
    if (answer === 0) break;
    const flag = check(i, i + lenA);
    if (flag < answer) {
      answer = flag;
    }
  }

  /* 결과 반환 */
  return answer;

  /**
   * left, right 사이의 문자열 비교하여 다른 개수 반환
   */
  function check(left, right) {
    let count = 0;
    for (let i = left; i < right; i++) {
      if (A.charAt(i - left) !== B.charAt(i)) count++;
    }
    return count;
  }
};

console.log(solution());
