const solution = () => {
  const fs = require("fs");
  const input = fs.readFileSync("./dev/stdin/17827.txt").toString().split("\n");
  const [N, M, V] = input[0].split(" ").map((item) => +item);
  const arr = input[1].split(" ").map((item) => +item);

  let answer = "";
  for (let i = 2; i < M + 2; i++) {
    const K = +input[i];
    if (K >= N) {
      answer += arr[((K - (V - 1)) % (N - (V - 1))) + V - 1] + "\n";
    } else {
      answer += arr[K] + "\n";
    }
  }
  return answer;
};

console.log(solution());
