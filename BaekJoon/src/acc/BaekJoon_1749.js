/**
 * BaekJoon_1749, 점수따먹기
 *    1. 문제 분류 : 누적 합
 *    2. 접근 방법
 *      - 누적 합을 구한 뒤, 부분 누적 합을 찾아 해당 값의 최대 값으로 answer 초기화
 */
const solution = () => {
  /* 변수 초기화 */
  const input = require("fs").readFileSync("./dev/stdin/1749.txt").toString().trim().split("\n");
  const INF = 123456789;
  let answer = -INF;
  const [N, M] = input[0].split(" ").map((item) => +item);
  const dp = Array.from({ length: N + 1 }, () => Array.from({ length: M + 1 }, () => -INF));
  const acc = [];
  acc.push(Array.from({ length: M + 1 }, () => 0));
  for (let i = 0; i < N; i++) {
    acc.push([0, ...input[i + 1].split(" ").map((item) => +item)]);
  }

  /* 메인 로직 */
  for (let i = 1; i <= N; i++) {
    for (let j = 1; j <= M; j++) {
      acc[i][j] = acc[i][j] + acc[i - 1][j] + acc[i][j - 1] - acc[i - 1][j - 1];
      dp[i][j] = Math.max(acc[i][j], Math.max(dp[i - 1][j - 1], Math.max(dp[i - 1][j], dp[i][j - 1])));

      for (let l = 1; l <= i; l++) {
        for (let m = 1; m <= j; m++) {
          answer = Math.max(answer, acc[i][j] - acc[i - l][j] - acc[i][j - m] + acc[i - l][j - m]);
        }
      }
      // answer = Math.max(answer, acc[i][j] - (dp[i - 1][j - 1] === INF ? 0 : dp[i - 1][j - 1]));
    }
  }

  console.log(dp);

  /* 정답 반환 */
  return answer;
};

console.log(solution());

