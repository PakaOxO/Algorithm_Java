/**
 * Programmers_혼자서 하는 틱택토
 *    1. 문제 분류 : 그래프 탐색
 *    2. 접근 방법
 *      - 나올 수 없는 상황
 *        -> 이미 선공이 이겼는데 X의 개수가 O의 개수 이상인 경우
 *        -> 이미 후공이 이겼는데 O의 개수가 X의 개수보다 많은 경우
 *        -> X의 개수가 O의 개수보다 많은 경우
 *        -> O의 개수가 X의 개수보다 2개 이상 많은 경우
 *        -> 둘다 이긴 경우
 */
const solution = (board) => {
  let answer = 1;
  let [oCount, xCount] = [0, 0];
  let [oWinCount, xWinCount] = [0, 0];
  const drc = [
    [0, 1],
    [1, 0],
    [1, 1],
    [1, -1],
  ];

  /* 메인 로직 */
  for (let i = 0; i < 3; i++) {
    for (let j = 0; j < 3; j++) {
      const type = board[i].charAt(j);
      if (type === ".") continue;
      if (type === "O") oCount++;
      else xCount++;

      if (i < 1 || j < 1) {
        for (let k = 0; k < drc.length; k++) {
          let [ni, nj, cnt] = [i, j, 0];
          while (ni < 3 && nj < 3 && nj >= 0 && board[ni].charAt(nj) === type) {
            cnt++;
            [ni, nj] = [ni + drc[k][0], nj + drc[k][1]];
          }
          if (cnt === 3) {
            if (type === "O") {
              oWinCount++;
            } else {
              xWinCount++;
            }
          }
        }
      }
    }
  }

  if (xCount > oCount || oCount - xCount > 1) {
    answer = 0;
  } else if (oWinCount > 0 && xCount >= oCount) {
    answer = 0;
  } else if (xWinCount > 0 && oCount > xCount) {
    answer = 0;
  } else if (oWinCount > 0 && xWinCount > 0) {
    answer = 0;
  }

  /* 정답 반환 */
  return answer;
};

console.log(solution(["O.X", ".O.", "..X"]));
console.log(solution(["OOO", "...", "XXX"]));
console.log(solution(["...", ".X.", "..."]));
console.log(solution(["...", "...", "..."]));
console.log(solution(["OX.", "OX.", "O.."]));
console.log(solution(["OOO", "XXO", "XXO"]));
console.log(solution(["OXO", "XOX", "OOX"]));
console.log(solution(["XXX", ".O.", "OOX"]));
console.log(solution(["OXO", ".O.", "OXX"]));
console.log(solution(["OOO", "XOX", "XOX"]));
console.log(solution([".OO", "XOX", "OXX"]));
// .OO
// XOX
// OX.
