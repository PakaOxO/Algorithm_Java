/*
  BaekJoon_17086 아기 상어2
    1. 문제 분류 : 그래프 이론
    2. 접근 방법
      - 아기 상어의 위치를 담은 큐에서 시작하는 BFS 탐색
      - 큐의 루프는 depth로 구분해 거리를 체크, 아기 상어의 위치의 depth는 0
*/
const solution = () => {
  /* 변수 초기화 */
  let answer = 0;
  let [N, M] = [0, 0];
  const map = [];
  const queue = [];
  const dist = [];
  const drc = [
    [-1, -1],
    [-1, 0],
    [-1, 1],
    [0, -1],
    [0, 1],
    [1, -1],
    [1, 0],
    [1, 1],
  ];

  /* 초기 입력 */
  const fs = require("fs");
  const input = fs.readFileSync("./dev/stdin/17086.txt").toString().split("\n");

  [N, M] = input[0].split(" ").map((item) => +item);
  for (let i = 0; i < N; i++) {
    const line = input[i + 1].split(" ");
    map.push([]);
    dist.push([]);
    for (let j = 0; j < M; j++) {
      map[i].push(+line[j]);
      if (map[i][j] === 1) {
        queue.push([i, j]);
        dist[i].push(0);
      } else {
        dist[i].push(-1);
      }
    }
  }

  const bfs = () => {
    while (queue.length > 0) {
      const size = queue.length;
      for (let i = 0; i < size; i++) {
        const pos = queue.shift();
        answer = Math.max(answer, dist[pos[0]][pos[1]]);

        for (let j = 0; j < drc.length; j++) {
          const [nr, nc] = [pos[0] + drc[j][0], pos[1] + drc[j][1]];
          if (nr < 0 || nc < 0 || nr >= N || nc >= M || dist[nr][nc] >= 0) {
            continue;
          }
          dist[nr][nc] = dist[pos[0]][pos[1]] + 1;
          queue.push([nr, nc]);
        }
      }
    }
  };

  bfs();
  return answer;
};

console.log(solution());
