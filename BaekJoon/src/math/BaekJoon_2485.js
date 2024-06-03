/**
 * BaekJoon_2485, 가로수
 *  - 문제 분류: 수학, 그리디
 */
const solution = () => {
  /* 변수 관리 */
  const input = require('fs').readFileSync('./dev/stdin/2485.txt').toString().trim().split('\n');
  const N = +input[0];
  const diff = [];

  /* 메인 로직 */
  let prev = +input[1];
  for (let i = 2; i <= N; i++) {
    const tree = +input[i];
    diff.push(tree - prev);
    prev = tree;
  }

  const gcd = diff.length === 0 ? 0 : diff.reduce((gcd, num) => getGCD(gcd, num), 0);
  let answer = 0;
  diff.forEach((diff) => (answer += diff / gcd - 1));

  /* 정답 반환 */
  return answer;

  // gcd
  function getGCD(a, b) {
    if (b === 0) return a;
    if (b > a) return getGCD(b, a);
    if (a % b === 0) return b;
    return getGCD(b, a - b);
  }
};

console.log(solution());

