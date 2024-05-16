/**
 * BaekJoon_13164, 행복 유치원
 *  - 문제 분류: 그리디
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/13164.txt").toString().trim().split("\n");
  const [[N, M], arr] = input.map((line) => line.split(" ").map(Number));
  let answer = arr[N - 1] - arr[0];

  /* 메인 로직 */
  for (let i = N - 1; i > 0; i--) {
    arr[i] = arr[i] - arr[i - 1];
  }
  arr[0] = 0;

  arr.sort((a, b) => b - a);

  for (let i = 0; i < M - 1; i++) {
    answer -= arr[i];
  }

  /* 정답 반환 */
  return answer;
};

console.log(solution());

