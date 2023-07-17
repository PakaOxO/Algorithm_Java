/**
 * Programmers_없는 숫자 더하기
 *  1. 문제 분류 : 구현
 *  2. 접근 방법
 *    - 입력 배열을 돌면서 방문 체크
 *    - 방문 체크가 끝나고 다시 배열을 돌면서 방문하지 않은 숫자+
 */
const solution = (numbers) => {
  /* 변수 선언부 */
  let sum = 0;
  const v = Array.from({ length: 10 }, () => false);

  /* 메인 로직 */
  numbers.forEach((num) => {
    v[num] = true;
  });
  v.forEach((c, num) => {
    if (!c) {
      sum += num;
    }
  });
  return sum;
};

console.log(solution([1, 2, 3, 4, 6, 7, 8, 0]));
console.log(solution([5, 8, 4, 0, 6, 7, 9]));
