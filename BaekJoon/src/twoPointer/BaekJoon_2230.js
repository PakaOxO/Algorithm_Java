/**
 * BaekJoon_2230, 수 고르기
 *  - 문제 분류: 투 포인터, 정렬
 */
const solution = () => {
  /* 변수 관리 */
  const input = require('fs').readFileSync('./dev/stdin/2230.txt').toString().trim().split('\n');
  const [N, M] = input[0].split(' ').map(Number);
  const arr = input.slice(1).map(Number);

  arr.sort((a, b) => a - b);

  /* 메인 로직 */
  let answer = arr[N - 1] - arr[0];
  let [left, right] = [0, 0];
  while (left < N && right < N) {
    while (arr[right] - arr[left] < M) right++;
    if (right >= N) break;
    answer = Math.min(answer, arr[right] - arr[left]);
    left++;
  }

  /* 정답 반환 */
  return answer;
};

console.log(solution());

