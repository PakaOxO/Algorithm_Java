/**
 * BaekJoon_17179, 케이크 자르기
 *    - 문제 분류 : 이분 탐색
 */
const solution = () => {
  /* 변수 초기화 */
  const input = require("fs").readFileSync("./dev/stdin/17179.txt").toString().trim().split("\n");
  const [N, M, L] = input[0].split(" ").map((item) => +item);
  const arr = [0];
  const answer = [];

  for (let i = 1; i <= M; i++) {
    arr.push(+input[i]);
  }

  /* 메인 로직 */
  for (let i = M + 1; i <= M + N; i++) {
    const count = +input[i];
    binarySearch(0, L, count);
  }

  /* 정답 반환 */
  return answer.join("\n");

  /**
   * 좌우(left, right) 범위를 최대한 목표길이(target) 길이에 가깝게 자를 수 있는 지점 이분 탐색
   */
  function binarySearch(left, right, count) {
    while (left <= right) {
      // 자른 케이크의 최소 크기
      const mid = Math.floor((left + right) / 2);
      if (check(mid, count)) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    // 케이크의 최소 크기의 최대값을 정답에 추가
    answer.push(right);
  }

  /**
   * 최소 길이(len)를 맞추기 위해 잘라야하는 횟수
   */
  function check(len, n) {
    let count = 0;
    let pointer = 0;
    for (let i = 1; i <= M; i++) {
      if (arr[i] - arr[pointer] >= len) {
        count++;
        pointer = i;
      }
    }

    if (L - arr[pointer] < len) count--;

    return count >= n;
  }
};

console.log(solution());
