/**
 * BaekJoon_1744, 수 묶기
 *  - 문제 분류: 그리디, 정렬
 */
const solution = () => {
  /* 변수 관리 */
  const input = require('fs').readFileSync('./dev/stdin/1744.txt').toString().trim().split('\n');
  const N = +input[0];
  const a = [];
  const b = [];
  let answer = 0;

  for (let i = 1; i <= N; i++) {
    const num = +input[i];
    if (num <= 0) {
      a.push(num);
    } else {
      b.push(num);
    }
  }

  /* 메인 로직 */
  a.sort((a, b) => a - b);
  b.sort((a, b) => b - a);

  for (let i = 0; i < a.length; i += 2) {
    if (i + 1 >= a.length) {
      answer += a[i];
      break;
    }

    if (a[i] * a[i + 1] > a[i] + a[i + 1]) {
      answer += a[i] * a[i + 1];
    } else {
      answer += a[i] + a[i + 1];
    }
  }

  for (let i = 0; i < b.length; i += 2) {
    if (i + 1 >= b.length) {
      answer += b[i];
      break;
    }

    if (b[i] * b[i + 1] > b[i] + b[i + 1]) {
      answer += b[i] * b[i + 1];
    } else {
      answer += b[i] + b[i + 1];
    }
  }

  /* 정답 반환 */
  return answer;
};

console.log(solution());

