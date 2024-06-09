/**
 * BaekJoon_20186, 수 고르기
 *  - 문제 분류: 그리디, 정렬
 */
const solution = () => {
  /* 변수 관리 */
  const input = require('fs').readFileSync('./dev/stdin/20186.txt').toString().trim().split('\n');
  const [N, K] = input[0].split(' ').map(Number);
  const arr = input[1].split(' ').map(Number);
  let answer = -((K - 1) * K) / 2;

  /* 메인 로직 */
  arr.sort((a, b) => b - a);
  for (let i = 0; i < K; i++) answer += arr[i];

  /* 정답 반환 */
  return answer;
};

console.log(solution());

