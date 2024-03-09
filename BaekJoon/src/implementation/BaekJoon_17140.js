/**
 * BaekJoon_17140, 이차원 배열과 연산
 *  - 문제 분류: 정렬, 시뮬레이션
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/17140.txt").toString().trim().split("\n");
  let [R, C, K] = input[0].split(" ").map(Number);
  let board = input.slice(1).map((line) => line.split(" ").map(Number));
  let [row, col] = [board.length, board[0].length];
  let answer = 0;

  /* 메인 로직 */
  while (true) {
    if (R <= row && C <= col && board[R - 1][C - 1] === K) break;
    if (row >= col) sort("row");
    else sort("col");
    answer++;
    if (answer > 100) {
      answer = -1;
      break;
    }
  }

  /* 정답 반환 */
  return answer;

  // sort R
  function sort(type) {
    const maps = [];
    let maxSize = 0;
    let [X, Y] = [0, 0];

    if (type === "row") [X, Y] = [row, col];
    else [X, Y] = [col, row];

    for (let i = 0; i < X; i++) {
      const map = new Map();
      for (let j = 0; j < Y; j++) {
        if (type === "row") {
          if (board[i][j] === 0) continue;
          const count = map.get(board[i][j]);
          if (!count) {
            map.set(board[i][j], 1);
          } else {
            map.set(board[i][j], count + 1);
          }
        } else {
          if (board[j][i] === 0) continue;
          const count = map.get(board[j][i]);
          if (!count) {
            map.set(board[j][i], 1);
          } else {
            map.set(board[j][i], count + 1);
          }
        }
      }
      maps.push(map);
      maxSize = Math.max(maxSize, map.size);
    }

    if (maxSize > 50) maxSize = 50;

    let newBoard =
      type === "row"
        ? Array.from({ length: row }, () => Array.from({ length: maxSize * 2 }, () => 0))
        : Array.from({ length: maxSize * 2 }, () => Array.from({ length: col }, () => 0));

    for (let i = 0; i < X; i++) {
      const map = maps[i];
      const arr = [];
      for (const [key, val] of map) {
        arr.push([key, val]);
      }

      arr.sort((a, b) => {
        if (a[1] === b[1]) return a[0] - b[0];
        return a[1] - b[1];
      });

      for (let j = 0; j < maxSize; j++) {
        if (type === "row") {
          newBoard[i][j * 2] = j >= arr.length ? 0 : arr[j][0];
          newBoard[i][j * 2 + 1] = j >= arr.length ? 0 : arr[j][1];
        } else {
          newBoard[j * 2][i] = j >= arr.length ? 0 : arr[j][0];
          newBoard[j * 2 + 1][i] = j >= arr.length ? 0 : arr[j][1];
        }
      }
    }
    board = newBoard;
    row = board.length;
    col = board[0].length;
  }
};

console.log(solution());

