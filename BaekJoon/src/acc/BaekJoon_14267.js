/**
 * BaekJoon_14267, 회사 문화 1
 *  - 문제 분류: 연결 리스트, 트리, 누적 합
 */
const solution = () => {
  class Node {
    constructor(id) {
      this.id = id;
      this.parentId = -1;
      this.childs = [];
      this.acc = 0;
    }
  }

  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/14267.txt").toString().trim().split("\n");
  const [N, M] = input[0].split(" ").map(Number);
  const parents = input[1].split(" ");
  const nodes = new Array(N + 1).fill(null);
  const answer = [];

  /* 메인 로직 */
  // 부모와 자식 노드 매핑 -> 10만
  for (let i = 0; i < N; i++) {
    const parent = +parents[i];

    if (nodes[i + 1] === null) {
      nodes[i + 1] = new Node(i + 1);
    }

    nodes[i + 1].parentId = parent;
    if (parent > 0) {
      nodes[parent].childs.push(i + 1);
    }
  }

  // 칭찬 -> 10만
  for (let i = 2; i < M + 2; i++) {
    const [id, weight] = input[i].split(" ");
    nodes[+id].acc += +weight;
  }

  // 부모부터 자식 노드 방문 -> 10만
  dfs(1);

  // answer 도출 -> 10만
  for (let i = 1; i <= N; i++) {
    answer.push(nodes[i].acc);
  }

  /* 정답 반환 */
  return answer.join(" ");

  // dfs
  function dfs(idx) {
    const stack = [idx];

    while (stack.length > 0) {
      const currIdx = stack.pop();
      for (const child of nodes[currIdx].childs) {
        nodes[child].acc += nodes[currIdx].acc;
        stack.push(child);
      }
    }
  }
};

console.log(solution());

