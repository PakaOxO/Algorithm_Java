/**
 * BaekJoon_16983, 캠프 준비
 *  - 문제 분류: 조합, 백트래킹
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/16938.txt").toString().trim().split("\n");
  const [N, L, R, X] = input[0].split(" ").map(Number);
  const question = input[1].split(" ").map(Number);
  const INF = 1000000;
  const set = new Set();

  /* 메인 로직 */
  dfs(0, INF, 0, 0, 0, 0);

  /* 정답 반환 */
  return set.size;

  // dfs
  // count >= 2
  // L <= sum <= R
  // max - min >= X
  function dfs(i, min, max, sum, count, comb) {
    if (sum > R) return;
    if (count >= 2 && sum >= L && max - min >= X) {
      set.add(comb);
    }
    if (i === N) return;

    const [l, r, s] = [Math.min(min, question[i]), Math.max(max, question[i]), sum + question[i]];
    dfs(i + 1, l, r, s, count + 1, comb | (1 << i));
    dfs(i + 1, min, max, sum, count, comb);
  }
};

console.log(solution());

