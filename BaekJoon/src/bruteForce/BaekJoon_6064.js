/**
 * BaekJoon_6064, 카잉 달력
 *  - 문제 분류: 완전 탐색, 수학
 */
const solution = () => {
  /* 변수 관리 */
  const input = require('fs').readFileSync('./dev/stdin/6064.txt').toString().trim().split('\n');
  const T = +input[0];
  let M, N, x, y, INF;
  const answer = [];

  /* 메인 로직 */
  for (let i = 1; i <= T; i++) {
    [M, N, x, y] = input[i].split(' ').map(Number);
    INF = M * N;
    if (x > M || y > N) {
      answer.push(-1);
      continue;
    }

    while (!(x === y)) {
      if (x > INF || y > INF) break;
      if (x < y) {
        x += M;
      } else {
        y += N;
      }
    }

    answer.push(x > INF || y > INF ? -1 : x);
  }

  /* 정답 반환 */
  return answer.join('\n');
};

console.log(solution());

