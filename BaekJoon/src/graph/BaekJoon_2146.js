/**
 * BaekJoon_2146, 다리 만들기
 *  - 문제 분류: 그래프 탐색, 너비 우선 탐색
 */
const solution = () => {
  /* 변수 관리 */
  const input = require('fs').readFileSync('./dev/stdin/2146.txt').toString().trim().split('\n');
  const N = +input[0];
  const map = input.slice(1).map((line) => line.split(' ').map(Number));
  const v = Array.from({ length: N }, () => Array.from({ length: N }, () => false));
  const drc = [
    [1, 0],
    [-1, 0],
    [0, 1],
    [0, -1],
  ];
  let answer = Infinity;

  /* 메인 로직 */
  let count = 1;
  const island = [];
  for (let i = 0; i < N; i++) {
    for (let j = 0; j < N; j++) {
      if (map[i][j] === 0 || v[i][j]) continue;
      island.push([]);
      grouping(i, j, count++);
    }
  }
  let depth = 1;
  while (true) {
    for (let i = 0; i < island.length; i++) {
      const flag = bfs(i);
      if (flag === i) continue;
      answer = Math.min(answer, i < flag ? depth + depth - 2 : depth + depth - 1);
    }
    if (answer !== Infinity) break;
    depth++;
  }

  /* 정답 반환 */
  return answer;

  // grouping
  function grouping(r, c, number) {
    if (v[r][c]) return;

    v[r][c] = true;
    map[r][c] = number;
    island[number - 1].push([r, c]);

    for (const [dr, dc] of drc) {
      const [nr, nc] = [r + dr, c + dc];
      if (nr < 0 || nc < 0 || nr >= N || nc >= N || v[nr][nc] || map[nr][nc] === 0) continue;
      grouping(nr, nc, number);
    }
  }

  // bfs
  function bfs(number) {
    let len = island[number].length;
    for (let i = 0; i < len; i++) {
      const [r, c] = island[number].shift();
      for (const [dr, dc] of drc) {
        const [nr, nc] = [r + dr, c + dc];
        if (nr < 0 || nc < 0 || nr >= N || nc >= N || map[nr][nc] === number + 1) continue;
        if (map[nr][nc] > 0 && map[nr][nc] !== number + 1) return map[nr][nc] - 1;
        map[nr][nc] = number + 1;
        island[number].push([nr, nc]);
      }
    }
    return number;
  }
};

console.log(solution());

