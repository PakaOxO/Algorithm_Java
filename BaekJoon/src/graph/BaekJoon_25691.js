/**
 * BaekJoon_25691, k개 트리 노드에서 사과를 최대로 수확하기
 *  - 문제 분류: 그래프 탐색
 *  - 시간 복잡도: N^2
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/25691.txt").toString().trim().split("\n");
  const [N, K] = input[0].split(" ").map(Number);
  const adjList = Array.from({ length: N }, () => []);
  const v = Array.from({ length: N }, () => new Set());
  let apple = null;
  let answer = 0;

  /* 메인 로직 */
  for (let i = 1; i < N; i++) {
    const [parent, child] = input[i].split(" ").map(Number);
    adjList[parent].push(child);
    adjList[child].push(parent);
  }
  apple = input[N].split(" ").map(Number);

  v[0].add(1);
  dfs(0, 1, apple[0], 1);

  /* 정답 반환 */
  return answer;

  // dfs
  function dfs(pos, depth, count, path) {
    v[pos].add(path);

    if (depth === K) {
      answer = Math.max(answer, count);
      return;
    }

    for (const next of adjList[pos]) {
      if ((path & (1 << next)) > 0) {
        if (v[next].has(path)) continue;
        dfs(next, depth, count, path);
      } else {
        const nextPath = path | (1 << next);
        if (v[next].has(nextPath)) continue;
        dfs(next, depth + 1, count + apple[next], nextPath);
      }
    }
  }
};

console.log(solution());
