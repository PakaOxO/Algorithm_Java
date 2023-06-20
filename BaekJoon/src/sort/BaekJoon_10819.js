const solution = () => {
  const fs = require("fs");
  const input = fs.readFileSync("./dev/stdin/10819.txt").toString().split("\n");

  const N = +input[0];
  const perm = input[1].split(" ").map((item) => +item);
  let answer = 0;

  const getMaxSum = () => {
    let sum = 0;
    for (let i = 0; i < N - 1; i++) {
      sum += Math.abs(perm[i] - perm[i + 1]);
    }
    answer = Math.max(answer, sum);
  };

  const swap = (i, j) => {
    [perm[i], perm[j]] = [perm[j], perm[i]];
  };

  const dfs = (start, depth) => {
    if (depth === N - 1) {
      getMaxSum();
      return;
    }

    for (let i = start; i < N; i++) {
      swap(start, i);
      dfs(start + 1, depth + 1);
      swap(start, i);
    }
  };

  dfs(0, 0);

  return answer;
};

console.log(solution());
