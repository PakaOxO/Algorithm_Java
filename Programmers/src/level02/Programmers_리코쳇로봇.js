/**
 * Programmers_리코쳇 로봇
 *    1. 문제 분류 : 그래프 탐색, dfs
 *    2. 접근 방법
 *      - 출발지점(R)에서 목표지점(G)으로 이동하는 경로를 bfs 탐색으로 찾음
 *      - 방문처리와 범위와 벽에 대한 조건 탐색이 필요
 */
const solution = (board) => {
  /* 변수 초기화 */
  const INF = 123456789;
  const [N, M] = [board.length, board[0].length];
  const drc = [
    [0, 1],
    [0, -1],
    [1, 0],
    [-1, 0],
  ];
  const dist = Array.from({ length: N }, () => Array.from({ length: M }, () => INF));
  let answer = INF;

  /* 메인 로직 */
  for (let i = 0; i < N; i++) {
    for (let j = 0; j < M; j++) {
      if (board[i].charAt(j) === "R") {
        bfs(i, j);
        break;
      }
    }
  }

  return answer === INF ? -1 : answer;

  /* 너비우선탐색, 도착지점에 도착하면 정답 갱신 */
  function bfs(r, c) {
    const q = [[r, c]];
    dist[r][c] = 0;

    while (q.length > 0) {
      const curr = q.shift();

      for (let i = 0; i < drc.length; i++) {
        let [nr, nc] = [curr[0], curr[1]];
        while (nr >= 0 && nr < N && nc >= 0 && nc < M && board[nr].charAt(nc) !== "D") {
          nr += drc[i][0];
          nc += drc[i][1];
        }
        nr -= drc[i][0];
        nc -= drc[i][1];
        if (dist[nr][nc] <= dist[curr[0]][curr[1]] + 1) continue;

        dist[nr][nc] = dist[curr[0]][curr[1]] + 1;
        if (board[nr].charAt(nc) === "G") {
          answer = Math.min(answer, dist[nr][nc]);
          continue;
        }
        q.push([nr, nc]);
      }
    }
  }
};

console.log(solution(["...D..R", ".D.G...", "....D.D", "D....D.", "..D...."]));
console.log(solution([".D.R", "....", ".G..", "...D"]));

