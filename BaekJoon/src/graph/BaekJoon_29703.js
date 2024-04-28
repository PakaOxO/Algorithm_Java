/**
 * BaekJoon_29703, 펭귄의 하루
 *  - 문제 분류: 그래프 탐색
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/29703.txt").toString().trim().split("\n");
  const [N, M] = input[0].split(" ").map(Number);
  const INF = Number.MAX_SAFE_INTEGER;
  const map = [];
  const dist = Array.from({ length: N }, () => Array.from({ length: M }, () => Array.from({ length: 2 }, () => INF)));
  let [s, e] = [
    [-1, -1],
    [-1, -1],
  ];
  const drc = [
    [0, 1],
    [0, -1],
    [1, 0],
    [-1, 0],
  ];
  const fArr = [];
  let answer = INF;

  for (let i = 0; i < N; i++) {
    const line = input[i + 1].split("");
    const arr = [];
    for (let j = 0; j < M; j++) {
      if (line[j] === "S") {
        s = [i, j];
      } else if (line[j] === "H") {
        e = [i, j];
      } else if (line[j] === "F") {
        fArr.push([i, j]);
      }

      arr.push(line[j]);
    }

    map.push(arr);
  }

  /* 메인 로직 */
  bfs(...s, 0);
  bfs(...e, 1);

  for (const [i, j] of fArr) {
    answer = Math.min(answer, dist[i][j][0] + dist[i][j][1]);
  }

  if (answer >= INF) answer = -1;

  /* 정답 반환 */
  return answer;

  // bfs
  function bfs(r, c, flag) {
    const q = [[r, c, flag]];
    dist[r][c][flag] = 0;

    while (q.length > 0) {
      const [cr, cc, f] = q.shift();
      for (const [dr, dc] of drc) {
        const [nr, nc] = [cr + dr, cc + dc];
        if (nr < 0 || nc < 0 || nr >= N || nc >= M || map[nr][nc] === "D") continue;
        if (dist[nr][nc][f] <= dist[cr][cc][f] + 1) continue;

        dist[nr][nc][f] = dist[cr][cc][f] + 1;
        q.push([nr, nc, f]);
      }
    }
  }
};

console.log(solution());

