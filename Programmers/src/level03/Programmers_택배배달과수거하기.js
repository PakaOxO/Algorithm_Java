const solution = (cap, n, deliveries, pickups) => {
  /* 초기값 */
  let [p1, p2] = [n - 1, n - 1];
  let answer = 0;

  /* 배달 왕복 */
  const deliver = () => {
    let [dCnt, pCnt] = [0, 0];
    let [dMax, pMax] = [-1, -1];

    while (dCnt < cap && p1 >= 0) {
      if (deliveries[p1] > 0) {
        if (dMax < 0) dMax = p1;
        if (deliveries[p1] + dCnt <= cap) {
          dCnt += deliveries[p1];
          deliveries[p1] = 0;
        } else {
          deliveries[p1] -= cap - dCnt;
          dCnt = cap;
          break;
        }
      }
      p1--;
    }
    while (pCnt < cap && p2 >= 0) {
      if (pickups[p2] > 0) {
        if (pMax < 0) pMax = p2;
        if (pickups[p2] + pCnt <= cap) {
          pCnt += pickups[p2];
          pickups[p2] = 0;
        } else {
          pickups[p2] -= cap - pCnt;
          pCnt = cap;
          break;
        }
      }
      p2--;
    }

    return Math.max(dMax, pMax) + 1;
  };

  while (true) {
    const dist = deliver();
    if (dist < 1) break;
    answer += dist * 2;
  }

  return answer;
};

console.log(solution(4, 5, [1, 0, 3, 1, 2], [0, 3, 0, 4, 0]));
console.log(solution(2, 7, [1, 0, 2, 0, 1, 0, 2], [0, 2, 0, 1, 0, 2, 0]));
// 14, 10, 6, 2
