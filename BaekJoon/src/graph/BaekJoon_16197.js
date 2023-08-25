/**
 * BaekJoon_16197, 두 동전
    1. 문제 분류 : 그래프 탐색, 구현
    2. 접근 방법
      - 4방 탐색으로 그래프 탐색을 하되 움직이는 물체가 동전 2개
      - 움직인 후 동전의 상태를 표시하자, 0은 벽으로 인해 움직이지 못함, 1은 움직임, 2는 떨어짐
        -> 만약 둘다 움직이지 못했다면 해당 방향으로 이동할 필요 없으므로 return
        -> 둘다 떨어졌다면 미션 실패므로 return
        -> 하나만 움직였다면 해당 이동거리로 answer 초기화(이동거리가 10보다 크다면 return)
        -> 이미 정답이 나왔는데 추가로 이동하면 낭비므로 answer보다 큰 이동거리로 들어오면 return
 */
const solution = () => {
  /* 변수 초기화 */
  const input = require("fs").readFileSync("./dev/stdin/16197.txt").toString().trim().split("\n");
  const [N, M] = input[0].split(" ").map((item) => +item);
  const coins = [null, null];
  const board = Array.from({ length: N }, () => Array.from({ length: M }, () => null));
  const v = Array.from({ length: N }, () =>
    Array.from({ length: M }, () => Array.from({ length: N }, () => Array.from({ length: M }, () => 11)))
  );
  const drc = [
    [0, 1],
    [0, -1],
    [1, 0],
    [-1, 0],
  ];
  let answer = 11;

  /* 메인 로직 */
  for (let i = 0; i < N; i++) {
    const line = input[i + 1].split("");
    for (let j = 0; j < M; j++) {
      if (line[j] === "o") {
        board[i][j] = ".";
        coins[0] === null ? (coins[0] = [i, j]) : (coins[1] = [i, j]);
      } else {
        board[i][j] = line[j];
      }
    }
  }
  dfs(coins[0], coins[1], 0, 0, 0);

  return answer > 10 ? -1 : answer;

  /* 동전 이동 dfs */
  function dfs(p1, p2, s1, s2, dist) {
    // s는 동전의 state(0 : 움직이지 않음, 1 : 움직임, 2 : 떨어짐)
    if ((dist > 0 && s1 + s2 === 0) || (s1 === 2 && s2 === 2)) return;
    if (dist >= answer || dist > 10) return;
    if (s1 === 2 || s2 === 2) {
      answer = dist;
      return;
    }
    if (dist >= v[p1[0]][p1[1]][p2[0]][p2[1]]) return;
    v[p1[0]][p1[1]][p2[0]][p2[1]] = dist;

    for (let i = 0; i < drc.length; i++) {
      const n1 = [p1[0] + drc[i][0], p1[1] + drc[i][1]];
      const n2 = [p2[0] + drc[i][0], p2[1] + drc[i][1]];
      const f1 = n1[0] < 0 || n1[0] >= N || n1[1] < 0 || n1[1] >= M ? 2 : board[n1[0]][n1[1]] === "#" ? 0 : 1;
      const f2 = n2[0] < 0 || n2[0] >= N || n2[1] < 0 || n2[1] >= M ? 2 : board[n2[0]][n2[1]] === "#" ? 0 : 1;
      dfs(f1 === 0 ? p1 : n1, f2 === 0 ? p2 : n2, f1, f2, dist + 1);
    }
  }
};

console.log(solution());

