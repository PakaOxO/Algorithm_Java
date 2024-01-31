/**
 * BaekJoon_21736, 헌내기는 친구가 필요해
 *  - 문제 분류: 그래프 탐색
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/21736.txt").toString().trim().split("\n");
  const [N, M] = input[0].split(" ").map(Number);
  const map = Array.from({ length: N }, () => []);
  const start = [0, 0];
  const drc = [
    [0, 1],
    [0, -1],
    [1, 0],
    [-1, 0],
  ];
  let answer = 0;

  /* 메인 로직 */
  for (let i = 1; i <= N; i++) {
    const line = input[i];
    for (let j = 0; j < M; j++) {
      map[i - 1].push(line.charAt(j));
      if (map[i - 1][j] === "I") {
        [start[0], start[1]] = [i - 1, j];
      }
    }
  }

  dfs(...start);

  /* 정답 반환 */
  return answer ? answer : "TT";

  // dfs
  function dfs(r, c) {
    for (let i = 0; i < drc.length; i++) {
      const [nr, nc] = [r + drc[i][0], c + drc[i][1]];
      if (nr < 0 || nc < 0 || nr >= N || nc >= M || map[nr][nc] === "X") continue;
      if (map[nr][nc] === "P") answer++;
      map[nr][nc] = "X";
      dfs(nr, nc);
    }
  }
};

console.log(solution());
