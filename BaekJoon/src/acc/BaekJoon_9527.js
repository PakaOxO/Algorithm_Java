/**
 * BaekJoon_9527, 1의 개수 세기
 *  1. 문제 분류 : 누적 합
 *  2. 접근 방법
 *    -
 */
const solution = () => {
  let answer = 0;
  const [A, B] = require("fs")
    .readFileSync("./dev/stdin/9527.txt")
    .toString()
    .split(" ")
    .map((item) => +item);

  let base = 1;
  while (base < B) {
    base *= 2;
  }
  base /= 2;

  console.log(A, B, base);
  count(A, B, base);

  return answer;

  function count(a, b, base) {
    console.log(a, b, base);
    if (b <= 0) return;
    if (base >= a) {
      answer += b - base + 1;
      count(0, b - base, base / 2);
      count(0, a, base / 2);
    } else {
      answer += b - a + 1;
      count(a - base, b - base, base / 2);
    }
  }
};

console.log(solution());
