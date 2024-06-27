/**
 * BaekJoon_1374, 강의실
 *  - 문제 분류: 그리디, 정렬
 */
const solution = () => {
  /* 변수 관리 */
  const input = require('fs').readFileSync('./dev/stdin/1374.txt').toString().trim().split('\n');
  const N = +input[0];
  const arr = [];
  const v = Array.from({ length: N + 1 }, () => false);
  let count = 0;
  let answer = 0;

  /* 메인 로직 */
  for (let i = 1; i <= N; i++) {
    const [id, s, e] = input[i].split(' ').map(Number);
    arr.push([id, s]);
    arr.push([id, e]);
  }

  arr.sort((a, b) => a[1] - b[1]);

  for (let i = 0; i < N * 2; i++) {
    const [id, t] = arr[i];
    if (v[id]) {
      count--;
    } else {
      v[id] = true;
      count++;
    }

    if (i < N * 2 - 1 && arr[i + 1][1] === t) continue;
    answer = Math.max(answer, count);
  }

  /* 정답 반환 */
  return answer;
};

console.log(solution());
