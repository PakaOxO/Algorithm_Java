/**
 * BaekJoon_1027, 고층 건물
 *  - 문제 분류 : 다이나믹 프로그래밍
 */
const solution = () => {
  /* 변수 초기화 */
  const input = require("fs").readFileSync("./dev/stdin/1027.txt").toString().split("\n");
  const N = +input[0];
  const arr = input[1].split(" ").map((item) => +item);
  const dp = Array.from({ length: N }, () => [0, 0]);
  const INF = Number.MAX_SAFE_INTEGER;
  let answer = 0;

  /* 메인 로직 */
  for (let i = 0; i < N; i++) {
    let [count, slope] = [0, -INF];
    for (let j = i - 1; j >= 0; j--) {
      const newSlope = (arr[j] - arr[i]) / (i - j);
      if (newSlope > slope) {
        count++;
        slope = newSlope;
      }
    }
    dp[i][0] = count;

    [count, slope] = [0, -INF];
    for (let j = i + 1; j < N; j++) {
      const newSlope = (arr[j] - arr[i]) / (j - i);
      if (newSlope > slope) {
        count++;
        slope = newSlope;
      }
    }
    dp[i][1] = count;

    answer = Math.max(answer, dp[i][0] + dp[i][1]);
  }

  /* 정답 반환 */
  return answer;
};

console.log(solution());

