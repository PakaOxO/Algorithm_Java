/**
 * BaekJoon_11568, 인균이의 계략
 *  - 문제 분류: type
 */
const solution = () => {
  /* 변수 관리 */
  const input = require('fs').readFileSync('./dev/stdin/11568.txt').toString().trim().split('\n');
  const N = +input[0];
  const arr = [0, ...input[1].split(' ').map(Number)];
  const C = [0];
  const V = [0];
  let answer = 0;

  /* 메인 로직 */
  for (let i = 1; i <= N; i++) {
    const lower = binarySearch(arr[i], 0, V.length - 1, V);
    if (lower >= V.length) {
      V.push(arr[i]);
    } else {
      V[lower] = arr[i];
    }
    C[i] = lower;
    answer = Math.max(answer, C[i]);
  }

  /* 정답 반환 */
  return answer;

  // lowerbound
  function binarySearch(t, l, r, list) {
    while (l <= r) {
      const mid = Math.floor((l + r) / 2);
      if (list[mid] < t) {
        l = mid + 1;
      } else {
        r = mid - 1;
      }
    }
    return l;
  }
};

console.log(solution());

