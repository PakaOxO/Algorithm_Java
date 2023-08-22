/**
 * Programmers_카드 짝 맞추기
 *    1. 문제 분류 : 구현, 그래프 탐색
 *    2. 접근 방법
 *      - 문제에 주어진 대로 구현
 *      - 현재 처음으로 뒤집을 수 있는 카드를 찾아 뒤집는다
 *      - 다음 뒤집은 카드와 같은 그림의 카드를 찾는다
 *      -> 이를 반복하되, 여러 가지 경우의 수를 찾아 dfs를 돌린다
 *        -> 돌린 결과 움직인 횟수가 최소가 되는 값을 answer에 할당
 */
const solution = (board, r, c) => {
  /* 변수 초기화 */
  const INF = Number.MAX_VALUE;
  let answer = INF;
  let v = Array.from({ length: 4 }, () => Array.from({ length: 4 }, () => false));
  const drc = [
    [0, 1],
    [0, -1],
    [1, 0],
    [-1, 0],
  ];

  /* 메인 로직 */
  dfs(r, c, 0);

  return answer;

  /* dfs */
  function dfs(r, c, dist) {
    const firstCards = findFirst(r, c);
    if (firstCards.length === 0) {
      answer = Math.min(answer, dist);
    }

    for (let i = 0; i < firstCards.length; i++) {
      const nextCard = findNext(firstCards[i][0], firstCards[i][1], firstCards[i][2]);

      // 백업
      const prevNum = board[firstCards[i][0]][firstCards[i][1]];
      const nextNum = board[nextCard[0]][nextCard[1]];
      board[firstCards[i][0]][firstCards[i][1]] = 0;
      board[nextCard[0]][nextCard[1]] = 0;

      dfs(nextCard[0], nextCard[1], dist + firstCards[i][3] + nextCard[3] + 2);

      board[firstCards[i][0]][firstCards[i][1]] = prevNum;
      board[nextCard[0]][nextCard[1]] = nextNum;
    }
  }

  /* 두 번째로 뒤집을 카드 찾기 */
  function findNext(r, c, target) {
    const q = [[r, c, target, 0]];
    let nextCard = null;
    v = Array.from({ length: 4 }, () => Array.from({ length: 4 }, () => INF));
    v[r][c] = 0;

    loop: while (q.length > 0) {
      const [cr, cc, _, dist] = q.shift();
      const next = move(cr, cc, dist);

      for (let i = 0; i < next.length; i++) {
        if (next[i][2] === target) {
          nextCard = next[i];
        } else {
          q.push(next[i]);
        }
        if (nextCard) break loop;
      }
    }

    return nextCard;
  }

  /* 처음 뒤집을 카드 찾기 */
  function findFirst(r, c) {
    if (board[r][c] !== 0) {
      return [[r, c, board[r][c], 0]]; // 위치, 카드 종류, 거리
    }

    const q = [[r, c, board[r][c], 0]];
    let nextCards = [];
    v = Array.from({ length: 4 }, () => Array.from({ length: 4 }, () => INF));
    v[r][c] = 0;

    loop: while (q.length > 0) {
      const [cr, cc, _, dist] = q.shift();
      const next = move(cr, cc, dist);
      for (let i = 0; i < next.length; i++) {
        if (next[i][2] !== 0) {
          nextCards.push(next[i]);
        } else {
          q.push(next[i]);
        }
        // if (nextCards.length > 0) break loop;
      }
    }

    return nextCards;
  }

  /* 다음 위치로 이동 */
  function move(r, c, d) {
    const next = [];

    loop: for (let i = 0; i < drc.length; i++) {
      /* 사방 탐색 */
      let [nr, nc] = [r + drc[i][0], c + drc[i][1]];
      if (nr < 0 || nc < 0 || nr > 3 || nc > 3 || v[nr][nc] < d + 1) continue;
      if (v[nr][nc] > d + 1) {
        next.push([nr, nc, board[nr][nc], d + 1]);
        v[nr][nc] = d + 1;
      }
      if (board[nr][nc] !== 0) continue; // 컨트롤 사방 탐색 할필요 없음

      /* 컨트롤 사방 탐색 */
      while (true) {
        if (nr + drc[i][0] < 0 || nc + drc[i][1] < 0 || nr + drc[i][0] > 3 || nc + drc[i][1] > 3) {
          if (v[nr][nc] > d + 1) {
            next.push([nr, nc, board[nr][nc], d + 1]);
            v[nr][nc] = d + 1;
          }
          break;
        }

        [nr, nc] = [nr + drc[i][0], nc + drc[i][1]];

        if (board[nr][nc] !== 0) {
          if (v[nr][nc] > d + 1) {
            v[nr][nc] = d + 1;
            next.push([nr, nc, board[nr][nc], d + 1]);
          }
          break;
        }
      }
    }

    return next;
  }
};

console.log(
  solution(
    [
      [1, 0, 0, 3],
      [2, 0, 0, 0],
      [0, 0, 0, 2],
      [3, 0, 1, 0],
    ],
    1,
    0
  )
);
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
console.log(
  solution(
    [
      [1, 0, 0, 0],
      [0, 0, 0, 0],
      [0, 0, 0, 0],
      [0, 0, 1, 0],
    ],
    0,
    0
  )
);
