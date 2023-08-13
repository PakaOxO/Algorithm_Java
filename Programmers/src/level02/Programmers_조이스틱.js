/**
 * Programmers_조이스틱
 *    1. 문제 분류 : 그리디, 구현
 *    2. 접근 방법
 *      -
 */
const solution = (name) => {
  /* 변수 초기화 */
  const len = name.length;
  let res = len;
  const diff = Array.from({ length: len }, (_, idx) => {
    const code = name.charCodeAt(idx) - 65;
    const d = Math.min(code, (26 - code) % 26);
    if (d === 0) res--;
    return d;
  });

  /* 메인 로직 */

  /* 정답 반환 */
  return dfs(0, res);

  /* 왼쪽으로 이동 */
  function dfs(pos, res) {
    let sum = 0;
    if (res === 0) {
      return sum;
    }

    const val = diff[pos];
    sum += val;
    if (res > 1) {
      const [left, right] = [(pos - 1 + len) % len, (pos + 1) % len];
      diff[pos] = 0;
      const s1 = dfs(left, res - 1) + 1;
      const s2 = dfs(right, res - 1) + 1;
      diff[pos] = val;
      sum += Math.min(s1, s2);
    }

    console.log(pos, sum);
    return sum;
  }
};

console.log(solution("JAZ"));
// console.log(solution("JEROEN"));
// console.log(solution("JAN"));
// console.log(solution("AABAA"));
// console.log(solution("AABABBBBB"));

