/**
 * Programmers_가장 큰 정사각형 찾기
 *  1. 문제 분류 : 누적 합
 *  2. 접근 방법
 *    - 누적 합을 구한 2차원 배열에 대해 순회를 해볼까
 *    - 누적 합을 구하면서 길이가 d인 정사각형을 탐색한다고 가정하면,
 *      -> acc[i][j] - acc[i - d][j] - acc[i][j - d] + acc[i - d][j - d]의 값이 d*d와 같은지 체크
 *        -> 같으면 1로 채워져 있고 아니면 중간에 0이 하나 이상 존재 함
 *      -> 정사각형을 찾았다면 최대 길이(max)를 d의 값으로 갱신
 */
const solution = (board) => {
  /* 변수 선언부 */
  let max = 0;
  const [N, M] = [board.length, board[0].length];
  const acc = Array.from({ length: N + 1 }, () =>
    Array.from({ length: M + 1 }, () => 0)
  );

  /* 메인 로직부 */
  for (let i = 1; i <= N; i++) {
    for (let j = 1; j <= M; j++) {
      acc[i][j] = board[i - 1][j - 1];
      acc[i][j] += acc[i - 1][j] + acc[i][j - 1] - acc[i - 1][j - 1];

      let min = Math.min(i, j);
      for (let d = max + 1; d <= min; d++) {
        const s = acc[i][j] - acc[i - d][j] - acc[i][j - d] + acc[i - d][j - d];
        if (s === d * d) max = d;
        else break;
      }
    }
  }

  return max * max;
};

console.log(
  solution([
    [0, 1, 1, 1],
    [1, 1, 1, 1],
    [1, 1, 1, 1],
    [0, 0, 1, 0],
  ])
);
console.log(
  solution([
    [0, 0, 1, 1],
    [1, 1, 1, 1],
  ])
);
console.log(solution([[0]]));
