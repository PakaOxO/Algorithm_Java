/**
 * Programmers_파괴되지 않은 건물
 *  - 문제 분류 : 누적합
 */
const solution = (board, skill) => {
  /* 변수 초기화 */
  let answer = 0;
  const [N, M] = [board.length, board[0].length];
  const acc = Array.from({ length: N }, () => Array.from({ length: M }, () => 0));

  /* 메인 로직 */
  for (let i = 0; i < skill.length; i++) {
    const [type, r1, c1, r2, c2, degree] = skill[i];
    const multiplier = type === 1 ? -1 : 1;

    acc[r1][c1] += degree * multiplier;
    if (c2 + 1 < M) acc[r1][c2 + 1] += -degree * multiplier;
    if (r2 + 1 < N) acc[r2 + 1][c1] += -degree * multiplier;
    if (r2 + 1 < N && c2 + 1 < M) acc[r2 + 1][c2 + 1] += degree * multiplier;
  }

  for (let i = 0; i < N; i++) {
    for (let j = 1; j < M; j++) {
      acc[i][j] += acc[i][j - 1];
    }
  }

  for (let i = 0; i < N; i++) {
    for (let j = 0; j < M; j++) {
      if (i > 0) acc[i][j] += acc[i - 1][j];
      if (board[i][j] + acc[i][j] > 0) answer++;
    }
  }

  /* 정답 반환 */
  return answer;
};

console.log(
  solution(
    [
      [5, 5, 5, 5, 5],
      [5, 5, 5, 5, 5],
      [5, 5, 5, 5, 5],
      [5, 5, 5, 5, 5],
    ],
    [
      [1, 0, 0, 3, 4, 4],
      [1, 2, 0, 2, 3, 2],
      [2, 1, 0, 3, 1, 2],
      [1, 0, 1, 3, 3, 1],
    ]
  )
);
console.log(
  solution(
    [
      [1, 2, 3],
      [4, 5, 6],
      [7, 8, 9],
    ],
    [
      [1, 1, 1, 2, 2, 4],
      [1, 0, 0, 1, 1, 2],
      [2, 2, 0, 2, 0, 100],
    ]
  )
);
