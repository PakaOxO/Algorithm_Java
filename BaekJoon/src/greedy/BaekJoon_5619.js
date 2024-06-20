/**
 * BaekJoon_5619, 세 번째
 *  - 문제 분류: 그리디, 완전 탐색
 */
const solution = () => {
  /* 변수 관리 */
  const input = require('fs').readFileSync('./dev/stdin/5619.txt').toString().trim().split('\n');
  const N = +input[0];
  const arr = input.slice(1);
  let answer = [];

  /* 메인 로직 */
  arr.sort((a, b) => {
    if (a.length !== b.length) return a.length - b.length;

    for (let i = 0; i < a.length; i++) {
      const [ca, cb] = [+a.charAt(i), +b.charAt(i)];
      if (ca === cb) continue;
      return ca - cb;
    }
  });

  for (let i = 0; i < N && i <= 3; i++) {
    for (let j = 0; j < N && j <= 3; j++) {
      if (i === j) continue;
      answer.push(+(arr[i] + arr[j]));
    }
  }
  answer.sort((a, b) => a - b);

  /* 정답 반환 */
  return answer[2];
};

console.log(solution());

