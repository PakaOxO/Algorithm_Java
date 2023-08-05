/**
 * BaekJoon_1141, 접두사
 *  1. 문제 분류 : 정렬, 문자열
 *  2. 접근 방법
 *    -
 */
const solution = () => {
  /* 변수 초기화 */
  const input = require("fs").readFileSync("./dev/stdin/1141.txt").toString().split("\n");
  const N = +input[0];
  const arr = [];
  let answer = 0;

  /* 메인 로직 */
  for (let i = 1; i <= N; i++) {
    arr.push(input[i].trim());
  }
  arr.sort();

  for (let i = 0; i < N; i++) {
    if (i + 1 === N) {
      answer++;
    } else {
      if (arr[i].length > arr[i + 1].length) {
        answer++;
      } else {
        if (arr[i] === arr[i + 1].slice(0, arr[i].length)) continue;
        answer++;
      }
    }
  }

  return answer;
};

console.log(solution());

