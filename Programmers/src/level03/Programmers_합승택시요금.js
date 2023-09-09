/**
 * Programmers_합승 택시 요금
 *    - 문제 분류 : 그래프 탐색, 최단거리 알고리즘
 */
const solution = (n, s, a, b, fares) => {
  /* 변수 초기화 */
  const INF = Number.MAX_SAFE_INTEGER;
  let answer = INF;
  const dist = Array.from({ length: n + 1 }, (_, i) =>
    Array.from({ length: n + 1 }, (_, j) => {
      if (i === j) return 0;
      return INF;
    })
  );

  for (const [s, e, fare] of fares) {
    dist[s][e] = fare;
    dist[e][s] = fare;
  }

  floydWarshall();
  for (let i = 1; i <= n; i++) {
    answer = Math.min(answer, dist[s][i] + dist[i][a] + dist[i][b]);
  }

  /* 정답 반환 */
  return answer;

  /**
   * 플로이드-워셜 알고리즘
   */
  function floydWarshall() {
    for (let k = 1; k <= n; k++) {
      for (let i = 1; i <= n; i++) {
        if (dist[i][k] === INF) continue;
        for (let j = 1; j <= n; j++) {
          if (dist[k][j] === INF) continue;
          if (dist[i][j] <= dist[i][k] + dist[k][j]) continue;
          dist[i][j] = dist[i][k] + dist[k][j];
        }
      }
    }
  }
};

console.log(
  solution(6, 4, 6, 2, [
    [4, 1, 10],
    [3, 5, 24],
    [5, 6, 2],
    [3, 1, 41],
    [5, 1, 24],
    [4, 6, 50],
    [2, 4, 66],
    [2, 3, 22],
    [1, 6, 25],
  ])
);
console.log(
  solution(7, 3, 4, 1, [
    [5, 7, 9],
    [4, 6, 4],
    [3, 6, 1],
    [3, 2, 3],
    [2, 1, 6],
  ])
);
console.log(
  solution(6, 4, 5, 6, [
    [2, 6, 6],
    [6, 3, 7],
    [4, 6, 7],
    [6, 5, 11],
    [2, 5, 12],
    [5, 3, 20],
    [2, 4, 8],
    [4, 3, 9],
  ])
);
