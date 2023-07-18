/**
 * Programmers_삼총사
 *  1. 문제 분류 : 조합론
 *  2. 접근 방법
 *    - 학생 번호를 순회하며 3개를 뽑는 조합을 구함
 *    - 세 명의 학생을 뽑았다면 더해서 합이 0인지 체크
 *      - 합이 0이면 answer++
 */
const solution = (number) => {
  /* 변수 선언부 */
  const len = number.length;
  let answer = 0;
  combination(0, 0, 0);

  return answer;

  /* 메서드 */
  function combination(start, cnt, sum) {
    if (cnt === 3) {
      if (sum === 0) answer++;
      return;
    }

    for (let i = start; i < len; i++) {
      combination(i + 1, cnt + 1, sum + number[i]);
    }
  }
};

console.log(solution([-2, 3, 0, 2, -5]));
console.log(solution([-3, -2, -1, 0, 1, 2, 3]));
console.log(solution([-1, 1, -1, 1]));
