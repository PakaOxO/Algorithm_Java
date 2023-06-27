/*
  Programmers_가장큰수
    1. 문제 유형 : 조합론
    2. 접근 방법
      - 문자열로 이어 붙일 때 모든 숫자의 범위는 4자리 이하
      - 모든 숫자에서 자기 자신을 반복해 4자리 수로 만든 뒤 정렬
      - 해당 정렬 순서대로 원본 숫자를 이어 붙임
*/
const solution = (numbers) => {
  const arr = numbers
    .map((num) => {
      const org = num + "";
      let str = org;
      while (str.length < 4) {
        str += org;
      }
      str = str.slice(0, 4);
      return [str, num];
    })
    .sort((a, b) => +b[0] - +a[0]);

  const answer = arr.map((item) => item[1]).join("");
  return answer > 0 ? answer : "0";
};

console.log(solution([0, 0]));
