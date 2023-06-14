const solution = () => {
  const fs = require("fs");
  const [n, m, r] = fs
    .readFileSync("./dev/stdin/5616.txt")
    .toString()
    .split(" ")
    .map((item) => +item);

  const [x, y] = [n + r - n * m - 1, r - n * m];

  const factorial = (x) => {
    let result = BigInt(1);
    while (x > 0) {
      result *= BigInt(x);
      x--;
    }
    return result;
  };

  if (y < 1) return 0;
  return (factorial(x) / (factorial(x - y) * factorial(y))).toString();
};

console.log(solution());
