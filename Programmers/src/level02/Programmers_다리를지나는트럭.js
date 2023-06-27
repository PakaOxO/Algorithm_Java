/*
  Programmers_다리를_지나는_트럭
    1. 문제 분류 : 구현, 큐
    2. 접근 방법
      - 큐(다리, 남은 트럭)에 들어있는 정보를 토대로 걸리는 시간을 도출
      (조건 1)
      - 먼저 매 시간마다 해당 시간에 빠져나갈 트럭이 있는지 체크
        - 빠져나갈 트럭이 있으면, 트럭을 다리에서 빼내고 무게 합게를 줄임

      (조건 1)
      - 새로 들어올 트럭의 무게 + 다리 위에 있는 트럭의 무게의 총합이 제한 무게 범위 이내인지 확인
      (조건 2)
      - 제한 무게 범위 이내여도 다리에 올라갈 수 있는 트럭이 다 차있지 않은지 체크

      - 조건 1, 2를 충족한다면 새로운 트럭을 다리 위에 올리고 무게의 총합을 늘려 줌
      - 만족하지 않는다면 가장 먼저 다리에 들어가있는 트럭을 빼놓고, 현재 시간을 트럭이 빠지는 시간으로 바꿈
        (단, 반복문에서 항상 시간을 +1 하므로 현재 시간을 트럭이 빠지는 시간 -1로)

      - 모든 트럭이 다 지나갔고, 다리 위에 트럭이 없다면 중단
*/
const solution = (bridge_length, weight, truck_weights) => {
  /* 변수 선언부 */
  let time = 0,
    totalWeight = 0,
    bridge = [[0, 0]];

  while (truck_weights.length > 0 || bridge.length > 0) {
    if (bridge[0] && bridge[0][1] === time) {
      totalWeight -= bridge.shift()[0];
    }

    if (
      truck_weights[0] &&
      bridge.length < bridge_length &&
      totalWeight + truck_weights[0] <= weight
    ) {
      totalWeight += truck_weights[0];
      bridge.push([truck_weights.shift(), time + bridge_length]);
    } else {
      if (bridge[0]) {
        time = bridge[0][1] - 1;
      }
    }
    time++;
  }
  return time;
};

console.log(solution(2, 10, [7, 4, 5, 6]));
