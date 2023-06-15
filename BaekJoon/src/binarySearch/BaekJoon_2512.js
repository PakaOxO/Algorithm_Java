const solution = () => {
  const fs = require("fs");
  const input = fs.readFileSync("./dev/stdin/2512.txt").toString().split("\n");

  const N = +input[0];
  const arr = input[1]
    .split(" ")
    .map((item) => +item)
    .sort((a, b) => a - b);
  const max = +input[2];

  let [left, right] = [0, arr[arr.length - 1]];
  let answer = right;
  while (left <= right) {
    const mid = Math.floor((left + right) / 2);

    const sum = arr.reduce((prev, acc) => {
      if (acc > mid) return prev + mid;
      return prev + acc;
    });

    if (sum > max) {
      right = mid - 1;
    } else {
      answer = mid;
      left = mid + 1;
    }
  }
  return answer;
};

console.log(solution());
