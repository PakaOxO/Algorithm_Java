/**
 * BaekJoon_15971, 두 로봇
 *  - 문제 분류: 최단거리, 다익스트라
 */
const solution = () => {
  // heap
  const Heap = () => {
    const arr = [null];

    const size = () => arr.length - 1;

    const offer = (edge) => {
      arr.push(edge);
      let pointer = arr.length - 1;
      while (pointer > 1) {
        const parent = Math.floor(pointer / 2);
        if (arr[pointer][1] >= arr[parent][1]) break;
        swap(pointer, parent);
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
        let next = right < arr.length - 1 && arr[right] < arr[left] ? right : left;
        if (arr[next] >= arr[pointer]) break;
        swap(pointer, next);
        pointer = next;
      }

      return result;
    };

    const swap = (i, j) => {
      const temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
    };

    return { offer, poll, size };
  };

  // 다익스트라
  const dijkstra = (s, e, list) => {
    const INF = Number.MAX_SAFE_INTEGER;
    const dist = Array.from({ length: N + 1 }, () => [INF, 0]);
    dist[s][0] = 0;
    const heap = Heap();
    heap.offer([s, 0, 0]);

    while (heap.size() > 0) {
      const [curr, acc] = heap.poll();
      for (const [next, d] of list[curr]) {
        if (dist[next][0] <= acc + d) continue;
        dist[next][0] = acc + d;
        dist[next][1] = Math.max(dist[curr][1], d);
        heap.offer([next, dist[next][0]]);
      }
    }

    return dist[e][0] - dist[e][1];
  };

  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/15971.txt").toString().trim().split("\n");
  const [N, A, B] = input[0].split(" ").map(Number);
  const adjList = Array.from({ length: N + 1 }, () => []);
  let answer = 0;

  for (let i = 1; i < N; i++) {
    const [a, b, d] = input[i].split(" ").map(Number);
    adjList[a].push([b, d]);
    adjList[b].push([a, d]);
  }

  /* 메인 로직 */
  answer = dijkstra(A, B, adjList);

  /* 정답 반환 */
  return answer;
};

console.log(solution());

