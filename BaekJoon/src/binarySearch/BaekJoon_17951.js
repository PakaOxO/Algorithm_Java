/**
 * BaekJoon_17951, 흩날리는 시험지 속에서 내 평점이 느껴진거야
 *    - 문제 분류 : 이분 탐색
 */
const solution = () => {
  /* 변수 초기화 */
  const input = require("fs").readFileSync("./dev/stdin/17951.txt").toString().trim().split("\n");
  const [N, K] = input[0].split(" ").map((item) => +item);
  const arr = input[1].split(" ").map((item) => +item);
  const INF = 2000000;

  /* 정답 반환 */
  return binarySearch(0, INF);

  /**
   * 이분 탐색
   */
  function binarySearch(left, right) {
    while (left <= right) {
      const mid = Math.floor((left + right) / 2);
      const flag = check(mid);

      if (flag) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    return right;
  }

  /**
   * 목표 점수 합계(sum)가 주어졌을 때 나눠지는 구간의 개수가 K개 이상인지
   */
  function check(sum) {
    let s = 0;
    let count = 0;
    for (let i = 0; i < N; i++) {
      s += arr[i];
      if (s >= sum) {
        s = 0;
        count++;
      }
    }

    return count >= K;
  }
};

console.log(solution());
