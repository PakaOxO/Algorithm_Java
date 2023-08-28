/**
 * Programmers_입국 심사
 *  1. 문제 분류 : 이분 탐색
 *  2. 접근 방법
 *    -
 */
const solution = (n, times) => {
  /* 변수 초기화 */
  const T = times.length;
  let INF = Math.pow(10, 18);

  /* 메인 로직 */
  answer = binarySearch(1, INF);

  /* 정답 반환 */
  return answer;

  /* 이분 탐색 */
  function binarySearch(left, right) {
    while (left <= right) {
      const mid = Math.floor((left + right) / 2);
      if (check(mid)) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }

  /* 시간 안에 심사를 마칠 수 있는지 */
  function check(time) {
    let sum = 0;
    for (let i = 0; i < T; i++) {
      sum += Math.floor(time / times[i]);
      if (sum >= n) return true;
    }

    return sum >= n;
  }
};

console.log(solution(6, [7, 10]));

