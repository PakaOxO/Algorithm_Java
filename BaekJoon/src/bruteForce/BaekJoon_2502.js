/**
 * BaekJoon_2502, 떡 먹는 호랑이
 *    1. 문제 분류 : 완전탐색, 수학, 다이나믹 프로그래밍
 *    2. 접근 방법
 *      - 첫 날 떡의 개수를 A, 둘째날 떡의 개수를 B라 했을 때, D번 째날 떡의 개수는 A와 B의 배수의 합으로 점화식 나옴
 *      - 점화식으로 D번째날 A의 계수와 B의 계수를 도출(다이나믹 프로그래밍)
 *      - A와 B를 각각 1부터 설정하며 미리 구한 계수를 곱해 합이
 *        -> K이면 정답으로 반환
 *        -> K보다 크면 break(더 이상 계산이 필요 없으므로)
 */
const solution = () => {
  /* 변수 초기화 */
  const [D, K] = require("fs")
    .readFileSync("./dev/stdin/2502.txt")
    .toString()
    .trim()
    .split(" ")
    .map((item) => +item);
  const coefficients = [
    [0, 0],
    [1, 0],
    [0, 1],
  ];
  let [maxA, maxB] = [0, 0];
  let answer = [0, 0];

  /* 메인 로직 */
  for (let i = 3; i <= D; i++) {
    coefficients.push([
      coefficients[i - 1][0] + coefficients[i - 2][0],
      coefficients[i - 1][1] + coefficients[i - 2][1],
    ]);
  }
  [maxA, maxB] = [Math.floor(K / coefficients[D][0]), Math.floor(K / coefficients[D][1])];

  loop: for (let i = 1; i <= maxA; i++) {
    for (let j = i; j <= maxB; j++) {
      const calc = coefficients[D][0] * i + coefficients[D][1] * j;
      if (calc > K) break;
      if (calc === K) {
        answer[0] = i;
        answer[1] = j;
        break loop;
      }
    }
  }

  /* 정답 반환 */
  return answer.join("\n");
};

console.log(solution());
