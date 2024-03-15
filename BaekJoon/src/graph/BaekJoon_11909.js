/**
 * BaekJoon_11909, 배열 탈출
 *  - 문제 분류: 그래프 탐색, 다이나믹 프로그래밍
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/11909.txt").toString().trim().split("\n");
  const N = +input[0];
  const map = input.slice(1).map((line) => line.split(" ").map(Number));
  const INF = Number.MAX_SAFE_INTEGER;
  const dp = Array.from({ length: N }, () => Array.from({ length: N }, () => INF));
  const pq = getPriorityQueue();
  let answer = 0;

  /* 메인 로직 */
  dp[0][0] = 0;
  pq.offer([0, 0, 0]);

  while (pq.size() > 0) {
    const [r, c, cost] = pq.poll();
    if (r === N - 1 && c === N - 1) {
      answer = cost;
      break;
    }

    if (r < N - 1 && c < N - 1) {
      next(r, c, r + 1, c, cost);
      next(r, c, r, c + 1, cost);
    } else if (r < N - 1) {
      next(r, c, r + 1, c, cost);
    } else if (c < N - 1) {
      next(r, c, r, c + 1, cost);
    }
  }

  /* 정답 반환 */
  return answer;

  // next
  function next(r, c, nr, nc, cost) {
    const diff = map[nr][nc] - map[r][c];
    if (diff >= 0) {
      if (dp[nr][nc] > dp[r][c] + diff + 1) {
        dp[nr][nc] = dp[r][c] + diff + 1;
        pq.offer([nr, nc, cost + diff + 1]);
      }
    } else {
      if (dp[nr][nc] > dp[r][c]) {
        dp[nr][nc] = dp[r][c];
        pq.offer([nr, nc, cost]);
      }
    }
  }

  // pq
  function getPriorityQueue() {
    const arr = [null];

    const size = () => {
      return arr.length - 1;
    };

    const offer = (node) => {
      arr.push(node);
      let pointer = size();
      while (true) {
        const parent = Math.floor(pointer / 2);
        if (parent === 0 || arr[parent][2] <= arr[pointer][2]) break;
        swap(pointer, parent);
        pointer = parent;
      }
    };

    const poll = () => {
      if (size() === 0) return null;
      swap(1, size());
      const result = arr.pop();
      let pointer = 1;
      let [left, right] = [pointer * 2, pointer * 2 + 1];

      while (left <= size()) {
        let next = left;
        if (right <= size() && arr[right][2] <= arr[left][2]) {
          next = right;
        }

        if (arr[pointer][2] <= arr[next][2]) break;
        swap(pointer, next);
        pointer = next;
        [left, right] = [pointer * 2, pointer * 2 + 1];
      }

      return result;
    };

    const swap = (i, j) => {
      const temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
    };

    const getList = () => {
      return arr;
    };

    return { size, offer, poll, getList };
  }
};

console.log(solution());

