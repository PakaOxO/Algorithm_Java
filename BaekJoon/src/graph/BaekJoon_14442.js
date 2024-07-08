/**
 * BaekJoon_14442, 벽 부수고 이동하기 2
 *  - 문제 분류: 그래프 탐색
 */
const solution = () => {
  // Node
  const Node = (r, c, d, k) => {
    let rear = null;
    return { r, c, d, k, rear };
  };

  // Queue
  const Queue = () => {
    let front = null;
    let end = null;
    let size = 0;

    const offer = (n) => {
      if (front === null) {
        front = n;
        end = n;
      }

      end.rear = n;
      size++;
    };

    const poll = () => {
      if (size === 0) return null;
      const r = front;
      front = r.rear;
      size--;
      if (size === 0) rear = null;
      return r;
    };

    const getSize = () => size;

    return { getSize, front, end, offer, poll };
  };

  /* 변수 관리 */
  const drc = [
    [0, 1],
    [0, -1],
    [1, 0],
    [-1, 0],
  ];
  const INF = Number.MAX_SAFE_INTEGER;
  const input = require('fs').readFileSync('./dev/stdin/14442.txt').toString().trim().split('\n');
  const [N, M, K] = input[0].split(' ').map(Number);
  const map = [];
  const v = [];
  let answer = INF;

  for (let i = 1; i <= N; i++) {
    map.push(input[i].split('').map(Number));
    v.push(Array.from({ length: M }, () => Array.from({ length: K + 1 }, () => false)));
  }

  /* 메인 로직 */
  v[0][0].fill(true);
  bfs();

  /* 정답 반환 */
  answer = answer === INF ? -1 : answer;
  return answer;

  // bfs
  function bfs() {
    const q = Queue();
    q.offer(Node(0, 0, 1, K));

    while (q.getSize() > 0) {
      const { r, c, d, x } = q.poll();

      for (const [dr, dc] of drc) {
        const [nr, nc] = [r + dr, c + dc];
        if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
        if (v[nr][nc][x]) continue;
        if (map[nr][nc] && x === 0) continue;
        if (nr === N - 1 && nc === M - 1) {
          answer = d + 1;
          return;
        }

        const nx = map[nr][nc] ? x - 1 : x;
        v[nr][nc][nx] = true;
        q.offer(Node(nr, nc, d + 1, nx));
      }
    }
  }
};

console.log(solution());

