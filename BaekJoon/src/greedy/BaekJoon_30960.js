/**
 * BaekJoon_30960, 조별 과제
 *  - 문제 분류: 그리디, 정렬
 */
const solution = () => {
  /* 변수 관리 */
  const input = require('fs').readFileSync('./dev/stdin/30960.txt').toString().trim().split('\n');
  const N = +input[0];
  const arr = input[1].split(' ').map(Number);
  const left = [0];
  const right = [0];
  const groupCount = (N - 3) / 2 + 1;
  let answer = Infinity;

  /* 메인 로직 */
  arr.sort((a, b) => a - b);

  for (let i = 1; i < N; i += 2) {
    left.push(arr[i] - arr[i - 1] + left[left.length - 1]);
  }

  for (let i = N - 1; i > 0; i -= 2) {
    right.push(arr[i] - arr[i - 1] + right[right.length - 1]);
  }

  for (let i = 0; i < groupCount; i++) {
    answer = Math.min(answer, left[i] + right[groupCount - i - 1] + arr[i * 2 + 2] - arr[i * 2]);
  }

  /* 정답 반환 */
  return answer;
};

console.log(solution());

