/**
 * BaekJoon_16564, 히오스 프로게이머
 *  - 문제 분류: 
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/16564.txt").toString().trim().split("\n");
  const [N, K] = input[0].split(" ").map(Number);
  const arr = input.slice(1);
  arr.sort((a, b) => a - b);
  let [left, right] = [1, arr[N - 1] + K];
  let answer = 0;

  /* 메인 로직 */
  arr.sort((a, b) => a - b);
  while (left <= right) {
    const mid = Math.floor((left + right) / 2);
    if (check(mid)) {
      left = mid + 1;
    } else {
      right = mid - 1;
    }
  }
  answer = right;

  /* 정답 반환 */
  return answer;

  // check
  function check(target) {
    let res = K;
    for (let i=0; i<N; i++) {
      if (+arr[i] >= target) return true;
      res -= (target - (+arr[i]));
      if (res < 0) return false;
    }

    return true;
  }
}

console.log(solution());