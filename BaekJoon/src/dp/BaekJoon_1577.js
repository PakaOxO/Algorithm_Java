/**
 * BaekJoon_1577, 도로의 개수
 *  - 문제 분류: 다이나믹 프로그래밍, 최단 경로
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/1577.txt").toString().trim().split("\n");
  const [N, M] = input[0].split(" ").map(Number);
  const K = +input[1];
  const drc = [
    [-1, 0],
    [0, -1],
  ];
  const routes = Array.from({ length: N + 1 }, () =>
    Array.from({ length: M + 1 }, () => Array.from({ length: 4 }, () => true))
  );
  const dp = Array.from({ length: N + 1 }, () => Array.from({ length: M + 1 }, () => BigInt(0)));

  /* 메인 로직 */
  for (let i = 2; i < K + 2; i++) {
    const [a, b, c, d] = input[i].split(" ").map(Number);
    if (a === c) {
      if (b < d) {
        routes[c][d][1] = false;
      } else {
        routes[a][b][1] = false;
      }
    } else {
      if (a < c) {
        routes[c][d][0] = false;
      } else {
        routes[a][b][0] = false;
      }
    }
  }

  dp[0][0] = BigInt(1);
  for (let i = 0; i <= N; i++) {
    for (let j = 0; j <= M; j++) {
      for (let k = 0; k < 2; k++) {
        if (!routes[i][j][k]) continue;
        const [di, dj] = drc[k];
        const [ni, nj] = [i + di, j + dj];
        if (ni < 0 || nj < 0 || ni > N || nj > M) continue;
        dp[i][j] += dp[ni][nj];
      }
    }
  }

  /* 정답 반환 */
  return String(dp[N][M]);
};

console.log(solution());

