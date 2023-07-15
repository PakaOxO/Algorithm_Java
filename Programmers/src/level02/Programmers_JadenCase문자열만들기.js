/**
 * Programmers_JadenCase 문자열 만들기
 *  1. 문제 분류 : 문자열
 *  2. 접근 방법
 *    - js split 함수를 사용해 문자열을 배열의 각 요소로 쪼갠 뒤
 *    - 각 요소의 첫 단어가 알파벳이면 대문자로 치환 후 join 함수로 다시 문자열로 변환해 리턴
 */
const solution = (s) => {
  return s
    .split(" ")
    .map((word) => {
      return word.slice(0, 1).toUpperCase() + word.slice(1).toLowerCase();
    })
    .join(" ");
};

console.log(solution("3people unFollowed me"));
console.log(solution("for the last week"));
