/**
 * BaekJoon_1303, 전쟁 - 전투
 *  - 문제 분류: 그래프 탐색
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/1303.txt").toString().trim().split("\n");
  const [N, M] = input[0].split(" ").map(Number);
  const map = [];
  let [W, B] = [0, 0];
  const drc = [
    [0, 1],
    [0, -1],
    [1, 0],
    [-1, 0],
  ];
  const v = Array.from({ length: M }, () => Array.from({ length: N }, () => false));

  const bfs = (i, j) => {
    const q = [[i, j]];
    v[i][j] = true;
    let count = 0;

    while (q.length > 0) {
      const [r, c] = q.shift();
      count++;

      for (const [dr, dc] of drc) {
        const [nr, nc] = [r + dr, c + dc];
        if (nr < 0 || nc < 0 || nr >= M || nc >= N) continue;
        if (v[nr][nc] || map[nr][nc] !== map[r][c]) continue;
        v[nr][nc] = true;
        q.push([nr, nc]);
      }
    }

    return count * count;
  };

  /* 메인 로직 */
  for (let i = 1; i <= M; i++) {
    map.push(input[i].split(""));
  }

  for (let i = 0; i < M; i++) {
    for (let j = 0; j < N; j++) {
      if (v[i][j]) continue;

      if (map[i][j] === "W") {
        W += bfs(i, j);
      } else {
        B += bfs(i, j);
      }
    }
  }

  /* 정답 반환 */
  return `${W} ${B}`;
};

console.log(solution());
