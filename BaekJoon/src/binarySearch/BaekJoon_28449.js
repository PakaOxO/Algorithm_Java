/**
 * BaekJoon_28449, 누가 이길까
 *  - 문제 분류: 이분 탐색, 정렬
 */
const solution = () => {
  /* 변수 관리 */
  const input = require('fs').readFileSync('./dev/stdin/28449.txt').toString().trim().split('\n');
  const [N, M] = input[0].split(' ').map(Number);
  const TEAM_HI = input[1].split(' ').map(Number);
  const TEAM_ARC = input[2].split(' ').map(Number);
  const answer = [0, 0, 0];

  /* 메인 로직 */
  TEAM_HI.sort((a, b) => a - b);
  TEAM_ARC.sort((a, b) => a - b);

  for (let i = 0; i < N; i++) {
    const upper = findUpper(TEAM_HI[i], TEAM_ARC);
    const lower = findLower(TEAM_HI[i], TEAM_ARC);
    answer[0] += upper + 1;
    answer[1] += TEAM_ARC.length - lower;
    answer[2] += lower - upper - 1;
  }

  /* 정답 반환 */
  return answer.join(' ');

  // findUpper
  function findUpper(target, arr) {
    let [left, right] = [0, arr.length - 1];
    while (left <= right) {
      const mid = Math.floor((left + right) / 2);
      if (arr[mid] >= target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return right;
  }

  // findLower
  function findLower(target, arr) {
    let [left, right] = [0, arr.length - 1];
    while (left <= right) {
      const mid = Math.floor((left + right) / 2);
      if (arr[mid] <= target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return left;
  }
};

console.log(solution());

