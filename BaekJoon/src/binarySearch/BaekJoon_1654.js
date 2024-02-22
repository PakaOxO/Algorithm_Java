/**
 * BaekJoon_1654, 랜선 자르기
 *  - 문제 분류: 이분 탐색
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/1654.txt").toString().split("\n");
  const [K, N] = input[0].split(" ").map(Number);
  const lines = input.slice(1).map(Number);

  /* 메인 로직 */
  lines.sort((a, b) => b - a);
  let [left, right] = [0, Math.max(...lines)];
  while (left <= right) {
    const mid = Math.floor((left + right) / 2);
    let count = 0;
    for (let i = 0; i < K; i++) {
      count += Math.floor(lines[i] / mid);
      if (count >= N) break;
    }

    if (count >= N) left = mid + 1;
    else right = mid - 1;
  }

  /* 정답 반환 */
  return right;
};

console.log(solution());

