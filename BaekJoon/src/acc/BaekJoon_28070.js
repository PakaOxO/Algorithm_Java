/*
  BaekJoon_28070, 유니의 편지 쓰기
  Sketch Idea
    1. 누적합을 떠올리지 못해서 한참 고민했던 문제
    2. 연도 파싱 부분에서 문제를 찾지 못해 잘못된 코드를 작성하고 있었음.
*/
const solution = () => {
  let fs = require("fs");
  let input = fs.readFileSync("./dev/stdin/28070.txt").toString().split("\n");

  /* 메서드 */
  const dateToIdx = (year, month) => {
    return (year - 2000) * 12 + month - 1;
  };

  const idxToDate = (idx) => {
    const share = Math.floor(idx / 12) + 2000;
    const res = (idx % 12) + 1;
    return share + "-" + (res < 10 ? "0" : "") + res;
  };

  /* 초기값 */
  const N = +input[0];
  const maxL = (9999 - 2000 + 1) * 12 + 1;
  const acc = new Array(maxL).fill(0);

  for (let i = 1; i <= N; i++) {
    const [from, to] = input[i]
      .split(" ")
      .map((item) => item.split("-").map((str) => +str));

    const fromIdx = dateToIdx(from[0], from[1]);
    const toIdx = dateToIdx(to[0], to[1]);
    acc[fromIdx]++;
    acc[toIdx + 1]--;
  }

  let answer = idxToDate(0);
  let max = acc[0];
  for (let i = 1; i < maxL; i++) {
    acc[i] += acc[i - 1];
    if (acc[i] > max) {
      max = acc[i];
      answer = idxToDate(i);
    }
  }

  return answer;
};

console.log(solution());
