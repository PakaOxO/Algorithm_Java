/**
 * BaekJoon_1504, 특정한 최단 경로
 *  - 문제 분류: 최단 경로 알고리즘, 다익스트라
 */
const solution = () => {
  /* 변수 관리 */
  const input = require('fs').readFileSync('./dev/stdin/1504.txt').toString().trim().split('\n');
  const [N, E] = input[0].split(' ').map(Number);
  const adjList = Array.from({ length: N + 1 }, () => []);
  const [A, B] = input[E + 1].split(' ').map(Number);
  const INF = Number.MAX_SAFE_INTEGER;

  for (let i = 1; i <= E; i++) {
    const [x, y, d] = input[i].split(' ').map(Number);
    adjList[x].push([y, d]);
    adjList[y].push([x, d]);
  }

  /* 메인 로직 */
  const distA = dijkstra(A);
  const distB = dijkstra(B);

  const answer = Math.min(distA[1] + distA[B] + distB[N], distB[1] + distB[A] + distA[N]);

  /* 정답 반환 */
  return answer >= INF ? -1 : answer;

  // 다익스트라
  function dijkstra(s) {
    const heap = Heap();
    const dist = Array.from({ length: N + 1 }, () => INF);
    heap.offer([s, 0]);
    dist[s] = 0;

    while (heap.size() > 0) {
      const [curr, acc] = heap.poll();
      if (acc > dist[curr]) continue;

      for (const [next, d] of adjList[curr]) {
        if (dist[next] > acc + d) {
          dist[next] = acc + d;
          heap.offer([next, dist[next]]);
        }
      }
    }

    return dist;
  }

  // 최소 힙
  function Heap() {
    const arr = [null];

    const size = () => {
      return arr.length - 1;
    };

    const swap = (i, j) => {
      const temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
    };

    const offer = (next) => {
      arr.push(next);
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
        const left = pointer * 2;
        const right = pointer * 2 + 1;
        let smallest = pointer;

        if (left < arr.length && arr[left][1] < arr[smallest][1]) {
          smallest = left;
        }

        if (right < arr.length && arr[right][1] < arr[smallest][1]) {
          smallest = right;
        }

        if (smallest === pointer) break;

        swap(pointer, smallest);
        pointer = smallest;
      }

      return result;
    };

    return {
      offer,
      poll,
      size,
    };
  }
};

console.log(solution());

