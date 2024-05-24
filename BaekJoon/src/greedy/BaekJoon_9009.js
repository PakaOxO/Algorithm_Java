/**
 * BaekJoon_9009, 피보나치
 *  - 문제 분류: 그리디
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/9009.txt").toString().trim().split("\n");
  const T = +input[0];
  const MAX_VALUE = 1000000000;
  const fibonachi = [0, 1];
  const answer = [];

  /* 메인 로직 */
  while (true) {
    const i = fibonachi.length;
    const next = fibonachi[i - 1] + fibonachi[i - 2];
    if (next > MAX_VALUE) break;
    fibonachi.push(next);
  }

  for (let i = 1; i <= T; i++) {
    let N = +input[i];
    const arr = [];
    for (let j = fibonachi.length - 1; j > 0; j--) {
      if (fibonachi[j] > N) continue;
      N -= fibonachi[j];
      arr.push(fibonachi[j]);
    }
    answer.push(arr.reverse().join(" "));
  }

  /* 정답 반환 */
  return answer.join("\n");
};

console.log(solution());

