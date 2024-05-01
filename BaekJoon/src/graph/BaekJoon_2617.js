/**
 * BaekJoon_2617, 구슬 찾기
 *  - 문제 분류: 그래프 탐색
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/2617.txt").toString().trim().split("\n");
  const [N, M] = input[0].split(" ").map(Number);
  const INF = Number.MAX_SAFE_INTEGER;
  const dist = Array.from({ length: N + 1 }, () => Array.from({ length: N + 1 }, () => INF));
  const dist2 = Array.from({ length: N + 1 }, () => Array.from({ length: N + 1 }, () => INF));
  const v = Array.from({ length: N + 1 }, () => false);
  const half = Math.floor(N / 2);
  let answer = 0;

  for (let i = 1; i <= M; i++) {
    const [a, b] = input[i].split(" ").map(Number);
    dist[a][b] = 1;
    dist2[b][a] = 1;
  }

  /* 메인 로직 */
  for (let j = 1; j <= N; j++) {
    for (let i = 1; i <= N; i++) {
      if (dist[i][j] === INF) continue;
      for (let k = 1; k <= N; k++) {
        if (dist[j][k] === INF) continue;
        if (dist[i][j] + dist[j][k] >= dist[i][k]) continue;
        dist[i][k] = dist[i][j] + dist[j][k];
      }
    }
  }

  for (let j = 1; j <= N; j++) {
    for (let i = 1; i <= N; i++) {
      if (dist2[i][j] === INF) continue;
      for (let k = 1; k <= N; k++) {
        if (dist2[j][k] === INF) continue;
        if (dist2[i][j] + dist2[j][k] >= dist2[i][k]) continue;
        dist2[i][k] = dist2[i][j] + dist2[j][k];
      }
    }
  }

  for (let i = 1; i <= N; i++) {
    let [t, b] = [0, 0];
    for (let j = 1; j <= N; j++) {
      if (dist[i][j] < INF) t++;
      if (dist2[i][j] < INF) b++;
    }

    if (t > half || b > half) answer++;
  }

  /* 정답 반환 */
  return answer;
};

console.log(solution());

