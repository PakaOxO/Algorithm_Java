/**
 * BaekJoon_1701, Cabeditor
 *  - 문제 분류: kmp 알고리즘
 */
const solution = () => {
  /* 변수 관리 */
  const str = require("fs").readFileSync("./dev/stdin/1701.txt").toString().trim();
  let answer = 0;

  /* 메인 로직 */
  getPi(str);

  /* 정답 반환 */
  return answer;

  // getPi
  function getPi(target) {
    const len = target.length;
    const pi = Array.from({ length: len }, () => 0);

    for (let i = 0; i < len; i++) {
      let k = 0;
      for (let j = i + 1; j < len; j++) {
        while (k > 0 && target.charAt(j) !== target.charAt(i + k)) {
          k = pi[k - 1];
        }

        if (target.charAt(j) === target.charAt(i + k)) {
          ++k;
          if (k > answer) {
            answer = k;
          }
        }
        pi[j - i] = k; // 이전 pi 덮어쓰기
      }
    }
  }
};

console.log(solution());

