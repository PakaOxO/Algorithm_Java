/**
 * BaekJoon_19942, 다이어트
 *    - 문제 분류 : 그래프 탐색, 백트래킹
 */
const solution = () => {
  const input = require("fs").readFileSync("./dev/stdin/19942.txt").toString().trim().split("\n");
  const N = +input[0];
  const [mp, mf, ms, mv] = input[1].split(" ").map((item) => +item);
  const arr = [];
  const comb = [];
  let minCost = 123456789;
  let answer = -1;

  /* 메인 로직 */
  for (let i = 2; i < N + 2; i++) {
    arr.push([i - 1, ...input[i].split(" ").map((item) => +item)]);
  }

  dfs(0, 0, 0, 0, 0, 0, 0);

  /* 정답 반환 */
  return answer;

  /**
   * dfs
   */
  function dfs(sp, sf, ss, sv, start, depth, cost) {
    if (cost >= minCost) return;
    if (sp >= mp && sf >= mf && ss >= ms && sv >= mv) {
      minCost = Math.min(minCost, cost);
      answer = `${minCost}\n${comb.join(" ")}`;
      return;
    }
    if (depth === N) return;

    for (let i = start; i < N; i++) {
      comb.push(arr[i][0]);
      dfs(sp + arr[i][1], sf + arr[i][2], ss + arr[i][3], sv + arr[i][4], i + 1, depth + 1, cost + arr[i][5]);
      comb.pop();
    }
  }
};

console.log(solution());
