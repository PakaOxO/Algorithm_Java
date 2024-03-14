/**
 * BaekJoon_2805, 나무 자르기
 *  - 문제 분류: 다이나믹 프로그래밍, 정렬
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/2805.txt").toString().trim().split("\n");
  const [N, M] = input[0].split(" ").map(Number);
  const trees = input[1].split(" ").map(Number);

  /* 메인 로직 */
  trees.sort((a, b) => a - b);
  let [left, right] = [0, trees[N - 1]];
  while (left <= right) {
    const mid = Math.floor((left + right) / 2);
    let len = 0;
    for (let i = N - 1; i >= 0; i--) {
      if (trees[i] <= mid) break;
      len += trees[i] - mid;
      if (len >= M) break;
    }

    if (len >= M) {
      left = mid + 1;
    } else {
      right = mid - 1;
    }
  }

  /* 정답 반환 */
  return right;
};

console.log(solution());

