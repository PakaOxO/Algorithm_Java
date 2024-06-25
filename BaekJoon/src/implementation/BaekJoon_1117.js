/**
 * BaekJoon_1117, 색칠 1
 *  - 문제 분류: 구현, 수학
 */
const solution = () => {
  /* 변수 관리 */
  const [W, H, f, c, x1, y1, x2, y2] = require('fs')
    .readFileSync('./dev/stdin/1117.txt')
    .toString()
    .trim()
    .split(' ')
    .map(BigInt);
  let xboundary = 0;
  let ystack = 0;
  let answer = W * H;

  /* 메인 로직 */
  xboundary = f <= W / BigInt(2) ? f : W - f;
  ystack = c + BigInt(1);

  if (xboundary <= x1) {
    answer -= (y2 - y1) * ystack * (x2 - x1);
  } else if (xboundary > x1 && xboundary <= x2) {
    answer -= (y2 - y1) * ystack * (xboundary - x1) * BigInt(2);
    answer -= (y2 - y1) * ystack * (x2 - xboundary);
  } else {
    answer -= (y2 - y1) * ystack * (x2 - x1) * BigInt(2);
  }

  /* 정답 반환 */
  return answer.toString();
};

console.log(solution());

