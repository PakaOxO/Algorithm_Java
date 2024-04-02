/**
 * BaekJoon_28136, 원, 탁!
 *  - 문제 분류: 그리디
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/28136.txt").toString().trim().split("\n");
  const N = +input[0];
  const table = input[1].split(" ").map(Number);
  let answer = 0;

  /* 메인 로직 */
  for (let i = 0; i < N; i++) {
    const next = (i + 1) % N;
    if (table[i] < table[next]) continue;
    answer++;
  }

  /* 정답 반환 */
  return answer;
};

console.log(solution());
