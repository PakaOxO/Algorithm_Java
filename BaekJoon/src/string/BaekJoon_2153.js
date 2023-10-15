/**
 * BaekJoon_2153, 소수 단어
 *  - 문제 분류: 문자열, 수학
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/2153.txt").toString();
  const str = input.trim();
  const len = str.length;
  const MAX = 52 * 20;
  const isPrime = Array.from({ length: MAX + 1 }, () => true);
  let sum = 0;

  /* 메인 로직 */
  for (let i = 2; i * i <= MAX; i++) {
    if (!isPrime[i]) continue;
    for (let j = i + i; j <= MAX; j += i) {
      isPrime[j] = false;
    }
  }

  for (let i = 0; i < len; i++) {
    const ascii = str.charCodeAt(i);
    const num = ascii <= 90 ? ascii - (65 - 27) : ascii - 96;
    sum += num;
  }

  /* 정답 반환 */
  return isPrime[sum] ? "It is a prime word." : "It is not a prime word.";
};

console.log(solution());
