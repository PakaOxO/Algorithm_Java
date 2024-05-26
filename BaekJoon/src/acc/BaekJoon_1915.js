/**
 * BaekJoon_1915, 가장 큰 정사각형
 *  - 문제 분류: 누적합
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/1915.txt").toString().trim().split("\n");
  const [n, m] = input[0].split(" ").map(Number);
  const square = [
    Array.from({ length: m + 1 }, () => 0),
    ...input.slice(1).map((line) => [0, ...line.split("").map(Number)]),
  ];
  let answer = 0;

  /* 메인 로직 */
  for (let i = 1; i <= n; i++) {
    for (let j = 1; j <= m; j++) {
      square[i][j] += square[i - 1][j] + square[i][j - 1] - square[i - 1][j - 1];
      const max = i < j ? i : j;
      for (let k = answer + 1; k <= max; k++) {
        if (square[i][j] - square[i - k][j] - square[i][j - k] + square[i - k][j - k] < k * k) break;
        answer = k;
      }
    }
  }

  /* 정답 반환 */
  return answer * answer;
};

console.log(solution());

