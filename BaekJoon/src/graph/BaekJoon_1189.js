/**
 * BaekJoon_1189, 컴백홈
 *  - 문제 분류: 그래프 탐색
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/1189.txt").toString().split("\n");
  const [R, C, K] = input[0].split(" ").map((item) => +item);
  const map = [];
  const visited = Array.from({ length: R }, () => Array.from({ length: C }, () => false));
  const drc = [
    [-1, 0],
    [0, -1],
    [1, 0],
    [0, 1],
  ];
  let answer = 0;

  for (let i = 1; i <= R; i++) {
    map.push(input[i].split(""));
  }

  /* 메인 로직 */
  visited[R - 1][0] = true;
  dfs(R - 1, 0, 0, C - 1, 1);

  /* 정답 반환 */
  return answer;

  /**
   * (r1, c1)에서 시작해 (r2, c2)에서 끝나는 경우의 수
   */
  function dfs(r1, c1, r2, c2, dist) {
    if (r1 === r2 && c1 === c2) {
      if (dist === K) answer++;
      return;
    }

    for (let i = 0; i < drc.length; i++) {
      const [nr, nc] = [r1 + drc[i][0], c1 + drc[i][1]];
      if (nr < 0 || nc < 0 || nr >= R || nc >= C || map[nr][nc] === "T" || visited[nr][nc]) continue;
      visited[nr][nc] = true;
      dfs(nr, nc, r2, c2, dist + 1);
      visited[nr][nc] = false;
    }
  }
};

console.log(solution());

