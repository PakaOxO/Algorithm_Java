/**
 * BaekJoon_1644, 소수의 연속합
 *  - 문제 분류: 수학, 조합
 */
const solution = () => {
  /* 변수 관리 */
  const N = +require("fs").readFileSync("./dev/stdin/1644.txt").toString().trim();
  const isPrime = Array.from({ length: N + 1 }, () => true);
  const primeNumber = [];
  let answer = 0;

  /* 메인 로직 */
  // 소수판정(에라토스테네스의 체)
  isPrime[0] = isPrime[1] = false;
  for (let i = 2; i <= N; i++) {
    if (!isPrime[i]) continue;
    primeNumber.push(i);
    for (let j = i + i; j <= N; j += i) {
      isPrime[j] = false;
    }
  }

  for (let i = primeNumber.length - 1; i >= 0; i--) {
    let res = N;
    for (let j = i; j >= 0; j--) {
      res -= primeNumber[j];
      if (res <= 0) {
        if (res === 0) {
          answer++;
        }
        break;
      }
    }
  }

  /* 정답 반환 */
  return answer;
};

console.log(solution());

