/*
  BaekJoon_1535, 안녕
    1. 문제 분류 : 완전 탐색, 정렬, 다이나믹 프로그래밍
    2. 접근 방법
      - 그냥 완전 탐색을 할 경우, 최악의 경우에는 2^20가지 탐색이 필요
      - 행복지수가 높은 순, 그리고 소모 체력이 낮은 순으로 정렬하면 어떨까?
      
      - 완전 탐색으로 풀긴 했는데 dp로 풀면 더 시간을 줄일 수 있을 듯
*/
const solution = () => {
  /* 초기 입력 */
  const fs = require("fs");
  const input = fs.readFileSync("./dev/stdin/1535.txt").toString().split("\n");

  /* 변수 초기화 */
  const N = +input[0];
  const hps = input[1].split(" ").map((hp) => +hp);
  const happy = input[2].split(" ").map((hpy) => +hpy);
  const dp = [];
  for (let i = 0; i < 100; i++) {
    dp.push(0);
  }

  /* 메인 로직 */
  for (let i = 0; i < N; i++) {
    for (let hp = 99; hp > 0; hp--) {
      if (hp >= hps[i]) {
        dp[hp] = Math.max(dp[hp], dp[hp - hps[i]] + happy[i]);
      }
    }
  }

  return dp[99];
};

console.log(solution());
