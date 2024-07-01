/**
 * BaekJoon_19637, IF문 좀 대신 써줘
 *  - 문제 분류: 이분 탐색
 */
const solution = () => {
  /* 변수 관리 */
  const input = require('fs').readFileSync('./dev/stdin/19637.txt').toString().trim().split('\n');
  const [N, M] = input[0].split(' ').map(Number);
  const title = [];
  const answer = [];

  for (let i = 1; i <= N; i++) {
    title.push(input[i].split(' '));
  }
  title.sort((a, b) => a - b);

  /* 메인 로직 */
  for (let i = N + 1; i < N + M + 1; i++) {
    const stat = +input[i];
    const max = binarySearch(stat);
    answer.push(title[max][0]);
  }

  /* 정답 반환 */
  return answer.join('\n');

  // 이분 탐색
  function binarySearch(target) {
    let [left, right] = [0, title.length - 1];
    while (left <= right) {
      const mid = Math.floor((left + right) / 2);
      if (+title[mid][1] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return left;
  }
};

console.log(solution());

