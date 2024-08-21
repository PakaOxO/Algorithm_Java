/**
 * BaekJoon_1326, 폴짝폴짝
 *  - 문제 분류: bfs
 */
const solution = () => {
  /* 변수 관리 */
  const input = require('fs').readFileSync('./dev/stdin/1326.txt').toString().trim().split('\n');
  const N = +input[0];
  const arr = input[1].split(' ').map(Number);
  const [a, b] = input[2].split(' ').map(Number);
  const INF = Number.MAX_SAFE_INTEGER;
  const dist = Array.from(new Array(N), () => INF);

  /* 메인 로직 */
  dist[a - 1] = 0;
  let q = [a - 1];
  let pointer = 0;

  loop: while (pointer < q.length) {
    const curr = q[pointer++];
    const d = arr[curr];

    let [l, r] = [curr - d, curr + d];
    while (l >= 0) {
      if (dist[l] > dist[curr] + 1) {
        dist[l] = dist[curr] + 1;
        if (l === b - 1) break loop;
        q.push(l);
      }
      l -= d;
    }

    while (r < N) {
      if (dist[r] > dist[curr] + 1) {
        dist[r] = dist[curr] + 1;
        if (r === b - 1) break loop;
        q.push(r);
      }
      r += d;
    }
  }

  /* 정답 반환 */
  return dist[b - 1] === INF ? -1 : dist[b - 1];
};

console.log(solution());

