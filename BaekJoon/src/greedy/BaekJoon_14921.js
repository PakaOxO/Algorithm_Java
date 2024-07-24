/**
 * BaekJoon_14921, 용액 합성하기
 *  - 문제 분류: 그리디, 투 포인터
 */
const solution = () => {
  /* 변수 관리 */
  const input = require('fs').readFileSync('./dev/stdin/14921.txt').toString().trim().split('\n');
  const N = +input[0];
  const resolution = input[1].split(' ').map(Number);
  let [left, right] = [0, N - 1];
  let answer = Number.MAX_SAFE_INTEGER;

  /* 메인 로직 */
  if (resolution[left] <= 0 && resolution[right] <= 0) {
    return resolution[right] + resolution[right - 1];
  } else if (resolution[left] >= 0 && resolution[right] >= 0) {
    return resolution[left] + resolution[left + 1];
  }

  while (left < right) {
    const sum = resolution[left] + resolution[right];
    if (Math.abs(sum) < Math.abs(answer)) answer = sum;

    if (sum < 0) left++;
    else right--;
  }

  /* 정답 반환 */
  return answer;
};

console.log(solution());

