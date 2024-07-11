/**
 * BaekJoon_7785, 회사에 있는 사람
 *  - 문제 분류: 자료구조, 맵
 */
const solution = () => {
  /* 변수 관리 */
  const input = require('fs').readFileSync('./dev/stdin/7785.txt').toString().trim().split('\n');
  const N = +input[0];
  const map = new Map();
  const answer = [];

  /* 메인 로직 */
  for (let i = 1; i <= N; i++) {
    const [name, type] = input[i].split(' ');
    if (type === 'enter') {
      map.set(name, true);
    } else {
      map.set(name, false);
    }
  }

  for (const [key, val] of map) {
    if (!val) continue;
    answer.push(key);
  }

  answer.sort((a, b) => (a < b ? 1 : -1));

  /* 정답 반환 */
  return answer.join('\n');
};

console.log(solution());

