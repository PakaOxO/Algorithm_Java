/**
 * BaekJoon_14466, 소가 길을 건너간 이유 6
 *  - 문제 분류: 그래프 탐색
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/14466.txt").toString().split("\n");
  const [N, K, R] = input[0].split(" ").map((item) => +item);
  const map = Array.from({ length: N + 1 }, () => Array.from({ length: N + 1 }, () => -1));
  const hasRoad = Array.from({ length: N + 1 }, () =>
    Array.from({ length: N + 1 }, () => Array.from({ length: 4 }, () => false))
  );
  const drc = [
    [1, 0],
    [-1, 0],
    [0, 1],
    [0, -1],
  ];
  const cows = Array.from({ length: K }, () => -1);
  let answer = 0;

  /* 메인 로직 */
  for (let i = 1; i <= R; i++) {
    const [r, c, r2, c2] = input[i].split(" ").map((item) => +item);
    if (r === r2) {
      if (c > c2) {
        hasRoad[r][c][3] = true;
        hasRoad[r2][c2][2] = true;
      } else {
        hasRoad[r][c][2] = true;
        hasRoad[r2][c2][3] = true;
      }
    } else {
      if (r > r2) {
        hasRoad[r][c][1] = true;
        hasRoad[r2][c2][0] = true;
      } else {
        hasRoad[r][c][0] = true;
        hasRoad[r2][c2][1] = true;
      }
    }
  }

  let idx = 0;
  for (let i = 1; i <= N; i++) {
    for (let j = 1; j <= N; j++) {
      if (map[i][j] >= 0) continue;
      bfs(i, j, idx++);
    }
  }

  let cow = 0;
  for (let i = R + 1; i < R + 1 + K; i++) {
    const [r, c] = input[i].split(" ").map((item) => +item);
    cows[cow++] = map[r][c];
  }

  for (let i = 0; i < K; i++) {
    for (let j = i + 1; j < K; j++) {
      if (cows[i] !== cows[j]) answer++;
    }
  }

  /* 정답 반환 */
  return answer;

  /**
   * 길을 못가는 길이라고 생각해서 bfs 탐색, 길을 타지 않고 이어진 구간을 블록화
   */
  function bfs(r, c, idx) {
    const queue = [[r, c]];
    map[r][c] = idx;

    while (queue.length > 0) {
      const [cr, cc] = queue.shift();
      for (let i = 0; i < drc.length; i++) {
        const [nr, nc] = [cr + drc[i][0], cc + drc[i][1]];
        if (nr < 1 || nc < 1 || nr > N || nc > N) continue;
        if (hasRoad[cr][cc][i] || map[nr][nc] >= 0) continue;
        map[nr][nc] = idx;
        queue.push([nr, nc]);
      }
    }
  }
};

console.log(solution());

