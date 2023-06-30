/**
 * BaekJoon_15729, 방탈출
 *  1. 문제 분류 : 다이나믹 프로그래밍
 *  2. 접근 방법
 *    - bottom-up 방식으로 dp로 풀어볼까..
 *    - dp 아닌듯
 */
const solution = () => {
  /* 초기 입력 */
  const input = require("fs")
    .readFileSync("./dev/stdin/15729.txt")
    .toString()
    .split("\n");

  /* 변수 초기화 */
  let answer = 0;
  const N = +input[0];
  const switchs = input[1].split(" ").map((item) => +item);
  const arr = new Array(N).fill(0);

  /* 메인 로직 */
  for (let i = 0; i < N; i++) {
    if (arr[i] !== switchs[i]) {
      if (i + 2 < N) arr[i + 2] = !arr[i + 2] ? 1 : 0;
      if (i + 1 < N) arr[i + 1] = !arr[i + 1] ? 1 : 0;
      arr[i] = !arr[i] ? 1 : 0;
      answer++;
    }
  }
  return answer;
};

console.log(solution());
