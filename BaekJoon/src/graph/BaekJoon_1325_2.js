/**
 * BaekJoon_1325, 효율적인 해킹
 *  - 문제 분류: 그래프 탐색, Strongly Connected Component
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/1325.txt").toString().split("\n");
  const [N, M] = input[0].split(" ").map(Number);
  const adjList = Array.from({ length: N + 1 }, () => []);
  const count = new Array(N + 1).fill(0);
  let answer = [];

  /* 메인 로직 */
  for (let i = 1; i <= M; i++) {
    const [from, to] = input[i].split(" ");
    adjList[+to].push(+from);
  }

  let max = 0;
  for (let i = 1; i <= N; i++) {
    count[i] = bfs(i);
    if (count[i] > max) {
      max = count[i];
      answer = [i];
    } else if (count[i] === max) {
      answer.push(i);
    }
  }

  answer.sort((a, b) => a - b);

  // 정답 반환
  return answer.join(" ");

  // bfs
  function bfs(start) {
    const stack = [start];
    const visited = new Array(N + 1).fill(0);
    visited[start] = 1;
    let count = 0;
    while (stack.length) {
      const node = stack.pop();
      for (let v of adjList[node]) {
        if (visited[v]) continue;
        visited[v] = 1;
        stack.push(v);
        count++;
      }
    }
    return count;
  }
};

console.log(solution());

