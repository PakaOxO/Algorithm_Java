/**
 * BaekJoon_화성 지도
 *  - 문제 분류: 스위핑
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/3392.txt").toString().split("\n");
  const N = +input[0];
  const MAX = 30001;
  const height = Array.from({ length: MAX }, () => 0);
  const points = [];
  let answer = 0;

  /* 메인 로직 */
  for (let i = 1; i <= N; i++) {
    const [x1, y1, x2, y2] = input[i].split(" ").map(Number);
    points.push([x1, y1, y2, 1]);
    points.push([x2, y1, y2, -1]);
  }
  points.sort((a, b) => a[0] - b[0]);

  for (let i = 0; i < N * 2 - 1; i++) {
    const [x, h1, h2, d] = points[i];
    for (let h = h1; h < h2; h++) height[h] += d;

    let count = 0;
    for (let i = 0; i < MAX; i++) {
      if (height[i] > 0) count++;
    }
    answer += count * (points[i + 1][0] - x);
  }

  /* 정답 반환 */
  return answer;
};

console.log(solution());

