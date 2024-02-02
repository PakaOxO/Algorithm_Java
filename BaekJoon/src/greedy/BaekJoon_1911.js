/**
 * BaekJoon_1911, 흙길 보수하기
 *  - 문제 분류: 그리디
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/1911.txt").toString().trim().split("\n");
  const [N, L] = input[0].split(" ").map(Number);
  const puddles = input.slice(1).map((item) => item.split(" ").map(Number));
  let max = 0;
  let answer = 0;

  /* 메인 로직 */
  puddles.sort((a, b) => a[0] - b[0]);
  for (let i = 0; i < N; i++) {
    max = Math.max(max, puddles[i][0]);

    if (max >= puddles[i][1] || max < 0) continue;
    const diff = puddles[i][1] - max;
    const share = Math.floor(diff / L);
    const res = diff % L;
    const count = share + (res > 0 ? 1 : 0);
    answer += count;
    max += count * L;
  }

  /* 정답 반환 */
  return answer;
};

console.log(solution());
