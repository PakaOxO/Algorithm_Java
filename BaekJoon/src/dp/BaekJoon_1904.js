/**
 * BaekJoon_1904, 01타일
 *  - 문제 분류: 다이나믹 프로그래밍
 */
const solution = () => {
  /* 변수 관리 */
  const N = +require('fs').readFileSync('./dev/stdin/1904.txt').toString().trim();
  const INF = 15746;

  /* 메인 로직 */
  let p0 = 0;
  let p1 = 1;
  let curr;

  for (let i = 0; i < N; i++) {
    curr = (p0 + p1) % INF;
    p0 = p1;
    p1 = curr;
  }

  /* 정답 반환 */
  return curr;
};

console.log(solution());

