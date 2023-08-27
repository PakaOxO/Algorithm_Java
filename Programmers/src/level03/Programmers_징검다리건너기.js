/**
 * Programmers_징검다리 건너기
 *    1. 문제 분류 : 구간 최대 값, 세그먼트트리
 *    2. 접근 방법
 *      -
 */
const solution = (stones, k) => {
  /* Deque 구현 */
  class Deque {
    constructor() {
      this.size = 0;
      this.head = null;
      this.tail = null;
    }

    removeHead() {
      if (this.size === 0) return null;
      this.size--;
      const result = this.head;
      if (result.rear) {
        this.head = result.rear;
        this.head.front = null;
      } else {
        this.head = null;
        this.tail = null;
      }

      return result.val;
    }

    removeTail() {
      if (this.size === 0) return null;
      this.size--;
      const result = this.tail;
      if (this.tail.front) {
        this.tail = this.tail.front;
        this.tail.rear = null;
      } else {
        this.head = null;
        this.tail = null;
      }
      result.front = null;
      return result.val;
    }

    addTail(val) {
      if (this.size === 0) {
        this.head = new Node(val);
        this.tail = new Node(val);
        this.size++;
        return;
      }

      const newTail = new Node(val);
      if (this.size === 1) {
        this.head.rear = newTail;
        newTail.front = this.head;
      } else {
        this.tail.rear = newTail;
        newTail.front = this.tail;
      }
      this.tail = newTail;
      this.size++;
    }

    peekHead() {
      if (this.size === 0) return null;
      return this.head.val;
    }

    peekTail() {
      if (this.size === 0) return null;
      return this.tail.val;
    }

    print() {
      let node = this.head;
      let result = [];
      while (node) {
        result.push(node.val);
        node = node.rear;
      }
      console.log(result);
    }
  }

  class Node {
    constructor(val) {
      this.val = val;
      this.front = null;
      this.rear = null;
    }
  }

  /* 변수 초기화 */
  const N = stones.length;
  let [left, right] = [0, -1];
  let answer = 2000000001;
  const deque = new Deque();

  /* 메인 로직 */
  while (right < N - 1) {
    if (right - left === k - 1) {
      if (deque.peekHead() === stones[left]) {
        deque.removeHead();
      }
      left++;
    }

    while (right - left < k - 1) {
      right++;
      while (deque.peekTail() && deque.peekTail() < stones[right]) {
        deque.removeTail();
      }
      deque.addTail(stones[right]);
    }

    answer = Math.min(answer, deque.peekHead());
  }

  return answer;
};

console.log(solution([2, 4, 5, 3, 2, 1, 4, 2, 5, 1], 3));
