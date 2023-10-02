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

    getParent() {
      return this.parent;
    }

    setLeft(node) {
      this.left = node;
    }

    getLeft() {
      return this.left;
    }

    setRight(node) {
      this.right = node;
    }

    getRight() {
      return this.right;
    }
  }

  /* 변수 초기화 */
  const N = nodeInfo.length;

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

  /* 정답 반환 */

  /**
   * 루트 노드를 찾은 뒤 트리 생성
   */
  function findBinaryTree() {}

  /**
   * 전위 순회
   */
  function preOrder(node) {
    console.log(node.idx, node.getLeft(), node.getRight());
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
  function postOrder(node) {}
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

