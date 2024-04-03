/**
 * BaekJoon_11501, 주식
 *  - 문제 분류: 그리디
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/11501.txt").toString().trim().split("\n");
  const T = +input[0];
  let pointer = 1;
  const answer = [];

  /* 메인 로직 */
  for (let i = 0; i < T; i++) {
    const N = +input[pointer++];
    const stock = input[pointer++].split(" ").map(Number);
    let max = 0;
    let profit = 0;

    for (let j = N - 1; j >= 0; j--) {
      if (stock[j] > max) max = stock[j];
      profit += max - stock[j];
    }

    answer.push(profit);
  }

  /* 정답 반환 */
  return answer.join("\n");
};

console.log(solution());

