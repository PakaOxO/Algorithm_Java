/**
 * Programmers_이진 변환 반복하기
 *  1. 문제 분류 : 문자열, 재귀
 *  2. 접근 방법
 *    - 입력받은 문자열을 '0'을 기준으로 spilt한 (배열의 길이 - 1)가 0의 개수
 *    - 길이의 값을 2진수로 표현
 *    - 위 과정을 반복
 */
const solution = (s) => {
  /* 변수 선언부 */
  let answer = [0, 0];

  /* 메인 로직부 */
  while (+s !== 1) {
    s = convert(s);
  }

  return answer;

  /* 메서드 */
  function convert(str) {
    if (+str === 1) return str;

    const arr = str.split("0");
    const count0 = arr.length - 1;
    const next = arr.join("");
    answer[0]++;
    answer[1] += count0;

    return (+next.length).toString(2);
  }
};

console.log(solution("110010101001"));
console.log(solution("01110"));
console.log(solution("1111111"));
