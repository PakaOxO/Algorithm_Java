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
      if (size === 0) {
        front = n;
        end = n;
      } else {
        end.rear = n;
        end = n;
      }

      size++;
    };

    const poll = () => {
      if (size === 0) return null;
      const r = front;
      front = r.rear;
      size--;
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
    v.push(Array.from({ length: M }, () => K + 1));
  }

  /* 메인 로직 */
  v[0][0] = 0;
  answer = bfs();

  /* 정답 반환 */
  return answer;

  // bfs
  function bfs() {
    const q = Queue();
    q.offer(Node(0, 0, 1, 0));

    while (q.getSize() > 0) {
      const { r, c, d, k } = q.poll();
      if (r === N - 1 && c === M - 1) return d;

      for (const [dr, dc] of drc) {
        const [nr, nc] = [r + dr, c + dc];
        if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
        if (map[nr][nc]) {
          if (v[nr][nc] > k + 1) {
            v[nr][nc] = k + 1;
            q.offer(Node(nr, nc, d + 1, k + 1));
          }
        } else {
          if (v[nr][nc] > k) {
            v[nr][nc] = k;
            q.offer(Node(nr, nc, d + 1, k));
          }
        }
      }
    }

    return -1;
  }
};

console.log(solution());
