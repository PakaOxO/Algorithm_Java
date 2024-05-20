/**
 * BaekJoon_26152, 플래피 버드 스코어링
 *  - 문제 분류: 이분탐색
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/26152.txt").toString().trim().split("\n");
  const N = +input[0];
  const Ai = input[1].split(" ").map(Number);
  const Bi = input[2].split(" ").map(Number);
  const Q = +input[3];
  const wi = input[4].split(" ").map(Number);
  const min = [];
  const answer = [];

  /* 메인 로직 */
  let temp = Number.MAX_VALUE;
  for (let i = 0; i < N; i++) {
    const diff = Ai[i] - Bi[i];
    if (diff < temp) temp = diff;
    min.push(temp);
  }

  // 이분 탐색
  for (let i = 0; i < Q; i++) {
    const w = wi[i];
    let [left, right] = [0, N - 1];
    while (left <= right) {
      const mid = Math.floor((left + right) / 2);
      if (min[mid] >= w) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    answer.push(left);
  }

  /* 정답 반환 */
  return answer.join("\n");
};

console.log(solution());

