/**
 * Softeer_바이러스
 *    1. 문제 분류 : 수학
 *    2. 접근 방법
 *      - 오버플로우를 주의해 모듈러 연산과 제곱을 반복
 *      - BigInt를 사용
 */
const solution = () => {
  const rl = require("readline").createInterface({
    input: process.stdin,
    output: process.stdout,
  });

  /* 변수 선언 */
  const input = [];
  let [K, P, N] = [null, null, null];
  let answer = null;
  const INF = 1000000007;

  rl.on("line", (l) => {
    input.pusH(l.trim());
  });

  rl.on("close", () => {
    /* 변수 초기화 */
    [K, P, N] = input[0].split(" ").map((item) => +item);
    answer = BigInt(K);

    /* 메인 로직 */
    for (let i = 0; i < N; i++) {
      answer = (answer * BigInt(P)) % BigInt(INF);
    }

    /* 결과 반환 */
    console.log(answer.toString());
    process.exit();
  });
};

solution();
