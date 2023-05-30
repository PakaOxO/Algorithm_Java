/*
  BaekJoon_1890, 점프
  Sketch Idea
    1. JS 숫자 범위는 -(2^53-) ~ (2^53-1)이다... (이거 때문에 한참 틀림..)
    2. 이전에 방문했던 위치에서 종착점까지 가는 가지 수를 가져와 현재 dp에 더해줘야 함(top-down 방식)
*/
const solution = () => {
  // const fs = require("fs");
  // const input = fs.readFileSync("./dev/stdin").toString().split("\n");
  let fs = require("fs");
  let input = fs.readFileSync("./dev/stdin/1890.txt").toString().split("\n");

  /* 초기값 */
  const N = +input[0];
  const board = [];
  const dp = [];
  for (let i = 1; i <= N; i++) {
    const dist = input[i].split(" ").map((item) => +item);
    board.push(dist);
    dp.push(new Array(N).fill(-1));
  }

  /* 메서드 */
  const dfs = (r, c) => {
    if (r >= N || c >= N) return 0;
    if (r == N - 1 && c == N - 1) {
      return 1;
    }
    if (board[r][c] === 0) {
      return 0;
    }

    if (dp[r][c] !== -1) {
      return dp[r][c];
    }

    return (dp[r][c] =
      BigInt(dfs(r + board[r][c], c)) + BigInt(dfs(r, c + board[r][c])));
  };

  return dfs(0, 0).toString();
};

console.log(solution());
