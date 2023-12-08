/**
 * BaekJoon_1527, 금민수의 개수
 *  - 문제 분류: 조합론, 완전 탐색
 */
const solution = () => {
  /* 변수 관리 */
  const [A, B] = require("fs").readFileSync("./dev/stdin/1527.txt").toString().split(" ").map(Number);
  // A, B 최대 10억 -> 10자리 숫자 -> 4,7로 만들 수 있는 10자리 숫자 경우의 수 -> 2^10
  const length = (B + "").length;
  let answer = 0;

  /* 메인 로직 */
  dfs(0, 0);

  /* 정답 반환 */
  return answer;

  // dfs
  function dfs(depth, number) {
    if (number > 0 && (number >= A && number <= B)) answer++;
    if (depth === length) {
      return;
    }

    dfs(depth + 1, number * 10 + 4);
    dfs(depth + 1, number * 10 + 7);
  }
}

console.log(solution());