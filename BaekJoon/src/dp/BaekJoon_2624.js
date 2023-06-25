/*
  BaekJoon_2624, 동전 바꿔주기
    1. 문제 분류 : 다이나믹 프로그래밍
    2. 접근 방법
      - 개수에 제한이 있어 배낭 이론으로 풀지 못한 문제
      - 
*/
const solution = () => {
  /* 변수 초기화 */
  let [T, k] = [0, 0];
  let dp = null;

  /* 초기 입력 */
  const fs = require("fs");
  const input = fs.readFileSync("./dev/stdin/2624.txt").toString().split("\n");
  [T, k] = [+input[0], +input[1]];
  dp = new Array(T + 1).fill(0);
  dp[0] = 1;

  for (let i = 2; i < k + 2; i++) {
    const [unitPrice, cnt] = input[i].split(" ").map((item) => +item);
    for (let j = T; j > 0; j--) {
      for (let c = 1; c <= cnt && j - unitPrice * c >= 0; c++) {
        dp[j] += dp[j - unitPrice * c];
      }
    }
  }

  return dp[T];
};

console.log(solution());
