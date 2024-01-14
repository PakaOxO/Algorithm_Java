/**
 * CodeTree_블럭 쌓는 명령
 *  - 문제 분류: 정렬, 누적 합
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/블럭쌓는명령.txt").toString().trim().split("\n");
  const [N, K] = input[0].split(" ").map(Number);
  const acc = Array.from({ length: N + 1 }, () => 0);

  /* 메인 로직 */
  for (let i = 1; i <= K; i++) {
    const [s, e] = input[i].split(" ").map(Number);
    acc[s]++;
    if (e + 1 <= N) acc[e + 1]--;
  }

  for (let i = 1; i <= N; i++) acc[i] += acc[i - 1];
  acc.sort((a, b) => a - b);

  /* 정답 반환 */
  return acc[Math.floor(N / 2) + 1];
};

console.log(solution());

