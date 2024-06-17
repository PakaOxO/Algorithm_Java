/**
 * BaekJoon_5427, 불
 *  - 문제 분류: 그래프 탐색
 */
const solution = () => {
  /* 변수 관리 */
  const input = require('fs').readFileSync('./dev/stdin/5427.txt').toString().trim().split('\n');
  const T = +input[0];
  let pointer = 1;
  const drc = [
    [0, 1],
    [0, -1],
    [1, 0],
    [-1, 0],
  ];
  let map, sangeun, fire, w, h;
  const answer = [];

  /* 메인 로직 */
  for (let tc = 0; tc < T; tc++) {
    [w, h] = input[pointer++].split(' ').map(Number);
    map = [];
    sangeun = [];
    fire = [];
    for (let i = 0; i < h; i++) {
      const line = input[pointer++];
      const arr = [];
      for (let j = 0; j < w; j++) {
        const c = line.charAt(j);
        if (c === '@') sangeun.push([i, j]);
        else if (c === '*') fire.push([i, j]);
        arr.push(c);
      }
      map.push(arr);
    }

    let count = 0;
    while (sangeun.length > 0) {
      count++;
      const f = move();
      if (f) break;
      if (sangeun.length === 0) {
        count = 0;
        break;
      }
      spread();
    }

    answer.push(count > 0 ? count : 'IMPOSSIBLE');
  }

  /* 정답 반환 */
  return answer.join('\n');

  function move() {
    const len = sangeun.length;
    for (let i = 0; i < len; i++) {
      const [r, c] = sangeun.shift();
      if (map[r][c] !== '@') continue;
      for (const [dr, dc] of drc) {
        const [nr, nc] = [r + dr, c + dc];
        if (nr < 0 || nc < 0 || nr >= h || nc >= w) return true;
        if (map[nr][nc] !== '.') continue;
        map[nr][nc] = '@';
        sangeun.push([nr, nc]);
      }
    }
    return false;
  }

  // spread
  function spread() {
    const len = fire.length;

    for (let i = 0; i < len; i++) {
      const [r, c] = fire.shift();
      for (const [dr, dc] of drc) {
        const [nr, nc] = [r + dr, c + dc];
        if (nr < 0 || nc < 0 || nr >= h || nc >= w) continue;
        if (map[nr][nc] === '*' || map[nr][nc] === '#') continue;
        map[nr][nc] = '*';
        fire.push([nr, nc]);
      }
    }
  }
};

console.log(solution());

