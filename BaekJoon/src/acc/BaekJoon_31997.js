/**
 * BaekJoon_31997, 즐거운 회의
 *  - 문제 분류: 누적합
 */
const solution = () => {
  /* 변수 관리 */
  const input = require('fs').readFileSync('./dev/stdin/31997.txt').toString().trim().split('\n');
  const [N, M, T] = input[0].split(' ').map(Number);
  const io = input.slice(1, N + 1).map((line) => line.split(' ').map(Number));
  const acc = Array.from(new Array(T + 1), () => 0);

  /* 메인 로직 */
  for (let i = N + 1; i < N + M + 1; i++) {
    const [a, b] = input[i].split(' ').map((val) => +val - 1);
    if (io[a][0] >= io[b][1] || io[a][1] <= io[b][0]) continue;
    acc[Math.max(io[a][0], io[b][0])]++;
    acc[Math.min(io[a][1], io[b][1])]--;
  }

  for (let i = 1; i < T; i++) {
    acc[i] += acc[i - 1];
  }
  acc.pop();

  /* 정답 반환 */
  return acc.join('\n');
};

console.log(solution());

