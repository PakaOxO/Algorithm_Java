/**
 * BaekJoon_5430, AC
 *  - 문제 분류: 자료구조(덱), 문자열
 */
const solution = () => {
  // node
  const Node = (num) => {
    let before, next;
    const value = num;
    return { before, next, value };
  };

  // deque
  const Deque = () => {
    let head, tail;
    let reversed = false;
    let size = 0;

    const reverse = () => {
      const temp = head;
      head = tail;
      tail = temp;
      reversed = !reversed;
    };

    const getSize = () => size;

    const poll = () => {
      if (size === 0) return null;
      size--;
      const val = head.value;

      if (!reversed) {
        const next = head.next;
        if (next) {
          next.before = null;
          head = next;
        }
      } else {
        const before = head.before;
        if (before) {
          before.next = null;
          head = before;
        }
      }
      return val;
    };

    const add = (node) => {
      if (size === 0) {
        head = node;
      } else {
        if (!reversed) {
          tail.next = node;
          node.before = tail;
        } else {
          tail.before = node;
          node.next = tail;
        }
      }
      tail = node;
      size++;
    };

    const list = () => {
      const arr = [];
      if (size === 0) return [];

      let curr = head;
      for (let i = 0; i < size; i++) {
        arr.push(curr.value);
        curr = !reversed ? curr.next : curr.before;
      }
      return arr;
    };

    return { getSize, reverse, poll, add, list };
  };

  /* 변수 관리 */
  const input = require('fs').readFileSync('./dev/stdin/5430.txt').toString().trim().split('\n');
  const T = +input[0];
  let pointer = 1;
  const answer = [];

  /* 메인 로직 */
  for (let i = 0; i < T; i++) {
    const p = input[pointer++];
    const n = +input[pointer++];
    const deque = getDeque(input[pointer++], Deque());
    let flag = true;
    for (let j = 0; j < p.length; j++) {
      const c = p.charAt(j);
      if (c === 'R') {
        deque.reverse();
      } else if (c === 'D') {
        flag = deque.poll();
        if (!flag) break;
      }
    }

    answer.push(flag ? getStr(deque) : 'error');
  }

  /* 정답 반환 */
  return answer.join('\n');

  // str to arr
  function getDeque(str, deque) {
    const replaced = str.replace(/[\[|\]]/g, '');
    if (replaced.length === 0) return deque;

    replaced.split(',').forEach((item) => deque.add(Node(+item)));
    return deque;
  }

  // arr to str
  function getStr(deque) {
    const arr = deque.list();
    return `[${arr.join(',')}]`;
  }
};

console.log(solution());

