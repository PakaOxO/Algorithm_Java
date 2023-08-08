/**
 * Softeer_슈퍼컴퓨터 클러스터
 *      1. 문제 분류 : 이분 탐색
 *      2. 접근 방법
 *          - 제한시간이 널널해서 구현인 줄 알았는데, 10만 루프의 반복은 버틸 수 없었다...
 *          - 만들 수 있는 최소 사양의 범위는 현재 사양의 최소값부터 2*10^18(최대 성능 + 최고로 줄 수 있는 스펙업)
 *          - 범위를 이분 탐색하면서 주어진 B로 만들 수 있는지 체크
 *          - 가능한 사양의 최대값을 리턴
 */
const solution = () => {
  const rl = require("readline").createInterface({
    input: process.stdin,
    output: process.stdout,
  });

  /* 변수 초기화 */
  const input = [];
  let [N, B] = [null, null];
  let computers = null;

  rl.on("line", (i) => {
    input.push(i.trim());
  });

  rl.on("close", () => {
    const input1 = input[0].split(" ");
    [N, B] = [+input1[0], BigInt(input1[1])];
    computers = input[1].split(" ").map((item) => +item);
    computers.sort((a, b) => a - b);
    const INF = BigInt("2000000000000000000");

    /* 메인 로직 */
    const min = binarySearch(BigInt(computers[0]), INF);
    console.log(Number(min));

    /* 정답 반환 */

    process.exit();
  });

  /* 조건을 만족하는 스펙업 이분탐색 */
  function binarySearch(from, to) {
    let [left, right] = [from, to + 1n];
    while (left <= right) {
      const mid = ~~((left + right) / 2n);
      const cost = specUpgradeCost(mid);
      if (cost >= 0 && cost <= B) {
        if (cost === B) return mid;
        left = mid + 1n;
      } else {
        right = mid - 1n;
      }
    }
    return right;
  }

  /* 최소 사양 맞추기 */
  function specUpgradeCost(spec) {
    let sum = 0n;
    for (let i = 0; i < N; i++) {
      if (computers[i] >= spec) break;
      sum += (spec - BigInt(computers[i])) * (spec - BigInt(computers[i]));
      if (sum > B) return -1;
    }
    return sum;
  }
};

solution();
