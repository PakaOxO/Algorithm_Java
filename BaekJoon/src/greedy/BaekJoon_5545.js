/**
 * BaekJoon_5545, 최고의 피자
 *  - 문제 분류: 그리디, 정렬
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/5545.txt").toString().trim().split("\n");
  const N = +input[0];
  const [A, B] = input[1].split(" ").map(Number);
  const C = +input[2];
  const ks = input.slice(3).map(Number);
  let price = A;
  let calories = C;
  let answer = Math.floor(C / A);

  /* 메인 로직 */
  ks.sort((a, b) => b - a);
  for (let i = 0; i < N; i++) {
    const p = price + B;
    const c = calories + ks[i];
    if (Math.floor(c / p) < answer) break;
    price = p;
    calories = c;
    answer = Math.floor(c / p);
  }

  /* 정답 반환 */
  return answer;
};

console.log(solution());

