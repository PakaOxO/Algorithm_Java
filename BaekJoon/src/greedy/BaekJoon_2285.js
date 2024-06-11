/**
 * BaekJoon_2285, 우체국
 *  - 문제 분류: 그리디, 정렬
 */
const solution = () => {
  /* 변수 관리 */
  const input = require('fs').readFileSync('./dev/stdin/2285.txt').toString().trim().split('\n');
  const N = +input[0];
  const village = [];
  let total = 0;
  let answer = Infinity;

  /* 메인 로직 */
  for (let i = 1; i <= N; i++) {
    const [x, c] = input[i].split(' ').map(Number);
    if (c < 1) continue;
    total += c;
    village.push([x, c]);
  }

  village.sort((a, b) => a[0] - b[0]);

  let acc = 0;
  let mid = Math.floor(total / 2);
  for (let i = 0; i < N; i++) {
    acc += village[i][1];
    answer = village[i][0];
    if (acc > mid) break;
  }

  /* 정답 반환 */
  return answer;
};

console.log(solution());

