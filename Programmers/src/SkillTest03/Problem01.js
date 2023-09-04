/**
 * Programmers_스킬 체크 테스트, 1문항 - 카드 짝 맞추기
 *    - 문제 분류 : 그래프 탐색, 구현
 */
const solution = (board, r, c) => {
  /* 변수 초기화 */
  let answer = Number.MAX_SAFE_INTEGER;
  let cardCounts = 0;
  const drc = [
    [0, 1],
    [0, -1],
    [1, 0],
    [-1, 0],
  ];
  const N = 4;
  let v = null;

  /* 메인 로직 */
  for (let i = 0; i < 4; i++) {
    for (let j = 0; j < 4; j++) {
      cardCounts = Math.max(cardCounts, board[i][j]);
    }
  }

  dfs(r, c, 0, 0);

  return answer;

  /* 카드 하나씩 제거 */
  /**
   * 현재 좌표(r, c)와 지금까지 이동거리(dist), 제거한 카드 개수(count)를 받아 제거할 카드 선정
   * @returns {Array<Number>}
   */
  function dfs(r, c, dist, count) {
    if (count === cardCounts) {
      answer = Math.min(answer, dist);
      return;
    }

    // 제일 가까운 첫 번째 카드들의 위치 및 거리를 찾는다.
    const firstCards = findFirstCards(r, c);
    for (const card of firstCards) {
      const [nr, nc, type, d] = card;
      board[nr][nc] = 0;
      // 찾은 첫번째 카드 각각에 대해 같은 카드의 위치와 이동거리를 찾는다.
      const [nr2, nc2, d2] = findSameCard(nr, nc, type);
      board[nr2][nc2] = 0;
      dfs(nr2, nc2, dist + d + d2 + 2, count + 1);
      board[nr][nc] = type;
      board[nr2][nc2] = type;
    }
  }

  /**
   * 위치 좌표(r, c)를 받아 bfs 탐색 후 가장 가까운 첫 번째 카드들 위치 반환
   * @returns {Array<Number>}
   */
  function findFirstCards(r, c) {
    v = Array.from({ length: N }, () => Array.from({ length: N }, () => false));
    v[r][c] = true;
    if (board[r][c] !== 0) return [[r, c, board[r][c], 0]];
    const queue = [[r, c, 0]];
    const cards = [];

    while (true) {
      const len = queue.length;
      if (len === 0) break;
      for (let i = 0; i < len; i++) {
        const [cc, cr, d] = queue.shift();
        const next = move(cc, cr, d);

        for (const [nr, nc, d2] of next) {
          if (board[nr][nc] !== 0) {
            cards.push([nr, nc, board[nr][nc], d2]);
          } else {
            queue.push([nr, nc, d2]);
          }
        }
      }

      if (cards.length > 0) return cards;
    }
    return [];
  }

  /**
   * 위치 좌표(r, c)와 찾을 카드 타입(type)을 받아 같은 type의 카드 위치와 최단 거리를 반환
   * @returns {Array<Number>}
   */
  function findSameCard(r, c, type) {
    v = Array.from({ length: N }, () => Array.from({ length: N }, () => false));
    const queue = [[r, c, 0]];
    v[r][c] = true;

    while (queue.length > 0) {
      const [cc, cr, d] = queue.shift();
      const next = move(cc, cr, d);
      for (const [nr, nc, d2] of next) {
        if (board[nr][nc] === type) {
          return [nr, nc, d2];
        }
        queue.push([nr, nc, d2]);
      }
    }
    return [r, c, 0];
  }

  /**
   * 현재 위치 좌표(r, c)와 지금까지 이동거리(d)를 받아 4방 탐색을 한 결과로 다음 이동할 수 있는 좌표들과 새로운 거리를 반환
   * @returns {Array<Number>}
   */
  function move(r, c, d) {
    const next = [];
    for (let i = 0; i < 4; i++) {
      let [nr, nc] = [r, c];
      let dist = 0;
      while (true) {
        dist++;
        [nr, nc] = [nr + drc[i][0], nc + drc[i][1]];
        if (nr < 0 || nc < 0 || nr >= N || nc >= N) {
          [nr, nc] = [nr - drc[i][0], nc - drc[i][1]];
          if (!(nr === r && nc === c) && !v[nr][nc]) {
            v[nr][nc] = true;
            next.push([nr, nc, d + 1]);
          }
          break;
        } else {
          if (board[nr][nc] !== 0) {
            if (!v[nr][nc]) {
              v[nr][nc] = true;
              next.push([nr, nc, d + 1]);
            }
            break;
          } else if (dist === 1) {
            if (!v[nr][nc]) {
              v[nr][nc] = true;
              next.push([nr, nc, d + 1]);
            }
          }
        }
      }
    }
    return next;
  }
};

// console.log(
//   solution(
//     [
//       [1, 0, 0, 3],
//       [2, 0, 0, 0],
//       [0, 0, 0, 2],
//       [3, 0, 1, 0],
//     ],
//     1,
//     0
//   )
// );
console.log(
  solution(
    [
      [3, 0, 0, 2],
      [0, 0, 1, 0],
      [0, 1, 0, 0],
      [2, 0, 0, 3],
    ],
    0,
    1
  )
);

