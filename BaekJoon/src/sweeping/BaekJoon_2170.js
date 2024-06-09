/**
 * BaekJoon_2170, 선 긋기
 *  - 문제 분류: 스위핑, 정렬
 */
const solution = () => {
  /* 변수 관리 */
  const input = require('fs').readFileSync('./dev/stdin/2170.txt').toString().trim().split('\n');
  const N = +input[0];
  const arr = [];
  let answer = 0;

  for (let i = 1; i <= N; i++) {
    const [x, y] = input[i].split(' ').map(Number);
    arr.push([x, y]);
  }

  arr.sort((a, b) => {
    if (a[0] === b[0]) return a[1] - b[1];
    return a[0] - b[0];
  });

  /* 메인 로직 */
  let start = arr[0][0];
  let end = arr[0][1];
  for (let i = 1; i < N; i++) {
    if (arr[i][0] > end) {
      answer += end - start;
      start = arr[i][0];
      end = arr[i][1];
    } else {
      end = Math.max(end, arr[i][1]);
    }
  }
  answer += end - start;

  /* 정답 반환 */
  return answer;
};

console.log(solution());

