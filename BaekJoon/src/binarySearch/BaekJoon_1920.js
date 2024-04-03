/**
 * BaekJoon_1920, 수 찾기
 *  - 문제 분류: 이분 탐색
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/1920.txt").toString().trim().split("\n");
  const N = +input[0];
  const arr = input[1].split(" ").map(Number);
  const M = +input[2];
  const target = input[3].split(" ").map(Number);
  const answer = [];

  /* 메인 로직 */
  arr.sort((a, b) => a - b);
  for (let i = 0; i < M; i++) {
    const flag = find(target[i]);
    answer.push(flag ? 1 : 0);
  }

  /* 정답 반환 */
  return answer.join("\n");

  // 이분 탐색
  function find(t) {
    let [left, right] = [0, N];

    while (left <= right) {
      const mid = Math.floor((left + right) / 2);
      if (arr[mid] <= t) {
        if (arr[mid] === t) return true;
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    return false;
  }
};

console.log(solution());
