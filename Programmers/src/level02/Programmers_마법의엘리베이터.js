/**
 * Programmers_마법의 엘리베이터
 *    1. 문제 분류 : 백트래킹
 *    2. 접근 방법
 *      - 그리디인 줄 알았으나 탐색의 가지가 너무 많음
 *      - 가지를 최대한 줄이는 백트래킹으로 다시 풀었음
 *      - 최대한 1의 자리를 없애는데 더해서 10의 자리로 올려버리거나 빼서 0으로 만들어버리는
 *        -> 1의 자리를 결국 어떻게든 0으로 만드는 과정 수행
 */
const solution = (storey) => {
  /* 변수 선언부 */
  let answer = 100;

  /* 메인 로직 */
  dfs(storey, 0);

  return answer;

  /* 메서드 */
  function dfs(pos, depth) {
    if (depth > answer) return;
    if (pos === 0) {
      answer = Math.min(answer, depth);
      return;
    }

    let res = pos % 10;
    if (res === 0) {
      dfs(pos / 10, depth);
    } else {
      dfs(pos - res, depth + res);
      dfs(pos + 10 - res, depth + 10 - res);
    }
  }
};

console.log(solution(16));
console.log(solution(2554));
console.log(solution(35));
