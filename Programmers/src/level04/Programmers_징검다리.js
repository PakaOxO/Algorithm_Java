/**
 * Programmers_징검다리
 *    1. 문제 분류 : 이분 탐색
 *    2. 접근 방법
 *      - 바위 사이의 거리는 1~10억
 *      - 바위 사이의 거리를 이분 탐색하며 해당 거리가 최소 간격이라 가정했을 때 제거해야하는 바위의 개수를 구함
 *        -> 제거해야 할 바위의 개수가 n보다 많으면 거리가 긴 것이기 때문에 right <- mid - 1
 *        -> 제거해야 할 바위의 개수가 n보다 같거나 적으면 거리가 너무 짧은 것이기 때문에 left <- mid + 1
 *      - lowerbound로 이분 탐색 종료시 right의 값이 조건을 만족하는 시작값(최소값)
 */
const solution = (distance, rocks, n) => {
  /* 변수 초기화 */
  const R = rocks.length;

  /* 정답 반환 */
  rocks.sort((a, b) => a - b);
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
    return right;
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

    if (queue[queue.length - 1] !== 0 && distance - queue[queue.length - 1] < dist) {
      count++;
    }

    return count > n;
  }
};

console.log(solution(25, [2, 14, 11, 21, 17], 2));
