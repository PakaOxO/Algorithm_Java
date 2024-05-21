/**
 * BaekJoon_11286, 절댓값 힙
 *  - 문제 분류: 자료구조, 힙
 */
const solution = () => {
  const heap = () => {
    const arr = [null];

    const offer = (num) => {
      arr.push(num);
      let pointer = arr.length - 1;
      let parent = Math.floor(pointer / 2);
      while (parent > 0) {
        const flag = compare(arr[pointer], arr[parent]);
        if (flag >= 0) break;
        swap(pointer, parent);
        pointer = parent;
        parent = Math.floor(pointer / 2);
      }
    };

    const poll = () => {
      if (arr.length === 1) return 0;
      swap(1, arr.length - 1);
      const result = arr.pop();

      let pointer = 1;
      while (true) {
        let [left, right] = [pointer * 2, pointer * 2 + 1];
        if (left >= arr.length) break;
        let next = right < arr.length && compare(arr[left], arr[right]) > 0 ? right : left;
        if (compare(arr[pointer], arr[next]) <= 0) break;
        swap(pointer, next);
        pointer = next;
      }

      return result;
    };

    const swap = (i, j) => {
      const temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
    };

    const compare = (x, y) => {
      const [absX, absY] = [Math.abs(x), Math.abs(y)];
      if (absX === absY) return x - y;
      return absX - absY;
    };

    return { offer, poll };
  };

  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/11286.txt").toString().trim().split("\n");
  const N = +input[0];
  const mh = heap();
  const answer = [];

  /* 메인 로직 */
  for (let i = 1; i <= N; i++) {
    const op = +input[i];

    if (op === 0) {
      answer.push(mh.poll());
    } else {
      mh.offer(op);
    }
  }

  /* 정답 반환 */
  return answer.join("\n");
};

console.log(solution());
