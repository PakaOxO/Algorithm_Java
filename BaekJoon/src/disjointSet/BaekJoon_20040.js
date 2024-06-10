/**
 * BaekJoon_20040, 사이클 게임
 *  - 문제 분류: 분리 집합, union-find
 */
const solution = () => {
  /* 변수 관리 */
  const input = require('fs').readFileSync('./dev/stdin/20040.txt').toString().trim().split('\n');
  const [N, M] = input[0].split(' ').map(Number);
  const parent = Array.from({ length: N }, (_, idx) => idx);
  let answer = 0;

  /* 메인 로직 */
  for (let i = 1; i <= M; i++) {
    const [x, y] = input[i].split(' ').map(Number);
    const flag = union(x, y);
    if (!flag) {
      answer = i;
      break;
    }
  }

  /* 정답 반환 */
  return answer;

  // find
  function find(x) {
    if (parent[x] === x) return x;
    parent[x] = find(parent[x]);
    return parent[x];
  }

  // union
  function union(x, y) {
    const [px, py] = [find(x), find(y)];
    if (px === py) return false;

    if (px <= py) {
      parent[py] = px;
    } else {
      parent[px] = py;
    }

    return true;
  }
};

console.log(solution());

