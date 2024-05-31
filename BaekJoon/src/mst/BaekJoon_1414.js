/**
 * BaekJoon_1414, 불우이웃돕기
 *  - 문제 분류: 최소스패닝트리
 */
const solution = () => {
  /* 변수 관리 */
  const input = require('fs').readFileSync('./dev/stdin/1414.txt').toString().trim().split('\n');
  const N = +input[0];
  const parent = Array.from({ length: N + 1 }, (_, idx) => idx);
  const edges = [];
  let answer = 0;

  for (let i = 1; i <= N; i++) {
    for (let j = 0; j < N; j++) {
      const dist = getDist(input[i].charAt(j));
      if (dist === 0) continue;
      answer += dist;
      if (i === j + 1) continue;
      edges.push([i, j + 1, dist]);
    }
  }

  /* 메인 로직 */
  edges.sort((a, b) => a[2] - b[2]);
  let count = 0;
  for (let i = 0; i < edges.length; i++) {
    const [x, y, dist] = edges[i];
    if (!union(x, y)) continue;
    answer -= dist;
    count++;
    if (count === N - 1) break;
  }
  if (count < N - 1) answer = -1;

  /* 정답 반환 */
  return answer;

  // getDist
  function getDist(char) {
    if (char === '0') return 0;
    if (char.charCodeAt(0) >= 'A'.charCodeAt(0) && char.charCodeAt(0) <= 'Z'.charCodeAt(0))
      return char.charCodeAt(0) - 'A'.charCodeAt(0) + 27;
    return char.charCodeAt(0) - 'a'.charCodeAt(0) + 1;
  }

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

