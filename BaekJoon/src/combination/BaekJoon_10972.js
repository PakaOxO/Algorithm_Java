const solution = () => {
  const fs = require("fs");
  const input = fs.readFileSync("./dev/stdin/10972.txt").toString().split("\n");
  const N = +input[0];
  const perm = input[1].split(" ").map((item) => +item);

  const swap = (i, j) => {
    const temp = perm[i];
    perm[i] = perm[j];
    perm[j] = temp;
  };

  let pointer = -1;
  for (let i = 0; i < N - 1; i++) {
    if (perm[i] < perm[i + 1]) {
      pointer = i;
    }
  }

  if (pointer >= 0) {
    let minIdx = pointer + 1;
    // 나보다 크면서 가장 작은 수(maxIdx 위치)를 찾아야 함
    for (let i = pointer + 2; i < N; i++) {
      if (perm[i] > perm[pointer] && perm[i] < perm[minIdx]) {
        minIdx = i;
      }
    }
    swap(pointer, minIdx);

    const sorted = perm.slice(pointer + 1);
    sorted.sort((a, b) => a - b);

    for (let i = pointer + 1; i < N; i++) {
      perm[i] = sorted[i - pointer - 1];
    }
    return perm.join(" ");
  }
  return -1;
};

console.log(solution());
