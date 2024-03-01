/**
 * BaekJoon_6087, 레이저 통신
 *  - 문제 분류: 그래프 탐색, 다이나믹 프로그래밍
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/6087.txt").toString().trim().split("\n");
  const [W, H] = input[0].split(" ").map(Number);
  const map = [];
  const INF = 100007;
  const dp = Array.from({ length: H }, () => Array.from({ length: W }, () => Array.from({ length: 2 }, () => INF)));
  let [sr, sc, er, ec] = [-1, -1, -1, -1];
  const drc = [
    [-1, 0],
    [0, 1],
    [1, 0],
    [0, -1],
  ];

  for (let i = 1; i <= H; i++) {
    const arr = [];
    for (let j = 0; j < W; j++) {
      arr.push(input[i].charAt(j));
      if (input[i].charAt(j) === "C") {
        if (sr < 0) [sr, sc] = [i - 1, j];
        else [er, ec] = [i - 1, j];
      }
    }
    map.push(arr);
  }

  /* 메인 로직 */
  dfs(sr, sc);

  /* 정답 반환 */
  return Math.min(...dp[er][ec]);

  // dfs
  function dfs(sr, sc) {
    const stack = [];
    for (let i = 0; i < drc.length; i++) {
      dp[sr][sc][i % 2] = 0;

      const [nr, nc] = [sr + drc[i][0], sc + drc[i][1]];
      if (nr >= 0 && nr < H && nc >= 0 && nc < W && map[nr][nc] !== "*") {
        dp[nr][nc][i % 2] = 0;
        stack.push([nr, nc, i, 0]);
      }
    }

    while (stack.length > 0) {
      const [r, c, dir, cnt] = stack.pop();
      if (r === er && c === ec) continue;

      for (let i = -1; i <= 1; i++) {
        const ndir = (dir + i + drc.length) % drc.length;
        const [nr, nc] = [r + drc[ndir][0], c + drc[ndir][1]];
        if (nr < 0 || nc < 0 || nr >= H || nc >= W || map[nr][nc] === "*") continue;
        if (dp[nr][nc][ndir % 2] <= cnt + (dir !== ndir ? 1 : 0)) continue;

        dp[nr][nc][ndir % 2] = cnt + (dir !== ndir ? 1 : 0);
        stack.push([nr, nc, ndir, dp[nr][nc][ndir % 2]]);
      }
    }
  }
};

console.log(solution());

