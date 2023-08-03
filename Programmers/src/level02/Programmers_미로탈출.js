/**
 * Programmers_미로 탈출
 *    1. 문제 분류 : bfs, 그래프 탐색
 *    2. 접근 방법
 *      - 각각 출발지(S)에서 레버(L)까지, 레버(L)에서 출구(E)까지 이동하는 최단거리를 구해 더하면 됨
 *        - 만약 두 경로 중 하나라도 이동할 수 없다면(리턴값 0) 전체 경로는 성립하지 않으므로 -1 리턴
 */
const solution = (maps) => {
  /* 변수 초기화 */
  const [N, M] = [maps.length, maps[0].length];
  let [S, L, E] = [null, null, null];
  const drc = [
    [0, 1],
    [0, -1],
    [1, 0],
    [-1, 0],
  ];
  let [d1, d2] = [0, 0];

  /* 메인 로직 */
  [S, L, E] = findPoints();

  d1 = dijkstra(S, L);
  d2 += dijkstra(L, E);

  return d1 === 0 || d2 === 0 ? -1 : d1 + d2;

  /* 출발지, 레버, 출구 위치 반환 */
  function findPoints() {
    const results = [null, null, null];

    for (let r = 0; r < N; r++) {
      for (let c = 0; c < M; c++) {
        if (maps[r].charAt(c) === "S") {
          results[0] = [r, c];
        } else if (maps[r].charAt(c) === "L") {
          results[1] = [r, c];
        } else if (maps[r].charAt(c) === "E") {
          results[2] = [r, c];
        }
      }
    }
    return results;
  }

  /* 다익스트라 */
  function dijkstra([r1, c1], [r2, c2]) {
    const q = [[r1, c1, 0]];
    const v = Array.from({ length: N }, () => Array.from({ length: M }));
    v[r1][c1] = true;

    while (q.length > 0) {
      const curr = q.shift();
      for (let i = 0; i < drc.length; i++) {
        const [nr, nc] = [curr[0] + drc[i][0], curr[1] + drc[i][1]];
        if (nr < 0 || nc < 0 || nr >= N || nc >= M || v[nr][nc] || maps[nr].charAt(nc) === "X") continue;
        if (nr === r2 && nc === c2) return curr[2] + 1;
        v[nr][nc] = true;
        q.push([nr, nc, curr[2] + 1]);
      }
    }
    return 0;
  }
};

console.log(solution(["SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE"]));
console.log(solution(["LOOXS", "OOOOX", "OOOOO", "OOOOO", "EOOOO"]));

