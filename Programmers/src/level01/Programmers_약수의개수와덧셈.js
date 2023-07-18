/**
 * Programmers_약수의 개수와 덧셈
 *  1. 문제 분류 : 수학
 *  2. 접근 방법
 *    - left부터 right까지 숫자를 순회
 */
const solution = (left, right) => {
  /* 변수 선언부 */
  let sum = 0;

  /* 메인 로직부 */
  for (let i = left; i <= right; i++) {
    if (hasOddCnt(i)) {
      sum -= i;
    } else {
      sum += i;
    }
  }

  return sum;

  /* 메서드 */
  function hasOddCnt(num) {
    let cnt = 0;
    const SQRT_NUM = Math.sqrt(num);
    for (let i = 1; i <= SQRT_NUM; i++) {
      const res = num % i;
      if (res > 0) continue;
      const share = num / i;
      if (share !== i) {
        cnt += 2;
      } else {
        cnt++;
      }
    }
    if (cnt % 2 > 0) {
      return true;
    }
    return false;
  }
};

console.log(solution(13, 17));
console.log(solution(24, 27));
