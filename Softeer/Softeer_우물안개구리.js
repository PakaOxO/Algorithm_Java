/**
 * Softeer_우물 안 개구리
 *    1. 문제 분류 : 완전 탐색..?
 *    2. 접근 방법
 *        - 모든 관계를 돌면서 나보다 상대가 같거나 무거운 중량을 들면 나는 일단 최고라고 생각을 안함
 *        - answer을 N으로 초기화 해두고,
 *          - 내가 한번이라도 상대보다 같거나 작으면 answer - 1이므로 -1한 사람에 대해서는 방문처리
 */
const solution = () => {
  const rl = require("readline").createInterface({
    input: process.stdin,
    output: process.stdout,
  });

  /* 변수 초기화 */
  const lines = [];
  let [N, M] = [0, 0];
  let w = null;
  let v = null;
  let answer = 0;

  rl.on("line", (input) => {
    lines.push(input.trim());
  });

  rl.on("close", () => {
    [N, M] = lines[0].split(" ").map((item) => +item);
    w = lines[1].split(" ").map((item) => +item);
    v = Array.from({ length: N }, () => false);
    answer = N;

    for (let i = 0; i < M; i++) {
      const [s, e] = lines[i + 2].split(" ").map((item) => +item - 1);
      if (w[e] >= w[s]) {
        if (!v[s]) answer--;
        v[s] = true;
      }

      if (w[s] >= w[e]) {
        if (!v[e]) answer--;
        v[e] = true;
      }
    }

    console.log(answer);
    process.exit();
  });
};

solution();

