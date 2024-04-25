/**
 * BaekJoon_18405, 경쟁적 전염
 *  - 문제 분류: 그래프 탐색, 구현
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/18405.txt").toString().trim().split("\n");
  const [N, K] = input[0].split(" ").map(Number);
  const [S, X, Y] = input[N + 1].split(" ").map(Number);
  const drc = [
    [0, 1],
    [0, -1],
    [1, 0],
    [-1, 0],
  ];
  const map = [];
  const virus = Array.from({ length: K + 1 }, () => []);

  for (let i = 1; i <= N; i++) {
    const line = input[i].split(" ");
    const arr = [];

    for (let j = 0; j < N; j++) {
      arr.push(+line[j]);

      if (+line[j]) {
        virus[+line[j]].push([i - 1, j]);
      }
    }

    map.push(arr);
  }

  /* 메인 로직 */
  for (let i = 0; i < S; i++) {
    if (map[X - 1][Y - 1] > 0) break;
    contagion();
  }

  /* 정답 반환 */
  return map[X - 1][Y - 1];

  // 전염
  function contagion() {
    for (let i = 1; i <= K; i++) {
      const count = virus[i].length;
      if (!count) continue;

      for (let j = 0; j < count; j++) {
        const [r, c] = virus[i].shift();

        for (const [dr, dc] of drc) {
          const [nr, nc] = [r + dr, c + dc];
          if (nr < 0 || nc < 0 || nr >= N || nc >= N || map[nr][nc] > 0) continue;
          map[nr][nc] = i;
          virus[i].push([nr, nc]);
        }
      }
    }
  }
};

console.log(solution());

