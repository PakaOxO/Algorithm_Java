/**
 * BaekJoon_1522, 문자열 교환
 *  - 문제 분류 : 슬라이딩 윈도우, 문자열
 */
const solution = () => {
  /* 변수 초기화 */
  const str = require("fs").readFileSync("./dev/stdin/1522.txt").toString().trim();
  const len = str.length;
  let answer = len;
  let countA = 0;

  /* 메인 로직 */
  for (let i = 0; i < len; i++) {
    if (str.charAt(i) === "a") countA++;
  }

  for (let i = 0; i < len; i++) {
    const flag = check(i, i + countA);
    if (flag < answer) {
      answer = flag;
    }
  }

  /* 정답 반환 */
  return answer;

  /**
   * left ~ right 범위의 'a'의 개수 반환
   */
  function check(left, right) {
    let count = 0;
    for (let i = left; i < right; i++) {
      const idx = i % len;
      if (str.charAt(idx) !== "a") count++;
    }
    return count;
  }
};

console.log(solution());
