/**
 * CodeTree_괄호 지렁이
 *  - 문제 분류: 백트래킹
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/괄호지렁이.txt").toString().trim().split("\n");
  const N = +input[0];
  const map = [];
  const v = Array.from({ length: N }, () => Array.from({ length: N }, () => false));
  const drc = [
    [0, 1],
    [0, -1],
    [1, 0],
    [-1, 0],
  ];
  let answer = 0;

  /* 메인 로직 */
  for (let i = 1; i <= N; i++) map.push(input[i].split(""));
  v[0][0] = true;
  dfs(0, 0, ...(map[0][0] === "(" ? [1, 0] : [0, 1]));

  /* 정답 반환 */
  return answer;

  // dfs
  function dfs(x, y, l, r) {
    if (r > l) return;
    if (l === r) {
      answer = Math.max(answer, l + r);
    }

    for (let i = 0; i < drc.length; i++) {
      const [nx, ny] = [x + drc[i][0], y + drc[i][1]];
      if (nx < 0 || ny < 0 || nx >= N || ny >= N || v[nx][ny]) continue;
      const isClose = map[nx][ny] === ")";
      if (map[x][y] === ")" && !isClose) continue;
      v[nx][ny] = true;
      dfs(nx, ny, l + (isClose ? 0 : 1), r + (isClose ? 1 : 0));
      v[nx][ny] = false;
    }
  }
};

console.log(solution());

