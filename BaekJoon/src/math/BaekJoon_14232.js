/**
 * BaekJoon_14232, 보석 도둑
 *  - 문제 분류: 수학, 에라토스테네스의 체
 */
const solution = () => {
  /* 변수 관리 */
  let k = +require('fs').readFileSync('./dev/stdin/14232.txt').toString().trim();
  const sqrt = Math.floor(Math.sqrt(k, 2));
  const isPrime = Array.from({ length: sqrt + 1 }, () => true);
  const prime = [];
  let count = 0;
  const list = [];

  /* 메인 로직 */
  isPrime[0] = isPrime[1] = false;
  for (let i = 2; i <= sqrt; i++) {
    if (!isPrime[i]) continue;
    prime.push(i);
    for (let j = i * i; j <= sqrt; j += i) {
      isPrime[j] = false;
    }
  }

  let pointer = 0;
  while (k > 1 && pointer < prime.length) {
    if (k % prime[pointer] > 0) {
      pointer++;
      continue;
    }
    k /= prime[pointer];
    count++;
    list.push(prime[pointer]);
  }

  if (k > 1) {
    count++;
    list.push(k);
  }

  /* 정답 반환 */
  return `${count}\n${list.join(' ')}`;
};

console.log(solution());

