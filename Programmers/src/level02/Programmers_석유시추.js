/**
 * Programmers_석유시추, PCCP 문제 2번
 *  - 문제 분류: 완전 탐색, 너비 우선 탐색
 */
const solution = (land) => {
  /* 변수 관리 */
  const [n, m] = [land.length, land[0].length];
  const drc = [[0, 1], [1, 0], [0, -1], [-1, 0]]; // 사방탐색
  const dp = Array.from({ length: m }, () => 0);

  /* 메인 로직 */
  // 땅의 너비: m(~500), 땅의 깊이: n(~500)
  // 모든 땅의 위치(500) 탐색 * dfs -> 최대 250000
  for (let i=0; i<m; i++) {
    for (let j=0; j<n; j++) {
      if (land[j][i] === 0) continue;
      bfs(j, i);
    }
  }

  /* 정답 반환 */
  return Math.max(...dp);

  // dfs
  function bfs(r, c) {
    const set = new Set();
    const q = [[r, c]];
    land[r][c] = 0;
    let count = 0;
    
    while (q.length > 0) {
      const [cr, cc] = q.shift();
      set.add(cc);
      count++;

      for (let i=0; i<drc.length; i++) {
        const [nr, nc] = [cr + drc[i][0], cc + drc[i][1]];
        if (nr < 0 || nc < 0 || nr >= n || nc >= m || land[nr][nc] === 0) continue;
        land[nr][nc] = 0;
        q.push([nr, nc]);
      }
    }

    for (const pos of set) {
      dp[pos] += count;
    }
  }
}

console.log(solution([[0, 0, 0, 1, 1, 1, 0, 0], [0, 0, 0, 0, 1, 1, 0, 0], [1, 1, 0, 0, 0, 1, 1, 0], [1, 1, 1, 0, 0, 0, 0, 0], [1, 1, 1, 0, 0, 0, 1, 1]]));