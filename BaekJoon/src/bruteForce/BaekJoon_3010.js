const solution = () => {
  const fs = require("fs");
  const input = fs.readFileSync("./dev/stdin/3010.txt").toString().split("\n");

  const drc = [
    [1, 0],
    [-1, 0],
    [0, 1],
    [0, -1],
  ];
  const board = [];
  const size = 7;

  for (let i = 0; i < size; i++) {
    board.push(input[i].split(""));
  }

  let answer = 0;
  for (let i = 0; i < size; i++) {
    for (let j = 0; j < size; j++) {
      const b = board[i][j];
      if (b !== "o") continue;

      for (let k = 0; k < 4; k++) {
        const [nr, nc] = [i + drc[k][0] * 2, j + drc[k][1] * 2];
        const [nr2, nc2] = [i + drc[k][0], j + drc[k][1]];
        if (nr < 0 || nc < 0 || nr >= size || nc >= size) continue;
        if (nr2 < 0 || nc2 < 0 || nr2 >= size || nc2 >= size) continue;
        if (board[nr2][nc2] !== "o" || board[nr][nc] !== ".") continue;

        answer++;
      }
    }
  }

  return answer;
};

console.log(solution());
