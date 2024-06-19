/**
 * BaekJoon_5534, 간판
 *  - 문제 분류: 완전 탐색, 문자열
 */
const solution = () => {
  /* 변수 관리 */
  const input = require('fs').readFileSync('./dev/stdin/5534.txt').toString().trim().split('\n');
  const N = +input[0];
  const title = input[1];
  const list = input.slice(2);
  let answer = 0;

  /* 메인 로직 */
  for (let i = 0; i < N; i++) {
    const old = list[i];
    const len = old.length;
    loop: for (let j = 0; j < len; j++) {
      for (let k = 1; k < len - 1; k++) {
        const word = makeWord(old, j, k, title.length);
        if (word === title) {
          answer++;
          break loop;
        }
      }
    }
  }

  /* 정답 반환 */
  return answer;

  function makeWord(target, start, gap, count) {
    let str = '';
    for (let i = start; i < target.length; i += gap) {
      if (str.length === count) break;
      str += target.charAt(i);
    }
    return str;
  }
};

console.log(solution());

