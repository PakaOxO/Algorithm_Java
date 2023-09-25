/**
 * Programmers_부대 복귀
 *  - 문제 분류 : 그래프 탐색
 */
const solution = (n, roads, sources, destination) => {
  /* 변수 초기화 */
  const INF = Number.MAX_SAFE_INTEGER;
  const answer = Array.from({ length: sources.length }, () => INF);
  const adjList = Array.from({ length: n + 1 }, () => []);
  const dist = Array.from({ length: n + 1 }, () => INF);

  for (const [s, e] of roads) {
    adjList[s].push(e);
    adjList[e].push(s);
  }

  /* 메인 로직 */
  bfs(destination);
  for (let i = 0; i < sources.length; i++) {
    answer[i] = dist[sources[i]] === INF ? -1 : dist[sources[i]];
  }

  /* 정답 반환 */
  return answer;

  /**
   * destination에서 다른 모든 정점으로 가는 최단 거리
   */
  function bfs(e) {
    const q = [e];
    dist[e] = 0;

    while (q.length > 0) {
      const curr = q.shift();
      for (const next of adjList[curr]) {
        if (dist[next] <= dist[curr] + 1) continue;
        dist[next] = dist[curr] + 1;
        q.push(next);
      }
    }
  }
};

console.log(
  solution(
    3,
    [
      [1, 2],
      [2, 3],
    ],
    [2, 3],
    1
  )
);
console.log(
  solution(
    5,
    [
      [1, 2],
      [1, 4],
      [2, 4],
      [2, 5],
      [4, 5],
    ],
    [1, 3, 5],
    5
  )
);
