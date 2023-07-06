/**
 * Programmers_124나라의 숫자,
 *  1. 문제 분류 : 수학, 구현?
 *  2. 접근 방법
 *    - 1, 2, 4만 사용할 수 있는 3진법이라고 생각하면 어떨까
 *    - 마지막 숫자가 4면 그 다음 숫자는 자리 올림
 */
const solution = (n) => {
  let answer = "";
  while (n > 0) {
    const res = (n - 1) % 3;
    n = Math.floor((n - 1) / 3);
    trans(res);
  }
  return answer;

  function trans(x) {
    if (x === 0) {
      answer = "1" + answer;
    } else if (x === 1) {
      answer = "2" + answer;
    } else {
      answer = "4" + answer;
    }
  }
};

console.log(solution(1));
console.log(solution(2));
console.log(solution(3));
console.log(solution(4));
console.log(solution(5));
console.log(solution(6));
console.log(solution(7));
console.log(solution(8));
console.log(solution(9));
console.log(solution(10));
console.log(solution(11));
console.log(solution(12));
console.log(solution(13));
console.log(solution(50000000));
