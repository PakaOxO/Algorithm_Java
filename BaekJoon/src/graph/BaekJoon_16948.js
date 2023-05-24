/*
  BaekJoon_16948, 데스 나이트
  Sketch Idea
    1. 그래프 탐색으로 목적지까지의 최단 경로를 도출하는 문제
*/
const solution = () => {
  let fs = require("fs");
  let input = fs.readFileSync("./dev/stdin").toString().split("\n");

  /* 초기값 */
  const N = +input[0];
  const [r1, c1, r2, c2] = input[1].split(" ").map((item) => +item);
  const drc = [
    [-2, -1],
    [-2, 1],
    [0, -2],
    [0, 2],
    [2, -1],
    [2, 1],
  ];

  /* 메서드 */
  const bfs = (start, end, N) => {
    const [r1, c1] = start;
    const [r2, c2] = end;

    const isVisited = new Array(N);
    for (let i = 0; i < N; i++) isVisited[i] = new Array(N).fill(false);
    isVisited[r1][c1] = true;

    const q = [[...start, 0]];
    while (q.length > 0) {
      const [r, c, d] = q.shift();
      for (let i = 0; i < drc.length; i++) {
        const [nr, nc, nd] = [r + drc[i][0], c + drc[i][1], d + 1];
        if (nr < 0 || nc < 0 || nr >= N || nc >= N || isVisited[nr][nc])
          continue;
        if (nr === r2 && nc === c2) return nd;
        q.push([nr, nc, nd]);
        isVisited[nr][nc] = true;
      }
    }
    return -1;
  };

  /* 메인 로직 */
  return bfs([r1, c1], [r2, c2], N);
};

console.log(solution());
