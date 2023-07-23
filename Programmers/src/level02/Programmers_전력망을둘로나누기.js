/**
 * Programmers_전력망을 둘로 나누기
 *  1. 문제 분류 : 그래프 탐색, 트리, 완전 탐색
 *  2. 접근 방법
 *    - wire 입력 정보를 받아 연결 정보를 저장 (연결 정보는 배열이나 리스트를 사용)
 *    - 각 wire를 순회하며 해당 wire를 끊었을 때, 양측 시작 송전탑 기준으로 연결된 송전탑의 개수를 카운트(그래프 탐색)
 *    - 송전탑 개수 차이가 가장 작은 값을 정답으로 반환
 *    -> 다른 사람 풀이에 비해 실행 시간이 길게 나옴(각 연결 정보에 대해 각각 탐색을 실행해서 그런듯)
 *    -> 다른 사람 풀이를 참고하여 코드 수정
 *    -> IDEA: 현재 노드 기준 자식 노드들 개수의 합을 가지고 있다면,
 *      -> 자기 자신을 포함한 자식 노드 묶음과 자신 상위 노드들의 묶음으로 분리했을 때, n - (자식 노드의 개수) * 2가 두 노드 묶음 개수의 차이
 *      -> 그래프이므로 순회는 발생하지 않음.
 *      -> 임의의 정점에 대해 bfs 탐색을 실시해 다음 노드를 찾고, 해당 다음 노드는 부모로 현재 노드를 가짐
 *      -> bfs 탐색을 하면서 탐색한 정점을 배열에 담음(dfs도 ok) -> 늦게 담긴 정점일 수록 리프노드에 가까움
 *      -> 배열을 역순으로 순회하면 리프노드부터 노드의 개수 누적 합을 구할 수 있음!!
 */
const solution = (n, wires) => {
  /* 변수 초기화 */
  let answer = n;
  const graph = drawGraph(n, wires);
  const p = Array.from({ length: n + 1 }, () => -1);
  const v = Array.from({ length: n + 1 }, () => false);
  const counts = Array.from({ length: n + 1 }, () => 1);
  const childs = [];

  /* 메인 로직 */
  bfs(1);
  // console.log(childs);
  for (let i = childs.length - 1; i > 0; i--) {
    const curr = childs[i];
    counts[p[curr]] += counts[curr];
    answer = Math.min(answer, Math.abs(n - counts[curr] * 2));
  }

  return answer;

  /* 메서드 */
  function drawGraph(n, info) {
    const connectionInfo = Array.from({ length: n + 1 }, () => []);
    for (const [from, to] of info) {
      connectionInfo[from].push(to);
      connectionInfo[to].push(from);
    }
    return connectionInfo;
  }

  function bfs(s) {
    const q = [s];
    v[s] = true;

    while (q.length > 0) {
      const curr = q.shift();
      childs.push(curr);
      for (const n of graph[curr]) {
        if (v[n]) continue;
        v[n] = true;
        p[n] = curr;
        q.push(n);
      }
    }
  }
};

console.log(
  solution(9, [
    [1, 3],
    [2, 3],
    [3, 4],
    [4, 5],
    [4, 6],
    [4, 7],
    [7, 8],
    [7, 9],
  ])
);
console.log(
  solution(4, [
    [1, 2],
    [2, 3],
    [3, 4],
  ])
);
console.log(
  solution(7, [
    [1, 2],
    [2, 7],
    [3, 7],
    [3, 4],
    [4, 5],
    [6, 7],
  ])
);
