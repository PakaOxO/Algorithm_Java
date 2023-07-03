/**
 * BaekJoon_18429, 근손실
 *  1. 문제 분류 : 순열, 완전 탐색
 *  2. 접근 방법
 *    - 제한 근육량 이상을 유지하려면 사실 근육량 증가가 큰 운동 순으로 정렬하는 것부터..
 *    - 정렬된 경우의 수를 탐색하면서 처음으로 실패가 뜨면 stop
 */
const solution = () => {
  /* 초기 입력 */
  const input = require("fs")
    .readFileSync("./dev/stdin/18429.txt")
    .toString()
    .split("\n");

  /* 변수 초기화 */
  let answer = 0;
  let w = 500;
  const [N, K] = input[0].split(" ").map((item) => +item);
  const arr = input[1].split(" ").map((item) => +item - K);
  arr.sort((a, b) => b - a);
  const sel = Array.from({ length: N }, () => 0);

  dfs(0);
  return answer;

  /* 메서드 */
  function dfs(depth) {
    if (depth === N - 1) {
      answer++;
      return;
    }

    for (let i = 0; i < N; i++) {
      if (sel[i]) continue;
      sel[i] = 1;
      w += arr[i];
      if (w >= 500) {
        dfs(depth + 1);
      }
      sel[i] = 0;
      w -= arr[i];
    }
  }
};

console.log(solution());
