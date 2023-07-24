/**
 * Programmers_배달
 *  1. 문제 분류 : 최단 거리 탐색, 다익스트라
 *  2. 접근 방법
 *    - 모든 정점에 대한 탐색이 필요하므로 벨-포드?(이 이름이 맞나) 탐색을 해도 될 것 같음
 *    - 일단 다익스트라로 풀이
 */
const solution = (N, road, K) => {
  /* 변수 초기화 */
  let answer = 0;
  const INF = Number.MAX_VALUE;
  const d = Array.from({ length: N + 1 }, () => INF);
  const w = Array.from({ length: N + 1 }, () => []);

  /* 메인 로직 */
  road.forEach((r) => {
    const [from, to, weight] = r;
    w[from].push([to, weight]);
    w[to].push([from, weight]);
  });
  dijkstra(1);

  for (let i = 1; i <= N; i++) {
    if (d[i] <= K) answer++;
  }

  return answer;

  /* 메서드 */
  function dijkstra(s) {
    const q = [s];
    d[s] = 0;

    while (q.length > 0) {
      const curr = q.shift();
      for (const [to, weight] of w[curr]) {
        if (d[curr] + weight >= d[to]) continue;
        d[to] = d[curr] + weight;
        q.push(to);
      }
    }
  }
};

console.log(
  solution(
    5,
    [
      [1, 2, 1],
      [2, 3, 3],
      [5, 2, 2],
      [1, 4, 2],
      [5, 3, 1],
      [5, 4, 2],
    ],
    3
  )
);
