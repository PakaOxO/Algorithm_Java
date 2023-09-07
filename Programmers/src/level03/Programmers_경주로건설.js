/**
 * Programmers_경주로 건설
 *    - 문제 분류 : 다이나믹 프로그래밍
 */
const solution = (board) => {
  /* 변수 초기화 */
  const N = board.length;
  const INF = Number.MAX_SAFE_INTEGER;
  const dist = Array.from({ length: N }, () => Array.from({ length: N }, () => Array.from({ length: 4 }, () => INF)));
  const drc = [
    [0, 1],
    [1, 0],
    [0, -1],
    [-1, 0],
  ];

  /* 메인 로직 */
  bfs(0, 0, 0, 0);

  return Math.min(dist[N - 1][N - 1]);

  /**
   * (0, 0)에서 (N - 1, N - 1)까지 최소 비용으로 건설
   */
  function bfs(r, c, cost, dir) {
    const q = [
      [r, c, 0, 0],
      [r, c, 0, 1],
    ];
    dist[0][0].fill(0);

    while (q.length > 0) {
      const [cr, cc, cost, dir] = q.shift();

      for (let i = 0; i < 4; i++) {
        const [nr, nc] = [cr + drc[i][0], cc + drc[i][1]];
        if (nr < 0 || nc < 0 || nr >= N || nc >= N || board[nr][nc] === 1) continue;
        const price = dir === i ? 100 : 600;
        if (dist[nr][nc][i] <= cost + price) continue;
        dist[nr][nc] = cost + price;
        q.push([nr, nc, cost + price, i]);
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

