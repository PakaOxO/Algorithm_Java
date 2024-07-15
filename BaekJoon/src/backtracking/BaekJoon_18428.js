/**
 * BaekJoon_18428, 감시 피하기
 *  - 문제 분류: 백트래킹, 완전 탐색
 *  - 최대 시간 복잡도
 *      - N(~6)
 *      - N^2(36)에서 최대 3개를 선택하는 경우의 수 = (36 * 35 * 24) / (3 * 2 * 1) = 210 * 24 = 5040
 *      - 경우의 수 탐색마다 T(~5)의 개수만큼 사방탐색 = 5 * 4 * 6 = 120
 *      - MAX_SIZE = 120 * 5040 = 10080 + 50400 = 60480
 */
const solution = () => {
  /* 변수 관리 */
  const input = require('fs').readFileSync('./dev/stdin/18428.txt').toString().trim().split('\n');
  const N = +input[0];
  const map = [];
  const xPos = [];
  const tPos = [];
  const drc = [
    [0, 1],
    [0, -1],
    [1, 0],
    [-1, 0],
  ];
  let answer = 'NO';

  for (let i = 1; i <= N; i++) {
    const line = input[i].split(' ');
    const arr = [];
    for (let j = 0; j < N; j++) {
      arr.push(line[j]);
      if (line[j] === 'X') xPos.push([i - 1, j]);
      if (line[j] === 'T') tPos.push([i - 1, j]);
    }
    map.push(arr);
  }

  /* 메인 로직 */
  dfs(0, 0);

  /* 정답 반환 */
  return answer;

  // dfs
  function dfs(start, depth) {
    if (answer === 'YES') return;
    if (depth > 0) {
      const flag = check(3 - depth);
      if (flag) answer = 'YES';
      if (depth === 3 || answer === 'YES') return;
    }

    for (let i = start; i < xPos.length; i++) {
      const [r, c] = xPos[i];
      map[r][c] = 'O';
      dfs(i + 1, depth + 1);
      map[r][c] = 'X';
    }
  }

  // check
  function check(res) {
    for (const [r, c] of tPos) {
      let count = 0;
      for (const [dr, dc] of drc) {
        let [nr, nc] = [r + dr, c + dc];
        while (!(nr < 0 || nc < 0 || nr >= N || nc >= N)) {
          if (map[nr][nc] === 'O') break;
          if (map[nr][nc] === 'S') {
            count++;
            if (count > res) return false;
            continue;
          }

          [nr, nc] = [nr + dr, nc + dc];
        }
      }
    }

    return true;
  }
};

console.log(solution());

