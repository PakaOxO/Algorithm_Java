const solution = () => {
  const fs = require("fs");
  const N = +fs.readFileSync("./dev/stdin/10974.txt").toString();
  const isVisited = new Array(N).fill(false);
  const sel = [];
  const perms = [];

  const getPermutation = (depth) => {
    if (depth === N) {
      perms.push(sel.join(" "));
      return;
    }

    for (let i = 1; i <= N; i++) {
      if (isVisited[i]) continue;
      sel.push(i);
      isVisited[i] = true;
      getPermutation(depth + 1);
      sel.pop();
      isVisited[i] = false;
    }
  };

  getPermutation(0);
  return perms.join("\n");
};
console.log(solution());
