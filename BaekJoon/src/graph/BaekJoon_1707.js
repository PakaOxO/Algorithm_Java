/**
 * BaekJoon_1707, 이분 그래프
 *  - 문제 분류: 깊이 우선 탐색
 */
const solution = () => {
  /* 변수 관리 */
  const input = require('fs').readFileSync('./dev/stdin/1707.txt').toString().trim().split('\n');
  const T = +input[0];
  const answer = [];
  const stack = [];
  let pointer = 1;

  /* 메인 로직 */
  for (let tc = 1; tc <= T; tc++) {
    const [V, E] = input[pointer++].split(' ').map(Number);
    const adjList = Array.from(new Array(V + 1), () => []);
    for (let i = 0; i < E; i++) {
      const [s, e] = input[pointer++].split(' ').map(Number);
      adjList[s].push(e);
      adjList[e].push(s);
    }

    // dfs
    const v = Array.from(new Array(V + 1), () => 0);
    let flag = true;

    loop: for (let i = 1; i <= V; i++) {
      if (v[i]) continue;
      v[1] = 1;
      stack.push(i);
      while (stack.length > 0) {
        const curr = stack.pop();
        for (const next of adjList[curr]) {
          if (v[next]) {
            if (v[next] === v[curr]) {
              flag = false;
              break loop;
            }
            continue;
          }
          v[next] = v[curr] === 1 ? 2 : 1;
          stack.push(next);
        }
      }
    }

    answer.push(flag ? 'YES' : 'NO');
  }

  /* 정답 반환 */
  return answer.join('\n');
};

console.log(solution());

