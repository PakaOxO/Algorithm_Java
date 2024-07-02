/**
 * BaekJoon_2550, 전구
 *  - 문제 분류: LIS
 */
const solution = () => {
  class Lamp {
    constructor(id) {
      this.s = 0;
      this.e = 0;
      this.id = id;
    }
  }

  /* 변수 관리 */
  const input = require('fs').readFileSync('./dev/stdin/2550.txt').toString().trim().split('\n');
  const N = +input[0];
  const lamps = Array.from({ length: N + 1 }, (_, idx) => new Lamp(idx));
  const start = input[1].split(' ').map(Number);
  const end = input[2].split(' ').map(Number);
  const lis = Array.from({ length: N + 1 }, () => 0);
  const min = [0];
  const list = [];

  /* 메인 로직 */
  for (let i = 0; i < N; i++) {
    lamps[start[i]].s = i + 1;
    lamps[end[i]].e = i + 1;
  }

  lamps.sort((a, b) => a.e - b.e);

  for (let i = 1; i <= N; i++) {
    const s = lamps[i].s;
    const id = lamps[i].id;

    const pos = binarySearch(s);
    lis[i] = pos;
    list.push([pos, id]);
    if (pos >= min.length) {
      min.push(s);
    } else {
      min[pos] = s;
    }
  }

  let idx = min.length - 1;
  const comb = [];
  for (let i = list.length - 1; i >= 0 && idx > 0; i--) {
    if (idx !== list[i][0]) continue;
    comb.push(list[i][1]);
    idx--;
  }
  comb.sort((a, b) => a - b);

  /* 정답 반환 */
  return `${min.length - 1}\n${comb.join(' ')}`;

  // 이분 탐색
  function binarySearch(target) {
    let [left, right] = [0, min.length - 1];
    while (left <= right) {
      const mid = Math.floor((left + right) / 2);
      if (min[mid] > target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }
};

console.log(solution());

