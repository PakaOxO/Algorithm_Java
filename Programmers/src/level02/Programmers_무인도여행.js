/**
 * Programmers_무인도 여행
 *  1. 문제 분류 : 그래프 탐색
 *  2. 접근 방법
 *    - map을 탐색하며 무인도를 발견하면 bfs 탐색을 실시
 *    - bfs 탐색 과정에서 모든 식량의 합을 구한 뒤, arr에 합을 push
 *    - 탐색 과정에 방문한 곳은 방문처리
 *    - arr를 정렬, arr 길이가 0이면 [-1]를 답으로 반환
 */
const solution = (maps) => {
  /* 변수 선언부 */
  const answer = [];
  const [H, W] = [maps.length, maps[0].length];
  const drc = [
    [-1, 0],
    [1, 0],
    [0, 1],
    [0, -1],
  ];
  const isVisited = Array.from({ length: H }, () =>
    Array.from({ length: W }, () => false)
  );

  /* 메인 로직 */
  for (let i = 0; i < H; i++) {
    for (let j = 0; j < W; j++) {
      if (isVisited[i][j] || maps[i].charAt(j) === "X") continue;
      answer.push(bfs(i, j));
    }
  }

  answer.sort((a, b) => a - b);
  if (answer.length < 1) answer.push(-1);
  return answer;

  /* 메서드 */
  function bfs(r, c) {
    isVisited[r][c] = true;
    const q = [[r, c]];
    let sum = +maps[r].charAt(c);

    while (q.length > 0) {
      const curr = q.shift();
      for (let i = 0; i < drc.length; i++) {
        const [nr, nc] = [curr[0] + drc[i][0], curr[1] + drc[i][1]];
        if (
          nr < 0 ||
          nc < 0 ||
          nr >= H ||
          nc >= W ||
          isVisited[nr][nc] ||
          maps[nr].charAt(nc) === "X"
        )
          continue;
        isVisited[nr][nc] = true;
        sum += +maps[nr].charAt(nc);
        q.push([nr, nc]);
      }
    }
    return sum;
  }
};

console.log(solution(["X591X", "X1X5X", "X231X", "1XXX1"]));
console.log(solution(["XXX", "XXX", "XXX"]));
