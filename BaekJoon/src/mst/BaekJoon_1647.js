/**
 * BaekJoon_1647, 도시 분할 계획
 *  - 문제 분류: 최소 스패닝 트리, 크루스칼 알고리즘
 */
const solution = () => {
  // union-find
  const find = (i, parent) => {
    if (parent[i] === i) return i;
    return (parent[i] = find(parent[i], parent));
  };

  const union = (i, j, parent) => {
    const [pi, pj] = [find(i, parent), find(j, parent)];
    if (pi === pj) return;

    if (pi < pj) {
      parent[pj] = pi;
    } else {
      parent[pi] = pj;
    }
  };

  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/1647.txt").toString().trim().split("\n");
  const [N, M] = input[0].split(" ").map(Number);
  const edges = [];
  const parent = Array.from({ length: N + 1 }, (_, idx) => idx);
  let count = 0;
  let max = 0;
  let answer = 0;

  for (let i = 1; i <= M; i++) {
    const [from, to, cost] = input[i].split(" ").map(Number);
    edges.push([from, to, cost]);
  }

  /* 메인 로직 */
  edges.sort((a, b) => a[2] - b[2]);

  for (let i = 0; i < M && count < N - 1; i++) {
    const [from, to, cost] = edges[i];
    const [pf, pt] = [find(from, parent), find(to, parent)];
    if (pf === pt) continue;

    union(from, to, parent);
    count++;
    answer += cost;
    max = Math.max(max, cost);
  }

  /* 정답 반환 */
  return answer - max;
};

console.log(solution());

