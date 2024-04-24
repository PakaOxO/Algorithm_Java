/**
 * BaekJoon_2559, 수열
 *  - 문제 분류: 누적 합, 슬라이딩 윈도우
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/2559.txt").toString().trim().split("\n");
  const [N, K] = input[0].split(" ").map(Number);
  const arr = [0, ...input[1].split(" ").map(Number)];
  let answer = Number.MIN_SAFE_INTEGER;

  /* 메인 로직 */
  for (let i = 1; i <= N; i++) {
    arr[i] += arr[i - 1];

    if (i >= K) {
      answer = Math.max(answer, arr[i] - arr[i - K]);
    }
  }
  /* 정답 반환 */
  return answer;
};

console.log(solution());

