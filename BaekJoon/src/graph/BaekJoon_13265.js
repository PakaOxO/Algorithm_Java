/**
 * BaekJoon_13265, 색칠하기
 *  - 문제 분류: 그래프 탐색
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/13265.txt").toString().trim().split("\n");
  const T = +input[0];
  let tc = 0;
  let pointer = 1;
  const answer = [];

  /* 메인 로직 */
  while (tc < T) {
    const [N, M] = input[pointer++].split(" ").map(Number);
    const adjList = Array.from({ length: N + 1 }, () => []);
    // 10만
    for (let i = 0; i < M; i++) {
      const [x, y] = input[pointer++].split(" ").map(Number);
      adjList[x].push(y);
      adjList[y].push(x);
    }

    const flag = solve(N, adjList);
    answer.push(flag ? "possible" : "impossible");
    tc++;
  }

  /* 정답 반환 */
  return answer.join("\n");

  // solve
  function solve(n, list) {
    const v = Array.from({ length: n + 1 }, () => -1);
    const q = [];

    for (let i = 1; i <= n; i++) {
      if (v[i] >= 0) continue;

      q.push(i);
      v[i] = 1;

      while (q.length > 0) {
        const curr = q.shift();

        for (const next of list[curr]) {
          if (v[next] === v[curr]) return false;
          if (v[next] < 0) {
            v[next] = v[curr] ? 0 : 1;
            q.push(next);
          }
        }
      }
    }

    return true;
  }
};

console.log(solution());

