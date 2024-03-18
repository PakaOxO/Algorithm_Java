/**
 * BaekJoon_14427, 수열과 쿼리 15
 *  - 문제 분류: 우선 순위 큐, 자료 구조, 구현
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/14427.txt").toString().trim().split("\n");
  const N = +input[0];
  const arr = input[1].split(" ").map(Number);
  const M = +input[2];
  const nodes = [];
  const answer = [];

  /* 메인 로직 */
  const heap = getMinHeap();

  for (let i = 0; i < N; i++) {
    nodes.push(node(i, arr[i]));
    heap.offer(nodes[i]);
  }

  for (let i = 3; i < M + 3; i++) {
    const [op, idx, val] = input[i].split(" ").map(Number);
    if (op === 2) {
      answer.push(heap.poll().index + 1);
    } else {
      heap.edit(idx - 1, val);
    }
  }

  /* 정답 반환 */
  return answer.join("\n");

  // node
  function node(idx, val) {
    const index = idx;
    let pos = idx;
    let value = val;
    return { index, pos, value };
  }

  // heap
  function getMinHeap() {
    const arr = [null];

    function size() {
      return arr.length - 1;
    }

    function getArr() {
      return arr;
    }

    function swap(i, j) {
      const temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;

      arr[i].pos = i;
      arr[j].pos = j;
    }

    function offer(node) {
      arr.push(node);

      let pointer = size();
      arr[size()].pos = pointer;
      while (true) {
        const parent = Math.floor(pointer / 2);
        if (parent === 0) break;
        if (arr[parent].value < arr[pointer].value) break;
        if (arr[parent].value === arr[pointer].value && arr[parent].index < arr[pointer].index) break;
        swap(parent, pointer);
        pointer = parent;
      }
    }

    function poll() {
      return arr[1];
    }

    function edit(idx, val) {
      nodes[idx].value = val;

      let pointer = nodes[idx].pos;
      let [left, right] = [pointer * 2, pointer * 2 + 1];
      let next = null;
      while (left <= size()) {
        if (right <= size()) {
          next = arr[left].value < arr[right].value ? left : right;
          if (arr[left].value === arr[right].value) {
            next = arr[left].index < arr[right].index ? left : right;
          }
        } else {
          next = left;
        }

        if (arr[pointer].value < arr[next].value) break;
        if (arr[pointer].value === arr[next].value && arr[pointer].index < arr[next].pointer) break;

        swap(pointer, next);
        pointer = next;
        [left, right] = [pointer * 2, pointer * 2 + 1];
      }

      while (true) {
        const parent = Math.floor(pointer / 2);
        if (parent === 0) break;
        if (arr[parent].value < arr[pointer].value) break;
        if (arr[parent].value === arr[pointer].value && arr[parent].index < arr[pointer].index) break;
        swap(parent, pointer);
        pointer = parent;
      }
    }

    return { getArr, size, swap, offer, poll, edit };
  }
};

console.log(solution());

