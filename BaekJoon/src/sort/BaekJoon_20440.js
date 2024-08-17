/**
 * BaekJoon_20440, 🎵니가 싫어 싫어 너무 싫어 싫어 오지 마 내게 찝쩍대지마🎵 - 1
 *  - 문제 분류: 정렬, 자료구조
 */
const solution = () => {
  /* 변수 관리 */
  const input = require('fs').readFileSync('./dev/stdin/20440.txt').toString().trim().split('\n');
  const N = +input[0];
  const inout = [];
  const len = N * 2;
  let [prev, from, to] = [0, 0, 0];
  let count = 0;
  let max = 0;
  let answer = null;

  /* 메인 로직 */
  for (let i = 1; i <= N; i++) {
    const [ti, to] = input[i].split(' ').map(Number);
    inout.push([ti, 1]);
    inout.push([to, 0]);
  }
  inout.push([Number.MAX_SAFE_INTEGER, 0]);

  inout.sort((a, b) => {
    if (a[0] === b[0]) return a[1] - b[1];
    return a[0] - b[0];
  });

  for (let i = 0; i <= len; i++) {
    const [t, isIn] = inout[i];

    if (t > prev) {
      if (count > max) {
        max = count;
        from = prev;
        to = t;
      } else if (count === max && prev === to) {
        to = t;
      }
    }

    count += isIn ? 1 : -1;
    if (i + 1 < len && inout[i + 1][0] === t) continue;

    prev = inout[i][0];
  }

  answer = `${max}\n${from} ${to}`;
  /* 정답 반환 */
  return answer;
};

console.log(solution());

