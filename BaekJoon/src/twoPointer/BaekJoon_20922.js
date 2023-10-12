/**
 * BaekJoon_20922, 겹치는 건 싫어
 *  - 문제 분류: 투 포인터
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/20922.txt").toString().split("\n");
  const [N, K] = input[0].split(" ").map((item) => +item);
  const arr = input[1].split(" ").map((item) => +item);
  const MAX = 100000;
  const count = Array.from({ length: MAX + 1 }, () => 0);
  let [left, right] = [0, 0];
  let answer = 0;

  /* 메인 로직 */
  while (right < N) {
    count[arr[right]]++;
    while (count[arr[right]] > K) {
      count[arr[left++]]--;
    }

    answer = Math.max(answer, right - left + 1);
    right++;
  }

  /* 정답 반환 */
  return answer;
};

console.log(solution());
