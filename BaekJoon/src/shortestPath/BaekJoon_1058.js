/**
 * BaekJoon_1058, 친구
 *  - 문제 분류: 플로이드 워셜
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/1058.txt").toString().trim().split("\n");
  const N = +input[0];
  const INF = Number.MAX_SAFE_INTEGER;
  const dist = Array.from({ length: N }, () => Array.from({ length: N }, () => INF));
  const count = Array.from({ length: N }, () => 0);
  let answer = 0;

  /* 메인 로직 */
  for (let i = 1; i <= N; i++) {
    const line = input[i];
    dist[i - 1][i - 1] = 0;
    for (let j = 0; j < N; j++) {
      if (line.charAt(j) === "N") continue;
      dist[i - 1][j] = 1;
      count[i - 1]++;
    }
  }

  // 플로이드-워셜
  for (let j = 0; j < N; j++) {
    for (let i = 0; i < N; i++) {
      if (dist[i][j] === INF) continue;

      for (let k = 0; k < N; k++) {
        if (i === k || dist[j][k] === INF) continue;
        if (dist[i][j] + dist[j][k] >= dist[i][k]) continue;
        dist[i][k] = dist[i][j] + dist[j][k];
      }
    }
  }

  for (let i = 0; i < N; i++) {
    let count = 0;
    dist[i].forEach((d) => (d <= 2 && d > 0 ? count++ : null));
    answer = Math.max(answer, count);
  }

  /* 정답 반환 */
  return answer;
};

console.log(solution());

