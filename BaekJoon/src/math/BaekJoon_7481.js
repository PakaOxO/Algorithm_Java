/**
 * BaekJoon_7481, ATM 놀이
 *  - 문제 분류: 수학
 */
const solution = () => {
  /* 변수 관리 */
  const input = require('fs').readFileSync('./dev/stdin/7481.txt').toString().trim().split('\n');
  const T = +input[0];
  const answer = [];

  /* 메인 로직 */
  for (let tc = 1; tc <= T; tc++) {
    let [a, b, t] = input[tc].split(' ').map(Number);
    let [c1, c2] = [-1, -1];
    const set = new Set();
    if (a <= b) {
      const share = Math.floor(t / b);
      for (let i = share; i >= 0; i--) {
        const res = (t - i * b) % a;
        if (set.has(res)) break;
        set.add(res);
        if (res === 0) {
          c1 = (t - i * b) / a;
          c2 = i;
          break;
        }
      }
    } else {
      const share = Math.floor(t / a);
      for (let i = share; i >= 0; i--) {
        const res = (t - i * a) % b;
        if (set.has(res)) break;
        set.add(res);
        if (res === 0) {
          c1 = i;
          c2 = (t - i * a) / b;
          break;
        }
      }
    }

    answer.push(c1 < 0 ? 'Impossible' : `${c1} ${c2}`);
  }

  /* 정답 반환 */
  return answer.join('\n');
};

console.log(solution());

