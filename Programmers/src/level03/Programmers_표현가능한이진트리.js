/**
 * Programmers_표현 가능한 이진트리
 *  - 문제 분류: 트리, 수학
 */
const solution = (numbers) => {
  /* 변수 관리 */
  const N = numbers.length;
  const answer = Array.from({ length: N }, () => 0);

  /* 메인 로직 */
  for (let i = 0; i < N; i++) {
    if (check(numbers[i])) answer[i] = 1;
  }

  /* 정답 반환 */
  return answer;

  // check
  function check(num) {
    const len = getLength(num);
    const flag = binarySearch(0, len - 1, num);

    return flag === num;
  }

  // binarySearch
  function binarySearch(left, right, num) {
    if (left > right) return 0;
    const mid = Math.floor((left + right) / 2);
    const pow = Math.pow(2, mid);
    if (num < pow) return 0;
    const rightPow = binarySearch(mid + 1, right, num - pow);
    const leftPow = binarySearch(left, mid - 1, num - pow - rightPow);

    return leftPow + pow + rightPow;
  }

  // 숫자 만드는데 필요한 트리 깊이
  function getLength(num) {
    let len = 1;
    let size = 1;

    while (num >= Math.pow(2, len)) {
      size *= 2;
      len += size;
    }

    return len;
  }
};

// console.log(solution([44]));
console.log(solution([2, 8, 7, 42, 5, 63, 111, 95, 1000000000000000]));
// 10 // 010 -> 3
// 111 // 111 -> 3
// 0001000 // -> 7
// 10000000 //
// 0101010 32 + 8 + 2
