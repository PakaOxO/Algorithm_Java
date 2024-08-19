/**
 * BaekJoon_15900, 나무 탈출
 *  - 문제 분류: 그래프
 */
const solution = () => {
  /* 변수 관리 */
  const input = require('fs').readFileSync('./dev/stdin/15900.txt').toString().trim().split('\n');
  const N = +input[0];
  const adjList = Array.from(new Array(N + 1), () => []);
  const dist = Array.from(new Array(N + 1), () => Number.MAX_SAFE_INTEGER);
  let count = 0;

  /* 메인 로직 */
  for (let i = 1; i < N; i++) {
    const [a, b] = input[i].split(' ').map(Number);
    adjList[a].push(b);
    adjList[b].push(a);
  }

  dist[1] = 0;
  let pointer = 0;
  const arr = [1];

  while (pointer < arr.length) {
    const curr = arr[pointer];
    let c = 0;
    for (const next of adjList[curr]) {
      if (dist[next] <= dist[curr] + 1) continue;
      dist[next] = dist[curr] + 1;
      arr.push(next);
      c++;
    }

    pointer++;
    if (c < 1) count += dist[curr];
  }

  /* 정답 반환 */
  return count % 2 ? 'Yes' : 'No';
};

console.log(solution());

