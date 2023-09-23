/**
 * BaekJoon_14716, 현수막
 *  - 문제 분류 : 그래프 탐색
 */
const solution = () => {
  /* 변수 초기화 */
  const input = require("fs").readFileSync("./dev/stdin/14716.txt").toString().split("\n");
  const [N, M] = input[0].split(" ").map((item) => +item);
  const map = Array.from({ length: N }, (_, idx) => {
    return input[idx + 1].split(" ").map((item) => +item);
  });
  const drc = [
    [0, -1],
    [0, 1],
    [1, 0],
    [1, 1],
    [1, -1],
    [-1, 0],
    [-1, -1],
    [-1, 1],
  ];
  let answer = 0;

  /* 메인 로직 */
  for (let i = 0; i < N; i++) {
    for (let j = 0; j < M; j++) {
      if (map[i][j] === 0) continue;
      bfs(i, j);
      answer++;
    }
  }

  /* 정답 반환 */
  return answer;

  /* 주변 1을 따라 bfs탐색 */
  function bfs(i, j) {
    const q = [[i, j]];
    map[i][j] = 0;

    while (q.length > 0) {
      const [r, c] = q.shift();

      for (let i = 0; i < drc.length; i++) {
        const [nr, nc] = [r + drc[i][0], c + drc[i][1]];
        if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
        if (map[nr][nc] === 0) continue;
        q.push([nr, nc]);
        map[nr][nc] = 0;
      }
    }
  }
};

console.log(solution());
