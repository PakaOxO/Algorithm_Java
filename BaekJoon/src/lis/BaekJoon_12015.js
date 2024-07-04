/**
 * plaformName_probName
 *  - 문제 분류: type
 */
const solution = () => {
  /* 변수 관리 */
  const input = require('fs').readFileSync('./dev/stdin/12015.txt').toString().trim().split('\n');
  const N = +input[0];
  const arr = [0, ...input[1].split(' ').map(Number)];
  const C = [0];
  const V = [0];
  let answer = 0;

  /* 메인 로직 */
  for (let i = 1; i <= N; i++) {
    const p = binarySearch(arr[i], 0, V.length - 1, V);
    if (p >= V.length) {
      V.push(arr[i]);
    } else {
      V[p] = arr[i];
    }
    C.push(p);
    if (p > answer) answer = p;
  }

  /* 정답 반환 */
  return answer;

  // 이분 탐색
  function binarySearch(t, l, r, list) {
    while (l <= r) {
      const mid = Math.floor((l + r) / 2);
      if (list[mid] >= t) {
        r = mid - 1;
      } else {
        l = mid + 1;
      }
    }
    return l;
  }
};

console.log(solution());

