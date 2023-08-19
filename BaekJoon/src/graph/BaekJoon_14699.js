/**
 * BaekJoon_14699, 관악산 등산
 *    1. 문제 분류 : 그래프 탐색, dp
 *    2. 접근 방법
 *      - 각 시작점 별로 그래프 탐색을 실시해서 dp의 결과가 최소가 되는 값을 반환
 *      - 시작점에서 시작한 dfs에서 다음 depth(새로운 시작점)로 넘어갔을 때
 *        -> 새로운 시작지점에 대한 dp값을 가지고 리턴해야함
 *        -> 가령 1 -> 4 -> 5 로 이동하는 경로에서
 *            -> 5이후로 더 이동할 곳이 없으면 dp[5] = 1
 *            -> 4이후로 이동할 곳이 5밖에 없으면 dp[4] = dp[5] + 1
 *            -> ...이런 식으로 다음 이동할 곳의 dp를 참조해서 나중에 3 -> 4 -> 5라는 경로를 탐색할 때 4이후로 dfs를 굳이 돌리지 않게 체크해야 함
 *            -> 이 경우에 dp[3] = dp[4] + 1이므로 탐색 없이 dp[4] = 3이라는 값을 얻을 수 있음
 */
const solution = () => {
  /* 변수 초기화 */
  const input = require("fs").readFileSync("./dev/stdin/14699.txt").toString().split("\n");
  const [N, M] = input[0].split(" ").map((item) => +item);
  const heights = input[1].split(" ").map((item) => +item);
  const connection = Array.from({ length: N }, () => []);
  let dp = Array.from({ length: N }, () => 0);

  for (let i = 2; i < 2 + M; i++) {
    const [from, to] = input[i].split(" ").map((item) => +item - 1);
    if (heights[from] < heights[to]) {
      connection[from].push(to);
    } else {
      connection[to].push(from);
    }
  }

  /* 메인 로직 */
  for (let i = 0; i < N; i++) {
    dfs(i);
  }

  return dp.join("\n");

  /* dfs */
  function dfs(pos, depth) {
    if (dp[pos] > 0) return 0;
    let dist = 1;
    let max = 0;

    for (let i = 0; i < connection[pos].length; i++) {
      const next = connection[pos][i];
      if (dp[next] > 0) {
        max = Math.max(max, dp[next]);
      } else {
        max = Math.max(max, dfs(next, depth));
      }
    }
    dp[pos] = dist + max;

    return dist + max;
  }
};

console.log(solution());
