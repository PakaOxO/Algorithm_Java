/**
 * CodeTree_원점으로 돌아가기
 *  - 문제 분류: 백트래킹
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/원점으로돌아가기.txt").toString().trim().split("\n");
  const N = +input[0];
  const points = input.slice(1).map((line) => line.split(" ").map(Number));
  const v = Array.from({ length: N }, () => false);
  let answer = 0;

  /* 메인 로직 */
  dfs(0, 0, 0, -1);

  /* 정답 반환 */
  return answer;

  // dfs
  function dfs(depth, x, y, dir) {
    if (depth === N) {
      if (x === 0 || y === 0) {
        const ndir = 0 === x ? (0 > y ? 0 : 2) : 0 > x ? 1 : 4;
        if (ndir !== dir) answer++;
      }
      return;
    }

    for (let i = 0; i < N; i++) {
      if (v[i]) continue;
      const [nx, ny] = points[i];
      if (nx !== x && ny !== y) continue;
      const ndir = nx === x ? (ny > y ? 0 : 2) : nx > x ? 1 : 4;
      if (dir === ndir) continue;
      v[i] = true;
      dfs(depth + 1, nx, ny, ndir);
      v[i] = false;
    }
  }
};

console.log(solution());

