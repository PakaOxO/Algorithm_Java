const solution = () => {
  const fs = require("fs");
  const input = fs.readFileSync("./dev/stdin/20291.txt").toString().split("\n");

  const N = +input[0];
  const dict = new Map();
  const arr = [];
  for (let i = 1; i <= N; i++) {
    const file = input[i].split(".")[1].trim();
    if (!dict.has(file)) {
      dict.set(file, 1);
      arr.push(file);
    } else {
      dict.set(file, dict.get(file) + 1);
    }
  }
  arr.sort();

  let answer = "";
  for (let i = 0; i < arr.length; i++) {
    answer += arr[i] + " " + dict.get(arr[i]) + "\n";
  }
  return answer.trim();
};

console.log(solution());
