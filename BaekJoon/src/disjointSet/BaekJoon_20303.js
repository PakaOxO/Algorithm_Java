/**
 * BaekJoon_20303, 할로윈의 양아치
 *  - 문제 분류: 분리 집합, 배낭 문제
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/20303.txt").toString().trim().split("\n");
  const [N, M, K] = input[0].split(" ").map(Number);
  const candies = input[1].split(" ").map(Number);
  const parent = Array.from({ length: N + 1 }, (_, idx) => idx);
  const map = new Map();

  /* 메인 로직 */
  for (let i = 2; i <= M + 1; i++) {
    const [x, y] = input[i].split(" ");
    union(+x, +y);
  }

  for (let i = 1; i <= N; i++) {
    const info = map.get(getParent(i));

    if (!info) {
      map.set(parent[i], [1, candies[i - 1]]);
    } else {
      map.set(parent[i], [info[0] + 1, info[1] + candies[i - 1]]);
    }
  }
  const arr = new Array(...map.values());

  /* 정답 반환 */
  return knapsack(arr);

  // getParent
  function getParent(x) {
    if (parent[x] === x) return x;
    parent[x] = getParent(parent[x]);
    return parent[x];
  }

  // union
  function union(x, y) {
    const [px, py] = [getParent(x), getParent(y)];

    if (px <= py) parent[py] = px;
    else parent[px] = py;
  }

  // knapsack
  function knapsack(arr) {
    const dp = [Array.from({ length: K }, () => 0)];
    for (let i = 1; i <= arr.length; i++) {
      const [cost, profit] = arr[i - 1];
      dp.push([0]);

      for (let j = 1; j < K; j++) {
        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        if (j >= cost) {
          dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - cost] + profit);
        }
      }
    }

    return dp[arr.length][K - 1];
  }
};

console.log(solution());
