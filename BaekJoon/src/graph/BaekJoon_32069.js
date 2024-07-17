/**
 * BaekJoon_32069, 가로등
 *  - 문제 분류: 그래프 탐색, bfs
 */
const solution = () => {
  class Node {
    constructor(pos, brightness) {
      this.pos = pos;
      this.brightness = brightness;
      this.next = null;
    }
  }

  class Queue {
    constructor() {
      this._size = 0;
      this._head = null;
      this._tail = null;
    }

    get size() {
      return this._size;
    }

    add(node) {
      this._size++;
      if (this._size === 1) {
        this._head = node;
        this._tail = node;
        return;
      }

      this._tail.next = node;
      this._tail = node;
    }

    remove() {
      if (this._size === 0) return null;
      const result = this._head;
      this._head = this._head.next;
      this._size--;
      return result;
    }
  }

  /* 변수 관리 */
  const input = require('fs').readFileSync('./dev/stdin/32069.txt').toString().trim().split('\n');
  const [L, N, K] = input[0].split(' ').map(Number);
  const q = new Queue();
  const set = new Set();
  const answer = [];

  /* 메인 로직 */
  input[1].split(' ').map((pos) => {
    const p = BigInt(pos);
    q.add(new Node(p, 0));
    set.add(p);
  });

  while (q.size > 0) {
    const n = q.remove();
    const [curr, b] = [n.pos, n.brightness];
    const [left, right] = [curr - BigInt(1), curr + BigInt(1)];
    if (left >= 0 && !set.has(left)) {
      q.add(new Node(left, b + 1));
      set.add(left);
    }
    if (right <= L && !set.has(right)) {
      q.add(new Node(right, b + 1));
      set.add(right);
    }

    answer.push(b);
    if (answer.length === K) break;
  }

  /* 정답 반환 */
  return answer.join('\n');
};

console.log(solution());
