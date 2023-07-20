/**
 * Programmers_피보나치 수
 *  1. 문제 분류 : 재귀
 *  2. 접근 방법
 *    - 이전에 구한 값을 메모이제이션하며 재귀 함수 호출
 *    - top-down 방식에서는 콜 스택 에러
 *    - bottom-up으로 재 풀이
 */
const solution = (n) => {
  /* 변수 선언부 */
  const INF = 1234567;
  const memo = Array.from({ length: n + 1 }, () => -1);
  memo[0] = 0;
  memo[1] = 1;

  /* 메인 로직부 */
  for (let i = 2; i <= n; i++) {
    memo[i] = (memo[i - 1] + memo[i - 2]) % INF;
  }

  return memo[n];
};

// console.log(solution(3));
// console.log(solution(5));
console.log(solution(1000000));
