/**
 * BaekJoon_1927, 최소 힙
 *  - 문제 분류: 우선 순위 큐
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/1927.txt").toString().trim().split("\n");
  const N = +input[0];
  const answer = [];

  /* 메인 로직 */
  const heap = getMinHeap();

  for (let i = 1; i <= N; i++) {
    const op = +input[i];
    if (op === 0) {
      answer.push(heap.poll());
    } else {
      heap.offer(op);
    }
  }

  /* 정답 반환 */
  return answer.join("\n");

  // 우선 순위 큐
  function getMinHeap() {
    const arr = [null];

    function size() {
      return arr.length - 1;
    }

    function offer(num) {
      arr.push(num);

      let pointer = size();
      while (true) {
        const parent = Math.floor(pointer / 2);
        if (parent === 0) break;
        if (arr[parent] <= arr[pointer]) break;

        swap(parent, pointer);
        pointer = parent;
      }
    }

    function poll() {
      if (size() === 0) return 0;
      swap(size(), 1);
      const result = arr.pop();

      let pointer = 1;
      let [left, right] = [pointer * 2, pointer * 2 + 1];
      let next = null;
      while (left <= size()) {
        if (right <= size()) {
          next = arr[left] <= arr[right] ? left : right;
        } else {
          next = left;
        }

        if (arr[pointer] <= arr[next]) break;
        swap(pointer, next);
        pointer = next;
        [left, right] = [pointer * 2, pointer * 2 + 1];
      }

      return result;
    }

    function swap(i, j) {
      const temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
    }

    return { size, offer, poll };
  }
};

console.log(solution());

