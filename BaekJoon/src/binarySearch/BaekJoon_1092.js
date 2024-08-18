/**
 * BaekJoon_1092, 배
 *  - 문제 분류: 이분 탐색
 */
const solution = () => {
  /* 변수 관리 */
  const input = require('fs').readFileSync('./dev/stdin/1092.txt').toString().trim().split('\n');
  const N = +input[0];
  const crane = input[1].split(' ').map(Number);
  const M = +input[2];
  const cargo = input[3].split(' ').map(Number);
  let [left, right] = [1, M];

  /* 메인 로직 */
  crane.sort((a, b) => b - a);
  cargo.sort((a, b) => b - a);

  while (left <= right) {
    const mid = Math.floor((left + right) / 2);
    const f = check(mid);
    if (f) {
      right = mid - 1;
    } else {
      left = mid + 1;
    }
  }

  /* 정답 반환 */
  return left > M ? -1 : left;

  // check
  function check(t) {
    let [p1, p2] = [0, 0];
    while (p2 < M) {
      if (p1 === N || crane[p1] < cargo[p2]) return false;
      p2 += t;
      p1++;
    }
    return true;
  }
};

console.log(solution());

