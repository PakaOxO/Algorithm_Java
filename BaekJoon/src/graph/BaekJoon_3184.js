/**
 * BaekJoon_3184, 양
 *  - 문제 분류: 그래프 탐색
 */
const solution = () => {
  /* 변수 초기화 */
  const input = require("fs").readFileSync("./dev/stdin/3184.txt").toString().split("\n");
  const [N, M] = input[0].split(" ").map((item) => +item);
  const map = [];
  const v = Array.from({ length: N }, () => Array.from({ length: M }, () => false));
  const drc = [
    [0, 1],
    [0, -1],
    [1, 0],
    [-1, 0],
  ];
  const answer = [0, 0];

  for (let i = 0; i < N; i++) {
    map.push(input[i + 1].split(""));
  }

  /* 메인 로직 */
  for (let i = 0; i < N; i++) {
    for (let j = 0; j < M; j++) {
      if (map[i][j] === "#" || v[i][j]) continue;
      bfs(i, j);
    }
  }

  /* 정답 반환 */
  return answer.join(" ");

  /**
   * bfs 탐색을 하면서 해당 영역 양과 늑대의 수 찾기
   */
  function bfs(i, j) {
    const q = [[i, j]];
    let [sheep, wolf] = [0, 0];
    v[i][j] = true;

    while (q.length > 0) {
      const curr = q.shift();
      if (map[curr[0]][curr[1]] === "v") {
        wolf++;
      } else if (map[curr[0]][curr[1]] === "o") {
        sheep++;
      }

      for (let i = 0; i < drc.length; i++) {
        const [nr, nc] = [curr[0] + drc[i][0], curr[1] + drc[i][1]];
        if (nr < 0 || nc < 0 || nr >= N || nc >= M || v[nr][nc] || map[nr][nc] === "#") continue;
        q.push([nr, nc]);
        v[nr][nc] = true;
      }
    }

    if (sheep > wolf) {
      answer[0] += sheep;
    } else {
      answer[1] += wolf;
    }
  }
};

console.log(solution());
