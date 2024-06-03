/**
 * plaformName_15965, K번째 소수
 *  - 문제 분류: 수학
 */
const solution = () => {
  /* 변수 관리 */
  const K = +require('fs').readFileSync('./dev/stdin/15965.txt').toString().trim();
  const INF = 10000000;
  const isPrime = Array.from({ length: INF + 1 }, (_, idx) => (idx % 2 === 0 ? false : true));
  let answer = -1;

  /* 메인 로직 */
  isPrime[1] = false;
  isPrime[2] = true;

  for (let i = 3; i * i <= INF; i++) {
    if (!isPrime[i]) continue;
    for (let j = i * i; j < INF; j += i) {
      isPrime[j] = false;
    }
  }

  let pointer = 1;
  let count = 0;
  while (count < K) {
    pointer++;
    if (!isPrime[pointer]) continue;
    count++;
    answer = pointer;
  }

  /* 정답 반환 */
  return answer;
};

console.log(solution());

