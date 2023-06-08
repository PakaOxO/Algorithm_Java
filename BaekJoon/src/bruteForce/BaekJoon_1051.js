const solution = () => {
  const fs = require("fs");
  const input = fs.readFileSync("./dev/stdin/1051.txt").toString().split("\n");

  const [N, M] = input[0].split(" ").map((item) => +item);
  let d = Math.min(N, M);

  const board = [];
  for (let i = 0; i < N; i++) {
    board.push(input[i + 1].split("").map((item) => +item));
  }

  loop: while (d > 0) {
    for (let i = 0; i < N - d + 1; i++) {
      for (let j = 0; j < M - d + 1; j++) {
        if (
          board[i][j] === board[i + d - 1][j] &&
          board[i][j] === board[i][j + d - 1] &&
          board[i][j] === board[i + d - 1][j + d - 1]
        )
          break loop;
      }
    }
    d--;
  }
  return Math.pow(d, 2);
};

console.log(solution());
