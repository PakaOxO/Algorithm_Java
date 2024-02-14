/**
 * BaekJoon_24391, 귀찮은 해강이
 *  - 문제 분류: DisjointSet
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/24391.txt").toString().trim().split("\n");
  const [N, M] = input[0].split(" ").map(Number);
  const parent = Array.from({ length: N + 1 }, (_, idx) => idx);
  const arr = input[M + 1].split(" ").map(Number);
  let answer = 0;

  /* 메인 로직 */
  for (let i = 1; i <= M; i++) {
    const [x, y] = input[i].split(" ").map(Number);
    union(x, y);
  }

  for (let i = 1; i < N; i++) {
    if (getParent(arr[i]) === getParent(arr[i - 1])) continue;
    answer++;
  }

  /* 정답 반환 */
  return answer;

  // getParent
  function getParent(x) {
    if (parent[x] === x) return x;
    parent[x] = getParent(parent[x]);
    return parent[x];
  }

  // union
  function union(x, y) {
    const [px, py] = [getParent(x), getParent(y)];

    if (px <= py) {
      parent[py] = px;
    } else {
      parent[px] = py;
    }
  }
};

console.log(solution());

