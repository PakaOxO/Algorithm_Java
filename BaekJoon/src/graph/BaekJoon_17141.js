/**
 * BaekJoon_17141, 연구소 2
 *  - 문제 분류: 그래프 탐색, 완전 탐색
 *  - 시간 복잡도: M개 선택(10CM) * 그래프 탐색(N*N) = 50 * 50 * 10C5 = 252 * 2500 = 625000
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/17141.txt").toString().trim().split("\n");
  const [N, M] = input[0].split(" ").map(Number);
  const INF = N * N;
  const map = [];
  const start = [];
  const drc = [
    [0, 1],
    [0, -1],
    [1, 0],
    [-1, 0],
  ];
  let answer = INF;

  for (let i = 1; i <= N; i++) {
    const line = input[i].split(" ").map(Number);
    map.push([]);
    for (let j = 0; j < N; j++) {
      map[i - 1].push(line[j]);
      if (line[j] === 2) start.push([i - 1, j]);
    }
  }

  /* 메인 로직 */
  selectStart(0, 0, 0);

  /* 정답 반환 */
  return answer === INF ? -1 : answer;

  // selectStart
  function selectStart(s, d, comb) {
    if (d === M) {
      startContagion(comb);
      return;
    }

    for (let i = s; i < start.length; i++) {
      selectStart(i + 1, d + 1, comb | (1 << i));
    }
  }

  // bfs
  function startContagion(comb) {
    const v = Array.from({ length: N }, () => Array.from({ length: N }, () => INF));
    const q = [];

    for (let i = 0; i < start.length; i++) {
      if ((comb & (1 << i)) === 0) continue;
      const [r, c] = [...start[i]];
      q.push([r, c]);
      v[r][c] = 0;
    }

    while (q.length > 0) {
      const [cr, cc] = q.shift();

      for (let i = 0; i < drc.length; i++) {
        const [nr, nc] = [cr + drc[i][0], cc + drc[i][1]];
        if (nr < 0 || nc < 0 || nr >= N || nc >= N || map[nr][nc] === 1) continue;
        if (v[nr][nc] <= v[cr][cc] + 1) continue;

        v[nr][nc] = v[cr][cc] + 1;
        q.push([nr, nc]);
      }
    }

    let max = 0;
    for (let i = 0; i < N; i++) {
      for (let j = 0; j < N; j++) {
        if (map[i][j] === 1) continue;
        max = Math.max(max, v[i][j]);
      }
    }

    answer = Math.min(answer, max);
  }
};

console.log(solution());

