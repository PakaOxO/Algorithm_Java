/**
 * Programmers_여행 경로
 *    1. 문제 분류 : 그래프 탐색
 *    2. 접근 방법
 *      - 티켓으로 이동할 수 있는 경로를 담은 연결 그래프를 그림
 *      - 연결 그래프는 사전 순으로 정렬되어야 하므로 티켓의 도착지를 기준으로 사전순으로 먼저 정렬
 *      - 각 공항은 문자열이므로 Map 자료구조를 사용해 이동할 수 있는 다음 공항 리스트를 저장
 *      - 한 티켓을 여러 번 사용할 수는 없으므로 각 연결 정보에 해당하는 티켓의 번호(인덱스)를 같이 저장
 *      - ICN 공항에서 시작하는 dfs 돌림, 티켓 개수만큼 탐색이 되었으면 맨 처음 탐색의 종료 경로를 answer에 저장
 */
const solution = (tickets) => {
  /* 티켓 클래스 정의 */
  class Ticket {
    constructor(destination, idx) {
      this.destination = destination;
      this.idx = idx;
    }
  }

  /* 변수 초기화 */
  const graph = new Map();
  const E = tickets.length;
  let answer = null;
  const arr = ["ICN"];
  const v = Array.from({ length: E }, () => false);

  /* 메인 로직 */
  tickets.sort((a, b) => {
    return a[1] > b[1] ? 1 : -1;
  });

  for (let i = 0; i < E; i++) {
    const [from, to] = tickets[i];
    if (graph.has(from)) {
      graph.get(from).push(new Ticket(to, i));
    } else {
      graph.set(from, [new Ticket(to, i)]);
    }
  }

  dfs("ICN", 0);

  /* 정답 반환 */
  return answer;

  /* dfs */
  function dfs(airport, depth) {
    if (answer !== null) return;
    if (depth === E) {
      answer = [...arr];
      return;
    }

    if (graph.has(airport)) {
      for (const t of graph.get(airport)) {
        if (answer !== null) break;
        if (v[t.idx]) continue;
        v[t.idx] = true;
        arr.push(t.destination);
        dfs(t.destination, depth + 1);
        arr.pop();
        v[t.idx] = false;
      }
    }
  }
};

console.log(
  solution([
    ["ICN", "JFK"],
    ["HND", "IAD"],
    ["JFK", "HND"],
  ])
);
console.log(
  solution([
    ["ICN", "SFO"],
    ["ICN", "ATL"],
    ["SFO", "ATL"],
    ["ATL", "ICN"],
    ["ATL", "SFO"],
  ])
);
