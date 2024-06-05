/**
 * plaformName_probName
 *  - 문제 분류: type
 */
const solution = () => {
  /* 변수 관리 */
  const [N, M] = require('fs').readFileSync('./dev/stdin/12851.txt').toString().trim().split(' ').map(Number);

  /* 메인 로직 */
  if (M <= N) return `${N - M}\n1`;
  const q = Queue(N, M);

  while (true) {
    const curr = q.poll();
    if (curr === null) break;
    q.push(curr, curr * 2);
    q.push(curr, curr + 1);
    q.push(curr, curr - 1);
  }

  /* 정답 반환 */
  return `${q.getDist(M)}\n${q.getCount(M)}`;

  function Queue(n, m) {
    const INF = 100000;
    const dist = Array.from({ length: INF + 1 }, () => INF);
    const count = Array.from({ length: INF + 1 }, () => 0);

    let front = 0;
    const q = [n];
    dist[n] = 0;
    count[n] = 1;

    const getDist = (x) => {
      if (x < 0 || x >= dist.length) return null;
      return dist[x];
    };

    const getCount = (x) => {
      if (x < 0 || x >= count.length) return null;
      return count[x];
    };

    const push = (curr, next) => {
      if (next < 0 || next > INF) return;
      if (dist[next] < dist[curr] + 1) return;
      count[next]++;
      dist[next] = dist[curr] + 1;
      q.push(next);
    };

    const poll = () => {
      if (front >= q.length) return null;
      return q[front++];
    };

    return { getDist, getCount, push, poll };
  }
};

console.log(solution());

