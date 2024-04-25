/**
 * BaekJoon_2660, 회장뽑기
 *  - 문제 분류: 최단경로, 플로이드 워셜
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/2660.txt").toString().trim().split("\n");
  const N = +input[0];
  const INF = Number.MAX_SAFE_INTEGER;
  const dist = Array.from({ length: N + 1 }, () => Array.from({ length: N + 1 }, () => INF));
  const max = Array.from({ length: N + 1 }, () => 0);
  let min = INF;
  let line = 1;

  while (true) {
    const [x, y] = input[line++].split(" ").map(Number);
    if (x < 0 && y < 0) break;
    dist[x][y] = 1;
    dist[y][x] = 1;
  }

  /* 메인 로직 */
  for (let m = 1; m <= N; m++) {
    for (let s = 1; s <= N; s++) {
      if (dist[s][m] === INF) continue;
      for (let e = 1; e <= N; e++) {
        if (dist[m][e] === INF || s === e) continue;
        if (dist[s][m] + dist[m][e] > dist[s][e]) continue;
        dist[s][e] = dist[s][m] + dist[m][e];
      }
    }
  }

  for (let i = 1; i <= N; i++) {
    for (let j = 1; j <= N; j++) {
      if (dist[i][j] === INF) continue;
      max[i] = Math.max(max[i], dist[i][j]);
    }

    min = Math.min(min, max[i]);
  }

  let count = 0;
  const arr = [];
  for (let i = 1; i <= N; i++) {
    if (max[i] > min) continue;
    count++;
    arr.push(i);
  }

  /* 정답 반환 */
  return `${min} ${count}\n${arr.join(" ")}`;
};

console.log(solution());

