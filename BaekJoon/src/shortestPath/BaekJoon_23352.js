/**
 * BaekJoon_223352, 방탈출
 *  - 문제 분류 : 그래프 탐색, 최단거리, 완전탐색
 */
const solution = () => {
  /* 변수 초기화 */
  const input = require("fs").readFileSync("./dev/stdin/23352.txt").toString().trim().split("\n");
  const [N, M] = input[0].split(" ").map((item) => +item);
  const map = [];
  for (let i = 1; i <= N; i++) {
    map.push(input[i].split(" ").map((item) => +item));
  }
  const INF = Number.MAX_SAFE_INTEGER;
  let dist = null;
  const drc = [
    [0, 1],
    [0, -1],
    [1, 0],
    [-1, 0],
  ];
  let max = 0;
  let answer = 0;

  /* 메인 로직 */
  getMinDists();

  return answer;

  /**
   * 모든 정점 사이 최단 거리를 구하는 함수
   */
  function getMinDists() {
    const X = N * M;
    dist = Array.from({ length: X }, () => Array.from({ length: X }, () => INF));
    for (let i = 0; i < X; i++) {
      bfs(i);
    }
  }

  /**
   * 정점 s에서 시작하는 다른 모든 정점에 대한 최단거리를 구하는 함수
   */
  function bfs(s) {
    const sr = Math.floor(s / M);
    const sc = (s - sr * M) % M;
    if (map[sr][sc] === 0) return;
    const q = [[sr, sc, 0]];
    dist[s][s] = 0;

    while (q.length > 0) {
      const [r, c, d] = q.shift();
      for (let dir = 0; dir < drc.length; dir++) {
        const [nr, nc] = [r + drc[dir][0], c + drc[dir][1]];
        if (nr < 0 || nc < 0 || nr >= N || nc >= M || map[nr][nc] === 0) continue;
        const next = nr * M + nc;
        if (dist[s][next] <= d + 1) continue;
        dist[s][next] = d + 1;
        q.push([nr, nc, d + 1]);
        refreshMax(sr, sc, nr, nc, d + 1);
      }
    }
  }

  /**
   * 두 좌표((r1, c1), (r2, c2)) 사이의 거리가 최대거리보다 크면 최대거리와 두 정점 사이 숫자의 합을 갱신하는 함수
   */
  function refreshMax(r1, c1, r2, c2, d) {
    if (d < max) return;
    if (d === max) {
      answer = Math.max(answer, map[r1][c1] + map[r2][c2]);
    } else {
      max = d;
      answer = map[r1][c1] + map[r2][c2];
    }
  }
};

console.log(solution());

