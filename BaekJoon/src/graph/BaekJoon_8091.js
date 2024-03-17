/**
 * BaekJoon_8091, Bitmap
 *  - 문제 분류: 그래프 탐색
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/8091.txt").toString().trim().split("\n");
  const [N, M] = input[0].split(" ").map(Number);
  const INF = N * M;
  const dist = Array.from({ length: N }, () => Array.from({ length: M }, () => INF));
  const map = input.slice(1).map((line) => line.split("").map(Number));
  const drc = [
    [0, 1],
    [0, -1],
    [1, 0],
    [-1, 0],
  ];

  /* 메인 로직 */
  bfs();

  /* 정답 반환 */
  return dist
    .map((line) => line.join(" "))
    .join("\n")
    .trim();

  // dfs
  function bfs() {
    const q = [];
    for (let i = 0; i < N; i++) {
      for (let j = 0; j < M; j++) {
        if (!map[i][j]) continue;
        dist[i][j] = 0;
        q.push([i, j]);
      }
    }

    while (q.length > 0) {
      const [r, c] = q.shift();

      for (const [dr, dc] of drc) {
        const [nr, nc] = [r + dr, c + dc];
        const d = dist[r][c];

        if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
        if (dist[nr][nc] <= d + 1) continue;

        dist[nr][nc] = d + 1;
        q.push([nr, nc]);
      }
    }
  }
};

console.log(solution());

