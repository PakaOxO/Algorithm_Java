/**
 * BaekJoon_1543, 문서 검색
 *  - 문제 분류: 문자열
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/1543.txt").toString().trim().split("\n");
  const [str, target] = input;
  let answer = 0;

  /* 메인 로직 */
  kmp(str, target);

  /* 정답 반환 */
  return answer;

  // kmp
  function kmp(str, target) {
    const pi = getPi(target);
    const len = str.length;
    let j = 0;

    for (let i = 0; i < len; i++) {
      while (j > 0 && str.charAt(i) !== target.charAt(j)) {
        j = pi[j - 1];
      }

      if (str.charAt(i) === target.charAt(j)) {
        j++;

        if (j === target.length) {
          answer++;
          j = 0;
        }
      }
    }
  }

  function getPi(target) {
    const len = target.length;
    let j = 0;
    const arr = Array.from({ length: len }, () => 0);

    for (let i = 1; i < len; i++) {
      while (j > 0 && target.charAt(i) !== target.charAt(j)) {
        j = arr[j - 1];
      }

      if (target.charAt(i) === target.charAt(j)) {
        arr[i] = ++j;
      }
    }

    return arr;
  }
};

console.log(solution());

