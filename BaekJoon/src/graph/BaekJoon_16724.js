/**
 * BaekJoon_16724, 피리 부는 사나이
 *  - 문제 분류: 그래프 탐색, disjoint-set
 *  - 시간 복잡도: N^2 -> 100만
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/16724.txt").toString().trim().split("\n");
  const [N, M] = input[0].split(" ").map(Number);
  const map = [];
  const drc = {
    D: [1, 0],
    U: [-1, 0],
    L: [0, -1],
    R: [0, 1],
  };
  const parent = Array.from({ length: N * M }, (_, idx) => idx);
  const set = new Set();

  for (let i = 1; i <= N; i++) {
    map.push(input[i].split(""));
  }

  /* 메인 로직 */
  for (let i = 0; i < N; i++) {
    for (let j = 0; j < M; j++) {
      const dir = map[i][j];
      const [nr, nc] = [i + drc[dir][0], j + drc[dir][1]];
      union(i * M + j, nr * M + nc);
    }
  }

  for (let i = 0; i < N; i++) {
    for (let j = 0; j < M; j++) {
      find(i * M + j);
      set.add(find(i * M + j));
    }
  }

  /* 정답 반환 */
  return set.size;

  // find
  function find(x) {
    if (parent[x] === x) return x;
    parent[x] = find(parent[x]);
    return parent[x];
  }

  // union
  function union(x, y) {
    const [px, py] = [find(x), find(y)];
    if (px <= py) {
      parent[py] = px;
    } else {
      parent[px] = py;
    }
  }
};

console.log(solution());

