/*
  BaekJoon_21738, 얼음깨기 펭귄
    1. 문제 분류 : 그래프 이론, 트리
    2. 접근 방법
      - 처음 펭귄이 위치한 얼음은 최소 2개 이상 지지대 얼음과 연결
      - 따라서 연결 정보를 토대로 맨 처음 얼음을 부모 노드로 하는 트리를 생성
      - 루트 노트(펭귄 위치)에서 지지대 얼음을 만날 때까지 bfs 탐색을 하면서
        지지대 얼음까지 depth를 계산
      - 지지대 얼음이 2개 이상 있어야 펭귄이 빠지지 않으므로, 가장 먼저 만나는
        지지대 얼음 2개까지 이어지는 경로 얼음은 깨지 않음 -> N에서 깨지 않은 얼음 차감
*/
const solution = () => {
  /* 클래스 정의 */
  class Node {
    constructor(val) {
      this.val = val;
      this.depth = 0;
      this.next = [];
      this.visited = false;
      this.isBase = false;
    }

    connect(node) {
      this.next.push(node);
    }
  }

  /* 변수 초기화 */
  let [N, S, P] = [0, 0, 0];
  let nodes = null;

  /* 초기 입력 */
  const fs = require("fs");
  const input = fs.readFileSync("./dev/stdin/21738.txt").toString().split("\n");
  [N, S, P] = input[0].split(" ").map((item) => +item);
  nodes = new Array(N + 1);

  for (let i = 1; i < N; i++) {
    const [A, B] = input[i].split(" ").map((item) => +item);
    if (!nodes[A]) {
      createNode(A);
    }
    if (!nodes[B]) {
      createNode(B);
    }
    connectNode(A, B);
  }

  return bfs(nodes[P]);

  /* 내부 함수 */
  // 노드 생성 함수
  function createNode(num) {
    nodes[num] = new Node(num);
    if (num <= S) {
      nodes[num].isBase = true;
    }
  }

  // 노드 간 연결
  function connectNode(from, to) {
    nodes[from].connect(nodes[to]);
    nodes[to].connect(nodes[from]);
  }

  // 너비 우선 탐색
  function bfs(root) {
    root.visited = true;
    const queue = [root];

    let answer = N - 1;
    let baseCount = 0;

    while (queue.length > 0 && baseCount < 2) {
      const size = queue.length;
      for (let i = 0; i < size && baseCount < 2; i++) {
        const currNode = queue.shift();

        for (const nextNode of currNode.next) {
          if (baseCount >= 2) break;
          if (nextNode.visited) continue;
          nextNode.visited = true;
          nextNode.depth = currNode.depth + 1;

          if (nextNode.isBase) {
            baseCount++;
            answer -= nextNode.depth;
          } else {
            queue.push(nextNode);
          }
        }
      }
    }

    return answer;
  }
};

console.log(solution());
