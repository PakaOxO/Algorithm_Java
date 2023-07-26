/**
 * Programmers_점 찍기.js
 *  1. 문제 분류 : 그리디, 수학
 *  2. 접근 방법
 *    - 단순히 N*N으로 접근하면 10억 -> 시간 초과
 *    - 원점에서 거리는 x좌표 y좌표를 각각 제곱해 더한 값의 루트 값
 *    -> x 좌표를 순회하면서 고정했을 때 남은 거리는 d^2 - x^2의 루트 값 -> 이 안에 들어가는 k의 배수를 구해 더하면서 오면 되겠당
 */
const solution = (k, d) => {
  /* 변수 선언부 */
  let answer = 0;
  const d2 = d * d;

  /* 메인 로직 */
  for (let x = 0; x <= d; x += k) {
    const x2 = x * x;
    answer += ~~(~~Math.sqrt(d2 - x2, 2) / k) + 1;
  }

  return answer;
};

console.log(solution(2, 4));
console.log(solution(1, 5));
