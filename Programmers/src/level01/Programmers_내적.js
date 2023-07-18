/**
 * Programmers_내적
 *  1. 문제 분류 : 수학
 *  2. 접근 방법
 *    - 각 내적의 일부 최대값은 100만, 내적의 길이는 최대 1000이므로 나올 수 있는 최대 결과는 10억(ok)
 */
const solution = (a, b) => {
  /* 변수 선언부 */
  const len = a.length;
  let sum = 0;

  /* 메인 로직부 */
  for (let i = 0; i < len; i++) {
    sum += a[i] * b[i];
  }
  return sum;
};

console.log(solution([1, 2, 3, 4], [-3, -1, 0, 2]));
console.log(solution([-1, 0, 1], [1, 0, -1]));
