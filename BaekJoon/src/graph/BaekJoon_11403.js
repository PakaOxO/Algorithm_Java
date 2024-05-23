/**
 * BaekJoon_11403, 경로 찾기
 *  - 문제 분류: 그래프 탐색, 플로이드-워셜
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/11403.txt").toString().trim().split("\n");
  const N = +input[0];
  const INF = Number.MAX_VALUE;
  const dist = [];

  for (let i = 0; i < N; i++) {
    const line = input[i + 1].split(" ").map(Number);
    const arr = [];
    for (let j = 0; j < N; j++) {
      arr.push(line[j] === 0 ? INF : 1);
    }
    dist.push(arr);
  }

  /* 메인 로직 */
  for (let j = 0; j < N; j++) {
    for (let i = 0; i < N; i++) {
      if (dist[i][j] === INF) continue;
      for (let k = 0; k < N; k++) {
        if (dist[j][k] === INF) continue;
        if (dist[i][k] <= dist[i][j] + dist[j][k]) continue;
        dist[i][k] = dist[i][j] + dist[j][k];
      }
    }
  }

  /* 정답 반환 */
  return dist.map((line) => line.map((val) => (val === INF ? 0 : 1)).join(" ")).join("\n");
};

console.log(solution());

