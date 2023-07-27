/**
 * Softeer_스마트 물류
 *    1. 문제 분류 : 구현..?, 완전 탐색
 *    2. 접근 방법
 *      - 주어진 생산라인을 순회하면서 로봇이면 로봇의 가동 범위를 다시 순회
 *      - 가동 범위를 순회하면서(i - d ~ i + d) 부품이 있으면 집는다.
 *      - 집은 부품의 위치는 방문 처리
 *      - 전체 순회를 반복하면서 로봇이 집은 부품의 개수를 카운트
 */
const solution = () => {
  const readline = require("readline");
  const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout,
  });

  const lines = [];

  rl.on("line", (input) => {
    lines.push(input.trim());
  });

  rl.on("close", () => {
    const [N, K] = lines[0]
      .trim()
      .split(" ")
      .map((item) => +item);
    const arr = lines[1].trim().split("");
    const v = Array.from({ length: N }, () => false);
    let answer = 0;

    for (let i = 0; i < N; i++) {
      if (arr[i] === "H") continue;
      const [min, max] = [i - K < 0 ? 0 : i - K, i + K >= N ? N - 1 : i + K];
      for (let j = min; j <= max; j++) {
        if (j === i) continue;
        if (arr[j] === "P" || (arr[j] === "H" && v[j])) continue;
        v[j] = true;
        answer++;
        break;
      }
    }

    console.log(answer);

    process.exit();
  });
};

solution();
