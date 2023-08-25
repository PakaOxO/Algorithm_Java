/**
 * Programmers_가장 먼 노드
 *    1. 문제 분류 : 그래프 탐색, 최단거리 알고리즘
 *    2. 접근 방법
 *      - bfs 탐색하면서 방문한 정점까지의 거리를 dist에 기록
 *      - 이전에 방문했던 거리가 지금 방문 시 거리보다 짧으면 재 방문 X
 */
const solution = (n, vertex) => {
  /* 변수 초기화 */
  const INF = 123456789;
  const dist = Array.from({ length: n }, () => INF);
  let [max, answer] = [0, 0];
  const adjNodes = Array.from({ length: n }, () => []);
  for (let i = 0; i < vertex.length; i++) {
    const [a, b] = vertex[i].map((item) => item - 1);
    adjNodes[a].push(b);
    adjNodes[b].push(a);
  }

  /* 메인 로직 */
  bfs(0);

  /* 정답 반환 */
  return answer;

  /* bfs */
  function bfs(start) {
    const queue = [[start, 0]];
    dist[start] = 0;

    while (queue.length > 0) {
      const [curr, d] = queue.shift();
      for (let next of adjNodes[curr]) {
        if (dist[next] <= d + 1) continue;
        dist[next] = d + 1;
        queue.push([next, d + 1]);

        if (d + 1 >= max) {
          if (d + 1 === max) {
            answer++;
          } else {
            answer = 1;
          }
          max = d + 1;
        }
      }
    }
  }
};

console.log(
  solution(6, [
    [3, 6],
    [4, 3],
    [3, 2],
    [1, 3],
    [1, 2],
    [2, 4],
    [5, 2],
  ])
);

