/**
 * Programemrs_소수 만들기
 *   1. 문제 분류 : 수학, 에라토스테네스의 체, 조합론
 *   2. 접근 방법
 *    - 주어진 숫자에서 3개의 수를 뽑는 조합을 구함
 *    - 뽑기 전에 에라토스테네스의 체로 소수를 먼저 찾아 두자
 */
const solution = (nums) => {
  /* 변수 선언부 */
  let answer = 0;
  let isPrime = null;
  const len = nums.length;

  /* 메인 로직부 */
  getIsPrime(3001);
  combination(0, 0, 0);

  return answer;

  /* 메서드 */
  function getIsPrime(length) {
    isPrime = Array.from({ length: length }, () => true);
    isPrime[0] = isPrime[1] = false;

    for (let i = 2; i * i < length; i++) {
      if (!isPrime[i]) continue;
      for (let j = i + i; j < length; j += i) {
        isPrime[j] = false;
      }
    }
  }

  function combination(start, cnt, sum) {
    if (cnt === 3) {
      if (isPrime[sum]) answer++;
      return;
    }

    for (let i = start; i < len; i++) {
      combination(i + 1, cnt + 1, sum + nums[i]);
    }
  }
};

console.log(solution([1, 2, 3, 4]));
console.log(solution([1, 2, 7, 6, 4]));
