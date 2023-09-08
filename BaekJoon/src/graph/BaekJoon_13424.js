/**
 * BaekJoon_13424, 비밀 모임
 *    - 문제 분류 : 최단거리 탐색, 그래프
 */
const solution = () => {
  /**
   * 간선 정보를 담은 클래스
   */
  class Edge {
    constructor(next, weight) {
      this.next = next;
      this.weight = weight;
    }
  }

  /**
   * 최소 힙
   */
  class Heap {
    constructor() {
      this.arr = [null];
      this.size = 0;
    }

    poll() {
      if (this.size < 1) return null;
      this.swap(1, this.size);
      const result = this.arr.pop();
      this.size--;

      let pointer = 1;
      while (true) {
        let [left, right] = [pointer * 2, pointer * 2 + 1];
        if (left > this.size) break;
        if (right <= this.size) {
          let next = null;
          if (this.arr[left][1] <= this.arr[right][1]) {
            next = left;
          } else {
            next = right;
          }

          if (this.arr[next][1] < this.arr[pointer][1]) {
            this.swap(next, pointer);
            pointer = next;
          } else {
            break;
          }
        } else {
          if (this.arr[left][1] < this.arr[pointer][1]) {
            this.swap(left, pointer);
            pointer = left;
          } else {
            break;
          }
        }
      }

      return result;
    }

    offer(nextNode) {
      this.arr.push(nextNode);
      this.size++;
      let pointer = this.size;
      let parent = Math.floor(pointer / 2);
      while (parent > 0 && this.arr[pointer][1] < this.arr[parent][1]) {
        this.swap(pointer, parent);
        pointer = parent;
        parent = Math.floor(pointer / 2);
      }
    }

    swap(i, j) {
      const [n, w] = [this.arr[i][0], this.arr[i][1]];
      this.arr[i] = [...this.arr[j]];
      this.arr[j] = [n, w];
    }

    getSize() {
      return this.size;
    }
  }

  /* 변수 초기화 */
  const input = require("fs").readFileSync("./dev/stdin/13424.txt").toString().trim().split("\n");
  let line = 0;
  const T = +input[line++];
  let [N, M] = [0, 0, 0];
  let adjList = null;
  let starts = null;
  let dist = null;
  let distTotal = null;
  const answer = [];
  const INF = Number.MAX_SAFE_INTEGER;

  for (let tc = 0; tc < T; tc++) {
    // 정점의 개수(N)와 간선의 개수(M) 초기화
    [N, M] = input[line++].split(" ").map((item) => +item);

    // 인접리스트 초기화
    adjList = Array.from({ length: N + 1 }, () => []);
    for (let i = 0; i < M; i++) {
      const [s, e, w] = input[line++].split(" ").map((item) => +item);
      adjList[s].push(new Edge(e, w));
      adjList[e].push(new Edge(s, w));
    }

    // 친구의 위치 초기화
    +input[line++];
    starts = input[line++].split(" ").map((item) => +item);

    getDist();

    // 최소 거리 합의 위치를 anwer에 추가
    let min = INF;
    let minPos = -1;
    for (let i = 1; i <= N; i++) {
      if (distTotal[i] < min) {
        min = distTotal[i];
        minPos = i;
      }
    }

    answer.push(minPos);
  }

  /* 정답 반환 */
  return answer.join("\n");

  /**
   * 모든 정점간 최단 거리를 구하기(bfs)
   */
  function getDist() {
    distTotal = Array.from({ length: N + 1 }, () => 0);
    for (const s of starts) {
      dijkstra(s);
    }
  }

  /**
   * 시작 정점(s)에서 다른 모든 정점까지의 최단거리
   */
  function dijkstra(s) {
    dist = Array.from({ length: N + 1 }, () => INF);
    dist[s] = 0;
    const pq = new Heap();
    pq.offer([s, 0]);

    while (pq.getSize() > 0) {
      const [pos, d] = pq.poll();
      for (const node of adjList[pos]) {
        if (dist[node.next] <= d + node.weight) continue;
        dist[node.next] = d + node.weight;
        pq.offer([node.next, dist[node.next]]);
      }
    }

    for (let i = 1; i <= N; i++) {
      distTotal[i] += dist[i];
    }
  }
};

console.log(solution());
