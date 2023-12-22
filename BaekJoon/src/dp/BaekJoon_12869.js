/**
 * BaekJoon_12869, 뮤탈리스크
 *  - 문제 분류: 다이나믹 프로그래밍, 그래프 탐색
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/12869.txt").toString().trim().split("\n");
  const N = +input[0];
  const scv = input[1].split(" ").map(Number);
  const INF = Number.MAX_SAFE_INTEGER;
  let dp = null;

  while (scv.length < 3) {
    scv.push(0);
  }

  scv.sort((a, b) => b - a);

  dp = Array.from({ length: scv[0] + 1 }, () =>
    Array.from({ length: scv[1] + 1 }, () => Array.from({ length: scv[2] + 1 }, () => INF))
  );

  /* 메인 로직 */
  dfs(0, [...scv]);

  /* 정답 반환 */
  return dp[0][0][0];

  // dfs
  function dfs(depth, scvs) {
    scvs.sort((a, b) => b - a);
    const [x, y, z] = scvs;
    if (dp[x][y][z] <= depth) return;
    dp[x][y][z] = depth;

    [
      [9, 3, 1],
      [9, 1, 3],
    ]
      .map((damages) =>
        damages.map((damage, j) => {
          const res = scvs[j] - damage;
          return res < 0 ? 0 : res;
        })
      )
      .map((next) => dfs(depth + 1, next));
  }
};

console.log(solution());

