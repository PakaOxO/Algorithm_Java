/**
 * BaekJoon_1339, 단어 수학
 *  - 문제 분류: 그리디
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/1339.txt").toString().trim().split("\n");
  const N = +input[0];
  const c = Array.from({ length: 26 }, () => 0);
  const arr = [];
  let answer = 0;

  /* 메인 로직 */
  for (let i = 1; i <= N; i++) {
    const str = input[i];
    const len = str.length;
    for (let j = 0; j < len; j++) {
      const code = str.charCodeAt(j) - 65;
      const pos = len - j - 1;
      c[code] += Math.pow(10, pos);
    }
  }

  for (let i = 0; i < 26; i++) {
    if (c[i] === 0) continue;
    arr.push([i, c[i]]);
  }

  arr.sort((a, b) => b[1] - a[1]);

  let num = 9;
  for (const [_, acc] of arr) {
    answer += acc * num--;
  }

  /* 정답 반환 */
  return answer;
};

console.log(solution());

