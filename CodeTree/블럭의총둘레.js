/**
 * CodeTree_블럭의 총 둘레
 *  - 문제 분류: dfs
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/블럭의총둘레.txt").toString().trim().split("\n");
  const N = +input[0];
  const SIZE = 100;
  const v = Array.from({ length: SIZE + 2 }, () => Array.from({ length: SIZE + 2 }, () => 0));
  const drc = [
    [0, 1],
    [0, -1],
    [1, 0],
    [-1, 0],
  ];
  let answer = 0;

  /* 메인 로직 */
  input.slice(1).forEach((item) => {
    const [x, y] = item.split(" ").map(Number);
    v[x][y] = -1;
  });
  dfs(0, 0);

  /* 정답 반환 */
  return answer;

  // dfs
  function dfs(x, y) {
    const stack = [[x, y]];
    v[x][y] = 1;

    while (stack.length > 0) {
      const [cx, cy] = stack.pop();

      for (let i = 0; i < drc.length; i++) {
        const [nx, ny] = [cx + drc[i][0], cy + drc[i][1]];
        if (nx < 0 || ny < 0 || nx > SIZE + 1 || ny > SIZE + 1 || v[nx][ny] > 0) continue;
        if (v[nx][ny] < 0) {
          answer++;
          continue;
        }
        v[nx][ny] = 1;
        stack.push([nx, ny]);
      }
    }
  }
};

console.log(solution());
