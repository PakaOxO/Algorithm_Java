/**
 * Programmers_하노이의 탑
 *    1. 문제 분류 : 재귀, 분할 정복
 *    2. 접근 방법
 *      - 원판 n개를 A -> C로 옮기는 과정은 다음과 같이 분할 가능
 *        -> 원판 n - 1개를 A -> C -> B로 옮기는 선행과정
 *        -> n번 원판을 A -> C로 옮기는 과정
 *        -> B에 옮긴 n - 1개 원판을 B -> A -> C로 옮기는 후행과정
 */
const solution = (n) => {
  /* 변수 선언부 */
  const answer = [];

  /* 메인 로직 */
  hanoi(0, 1, 2, n);
  return answer;

  /* 메서드 */
  function hanoi(from, thru, to, x) {
    if (x === 1) {
      answer.push([from + 1, to + 1]);
      return;
    }
    hanoi(from, to, thru, x - 1);
    answer.push([from + 1, to + 1]);
    hanoi(thru, from, to, x - 1);
  }
};

console.log(solution(3));
// 2	[ [1,2], [1,3], [2,3] ]
// 3  [ [1,3], [1,2], [3,2], [1,3], [2,1], [2,3], [1,3] ]

