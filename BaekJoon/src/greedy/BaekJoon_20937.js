/**
 * BaekJoon_20937, 떡국
 *  - 문제 분류: 그리디, 정렬
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/20937.txt").toString().trim().split("\n");
  const N = +input[0];
  const bowl = input[1].split(" ").map(Number);
  let count = 1;
  let answer = 1;

  /* 메인 로직 */
  bowl.sort((a, b) => b - a);
  for (let i = 1; i < N; i++) {
    if (bowl[i - 1] === bowl[i]) {
      count++;
    } else {
      count = 1;
    }

    answer = Math.max(answer, count);
  }

  /* 정답 반환 */
  return answer;
};

console.log(solution());

