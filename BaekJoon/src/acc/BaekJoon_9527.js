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
  const acc = Array.from({ length: 16 }, () => 0);
  acc[0] = 1;
  for (let i = 1; i < 16; i++) {
    acc[i] = acc[i - 1] + Math.pow(2, i);
  }
  console.log(acc);

  console.log(count(B), count(A));

  return answer;

  function count(n) {
    if (n <= 1) {
      return n < 0 ? 0 : n;
    }

    let cnt = -1;
    let dummy = n;
    while (dummy > 1) {
      dummy = ~~(dummy / 2);
      cnt++;
    }
    console.log(cnt);
    return acc[cnt] + count(n - Math.pow(2, cnt));
  }
};

console.log(solution());
// 110
// 101
// 100
// 11;
// 10;
// 01;
// 00;
