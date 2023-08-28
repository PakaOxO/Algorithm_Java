/**
 * Programmers_징검다리
 *    1. 문제 분류 : 이분 탐색
 *    2. 접근 방법
 *      -
 */
const solution = (distance, rocks, n) => {
  /* 변수 초기화 */
  const R = rocks.length;

  /* 정답 반환 */
  return binarySeacrh(1, distance);

  /* 이분 탐색 */
  function binarySeacrh(left, right) {
    while (left <= right) {
      const mid = Math.floor((left + right) / 2);
      if (check(mid)) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }

  /* 거리가 주어졌을 때 사라지는 바위의 개수 */
  function check(dist) {
    let count = 0;
    const queue = [0];
    for (let i = 0; i < R; i++) {
      if (rocks[i] - queue[queue.length - 1] < dist) {
        count++;
      } else {
        queue.push(rocks[i]);
      }
    }

    if (distance - queue[queue.length - 1] < dist) {
      count++;
    }

    return count <= n;
  }
};

console.log(solution(25, [2, 14, 11, 21, 17], 2));

