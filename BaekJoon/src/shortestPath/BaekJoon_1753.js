/**
 * BaekJoon_1753, 최단경로
 *  - 문제 분류: 다익스트라, 자료구조, 힙
 */
const solution = () => {
  // heap
  function Heap() {
    const arr = [null];

    const offer = (edge) => {
      arr.push(edge);
      let pointer = arr.length - 1;
      while (true) {
        const parent = Math.floor(pointer / 2);
        if (parent === 0 || arr[parent][1] <= arr[pointer][1]) break;
        swap(parent, pointer);
        pointer = parent;
      }
    };

    const poll = () => {
      if (arr.length === 1) return null;
      swap(1, arr.length - 1);
      const result = arr.pop();

      let pointer = 1;
      while (true) {
        const [left, right] = [pointer * 2, pointer * 2 + 1];
        if (left >= arr.length) break;
        const next = right < arr.length && arr[right][1] < arr[left][1] ? right : left;
        if (arr[next][1] >= arr[pointer][1]) break;
        swap(next, pointer);
        pointer = next;
      }

      return result;
    };

    const size = () => {
      return arr.length - 1;
    };

    const swap = (i, j) => {
      const temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
    };

    return { offer, poll, size };
  }

  // dijkstra
  function dijkstra(s, dist) {
    const pq = new Heap();
    dist[s] = 0;
    pq.offer([s, 0]);

    while (pq.size() > 0) {
      const [curr, acc] = pq.poll();

      for (const [next, d] of adjList[curr]) {
        if (dist[next] <= acc + d) continue;
        dist[next] = acc + d;
        pq.offer([next, dist[next]]);
      }
    }
  }

  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/1753.txt").toString().trim().split("\n");
  const [V, E] = input[0].split(" ").map(Number);
  const K = +input[1] - 1;
  const INF = Number.MAX_SAFE_INTEGER;
  const adjList = Array.from({ length: V }, () => new Map());
  const dist = Array.from({ length: V }, () => INF);

  for (let i = 2; i < E + 2; i++) {
    let [u, v, w] = input[i].split(" ").map(Number);
    u--;
    v--;

    if (!adjList[u].has(v) || adjList[u].get(v) > w) {
      adjList[u].set(v, w);
    }
  }

  /* 메인 로직 */
  dijkstra(K, dist);

  /* 정답 반환 */
  return dist
    .map((d) => {
      if (d === INF) return "INF";
      return d;
    })
    .join("\n");
};

console.log(solution());

