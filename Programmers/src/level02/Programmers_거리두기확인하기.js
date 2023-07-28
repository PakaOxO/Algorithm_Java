/**
 * Programmers_거리두기 확인하기
 *    1. 문제 분류 : 그래프 탐색
 *    2. 접근 방법
 *      - 응시자(P)에서 다른 응시자까지 최단거리를 구하는 문제
 *        - 책상(O)은 이동할 수 있는 길
 *        - 파티션(X)은 이동할 수 없는 길
 */
const solution = (places) => {
  /* 변수 초기화 */
  const answer = [];
  const [N, INF] = [places.length, 100];
  const drc = [
    [0, 1],
    [0, -1],
    [1, 0],
    [-1, 0],
  ];
  let map = null;

  /* 메인 로직 */
  for (let i = 0; i < N; i++) {
    map = places[i].map((item) => item);
    let flag = false;
    loop: for (let j = 0; j < N; j++) {
      for (let k = 0; k < N; k++) {
        if (map[j][k] !== "P") continue;
        const dist = bfs(j, k);
        if (dist <= 2) {
          flag = true;
          break loop;
        }
      }
    }
    answer.push(flag ? 0 : 1);
  }

  return answer;

  /* 메서드 */
  function bfs(i, j) {
    const queue = [[i, j, 0]];
    const v = Array.from({ length: N }, () =>
      Array.from({ length: N }, () => false)
    );
    v[i][j] = true;

    while (queue.length > 0) {
      const curr = queue.shift();
      for (let i = 0; i < drc.length; i++) {
        const [nr, nc] = [curr[0] + drc[i][0], curr[1] + drc[i][1]];
        if (
          nr < 0 ||
          nc < 0 ||
          nr >= N ||
          nc >= N ||
          v[nr][nc] ||
          map[nr][nc] === "X"
        )
          continue;

        if (map[nr][nc] === "P") return curr[2] + 1;
        v[nr][nc] = true;
        queue.push([nr, nc, curr[2] + 1]);
      }
    }
    return INF;
  }
};

console.log(
  solution([
    ["POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"],
    ["POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"],
    ["PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"],
    ["OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"],
    ["PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"],
  ])
);
