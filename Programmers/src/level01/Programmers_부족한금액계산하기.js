/**
 * Programmers_부족한금액계산하기.js
 *  1. 문제 분류 : 구현, 수학
 *  2. 접근 방법
 *    - 금액이 오르는 규칙에 맞게 1번부터 count번까지 타면서 필요한 전체 금액을 계산
 *    - 1번부터 count번까지의 금액은 ((count * (count + 1)) / 2) * price로 계산 가능
 */
const solution = (price, money, count) => {
  /* 변수 선언부 */
  const total = ((count * (count + 1)) / 2) * price;

  /* 메인 로직부 */
  return total > money ? total - money : 0;
};

console.log(solution(3, 20, 4));
