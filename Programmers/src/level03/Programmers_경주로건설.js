/**
 * Programmers_경주로 건설
 *    - 문제 분류 : 그래프 탐색, 백트래킹
 */
const solution = (board) => {
  /* 변수 초기화 */
  const N = board.length;
  const INF = Number.MAX_SAFE_INTEGER;
  // const dist = Array.from({ length: N }, () => Array.from({ length: N }, () => INF));
  const dist = Array.from({ length: N }, () => Array.from({ length: N }, () => Array.from({ length: 4 }, () => INF)));
  const drc = [
    [0, 1],
    [1, 0],
    [0, -1],
    [-1, 0],
  ];
  let answer = INF;

  /* 메인 로직 */
  bfs(0, 0, 0, 0);

  /* 정답 반환 */
  return answer;

  /**
   * 시작점(r, c)에서 bfs 탐색을 진행하면서 (N - 1, N - 1)까지 최소 비용으로 건설
   */
  function bfs(r, c) {
    const q = [
      [r, c, 0],
      [r, c, 1],
    ];
    dist[0][0].fill(0);

    while (q.length > 0) {
      const [cr, cc, dir] = q.shift();

      for (let i = 0; i < 4; i++) {
        if ((dir + 2) % 4 === i) continue;
        const [nr, nc] = [cr + drc[i][0], cc + drc[i][1]];
        if (nr < 0 || nc < 0 || nr >= N || nc >= N || board[nr][nc] === 1) continue;

        const cost = dist[cr][cc][dir];
        const price = dir < 0 || dir === i ? 100 : 600;
        if (dist[nr][nc][i] <= cost + price || answer <= cost + price) continue;

        dist[nr][nc][i] = cost + price;
        if (nr === N - 1 && nc === N - 1) {
          answer = cost + price;
          continue;
        }
        q.push([nr, nc, i]);
      }
    }
  }
};

console.log(
  solution([
    [0, 0, 0, 0, 0],
    [0, 1, 1, 1, 0],
    [0, 0, 1, 0, 0],
    [1, 0, 0, 0, 1],
    [1, 1, 1, 0, 0],
  ])
);

// console.log(
//   solution([
//     [0, 0, 0],
//     [0, 0, 0],
//     [0, 0, 0],
//   ])
// );
// console.log(
//   solution([
//     [0, 0, 0, 0, 0, 0, 0, 1],
//     [0, 0, 0, 0, 0, 0, 0, 0],
//     [0, 0, 0, 0, 0, 1, 0, 0],
//     [0, 0, 0, 0, 1, 0, 0, 0],
//     [0, 0, 0, 1, 0, 0, 0, 1],
//     [0, 0, 1, 0, 0, 0, 1, 0],
//     [0, 1, 0, 0, 0, 1, 0, 0],
//     [1, 0, 0, 0, 0, 0, 0, 0],
//   ])
// );
// console.log(
//   solution([
//     [0, 0, 1, 0],
//     [0, 0, 0, 0],
//     [0, 1, 0, 1],
//     [1, 0, 0, 0],
//   ])
// );
// console.log(
//   solution([
//     [0, 0, 0, 0, 0, 0],
//     [0, 1, 1, 1, 1, 0],
//     [0, 0, 1, 0, 0, 0],
//     [1, 0, 0, 1, 0, 1],
//     [0, 1, 0, 0, 0, 1],
//     [0, 0, 0, 0, 0, 0],
//   ])
// );
