/**
 * BaekJoon_1477, 휴게소 세우기
 *  - 문제 분류: 이분 탐색
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/1477.txt").toString().trim().split("\n");
  const [N, M, L] = input[0].split(" ").map(Number);
  const pos = N > 0 ? input[1].split(" ").map(Number) : [];

  /* 메인 로직 */
  pos.sort((a, b) => a - b);

  // 이분 탐색
  let [left, right] = [1, L];
  while (left <= right) {
    const mid = Math.floor((left + right) / 2);
    if (check(mid)) {
      right = mid - 1;
    } else {
      left = mid + 1;
    }
  }

  /* 정답 반환 */
  return left;

  // check
  function check(len) {
    let count = M;
    let prev = 0;
    let pointer = 0;

    while (prev < L) {
      if (pointer < N) {
        if (pos[pointer] - prev > len) {
          prev += len;
          count--;
        } else {
          prev = prev >= pos[pointer] ? prev : pos[pointer];
          pointer++;
        }
      } else {
        if (prev + len >= L) break;
        prev += len;
        count--;
      }

      if (count < 0) break;
    }

    return count >= 0;
  }
};

console.log(solution());

