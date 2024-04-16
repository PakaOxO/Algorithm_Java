/**
 * BaekJoon_10988.js, 팰린드롬인지 확인하기
 *  - 문제 분류: 문자열
 */
const solution = () => {
  /* 변수 관리 */
  const word = require("fs").readFileSync("./dev/stdin/10988.txt").toString().trim();
  const len = word.length;

  /* 메인 로직 */
  for (let i = 0; i < len; i++) {
    const j = len - i - 1;
    if (j <= i) break;
    if (word.charAt(i) === word.charAt(j)) continue;
    return 0;
  }

  return 1;
};

console.log(solution());

