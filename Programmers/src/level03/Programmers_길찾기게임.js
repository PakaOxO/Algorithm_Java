/**
 * Programmers_길 찾기 게임
 *  - 문제 분류: 그래프 탐색, 트리
 */
const solution = (nodeInfo) => {
  /**
   * node class
   */
  class Node {
    left;
    right;
    parent;

    constructor(idx, x, y) {
      this.idx = idx;
      this.x = x;
      this.y = y;
    }

    setParent(node) {
      this.parent = node;
    }

    setChild(node) {
      if (node.x < this.x) {
        if (this.left === undefined) {
          this.left = node;
        } else {
          this.left.setChild(node);
        }
      } else {
        if (this.right === undefined) {
          this.right = node;
        } else {
          this.right.setChild(node);
        }
      }
    }

    getParent() {
      return this.parent;
    }

    getLeft() {
      return this.left;
    }

    getRight() {
      return this.right;
    }
  }

  /* 변수 초기화 */
  const N = nodeInfo.length;
  const answer = [[], []];

  /* 메인 로직 */
  for (let i = 0; i < N; i++) {
    const [x, y, idx] = [nodeInfo[i][0], nodeInfo[i][1], i + 1];
    nodeInfo[i] = new Node(idx, x, y);
  }

  nodeInfo.sort((a, b) => {
    if (a.y === b.y) return b.x - a.x;
    return a.y - b.y;
  });

  root = nodeInfo[N - 1];
  for (let i = N - 2; i >= 0; i--) {
    root.setChild(nodeInfo[i]);
  }

  preOrder(root);
  postOrder(root);

  /* 정답 반환 */
  return answer;

  /**
   * 전위 순회
   */
  function preOrder(node) {
    answer[0].push(node.idx);

    if (node.getLeft() !== undefined) {
      preOrder(node.getLeft());
    }

    if (node.getRight() !== undefined) {
      preOrder(node.getRight());
    }
  }

  /**
   * 후위 순회
   */
  function postOrder(node) {
    if (node.getLeft() !== undefined) {
      postOrder(node.getLeft());
    }

    if (node.getRight() !== undefined) {
      postOrder(node.getRight());
    }

    answer[1].push(node.idx);
  }
};

console.log(
  solution([
    [5, 3],
    [11, 5],
    [13, 3],
    [3, 5],
    [6, 1],
    [1, 3],
    [8, 6],
    [7, 2],
    [2, 2],
  ])
);
