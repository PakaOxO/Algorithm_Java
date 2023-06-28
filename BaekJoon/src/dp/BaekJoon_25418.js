/*
  BaekJoon_25418, 정수 a를 k로 만들기
    1. 문제 분류 : 다이나믹 프로그래밍
    2. 접근 방법
      - 최대 k까지 저장할 수 있는 array를 만들어 dp 테이블로 관리
      - a에서 시작해 연산1과 연산2를 거치며 dp 테이블을 채우기
*/
const solution = () => {
  /* 변수 초기화 */
  let [a, k] = [0, 0];
  let dp = null;

  /* 초기 입력 */
  const fs = require("fs");
  [a, k] = fs
    .readFileSync("./dev/stdin/25418.txt")
    .toString()
    .split(" ")
    .map((item) => +item);
  dp = new Array(k + 1).fill(0);

  return getDp(k);

  /* 메서드 */
  function getDp(num) {
    if (num === a) return 0;
    if (dp[num] > 0) return dp[num];
    if (num % 2 === 0 && num / 2 >= a) {
      dp[num] = getDp(num / 2) + 1;
      return dp[num];
    }
    if (num - 1 >= a) {
      dp[num] = getDp(num - 1) + 1;
      return dp[num];
    }
  }
};

console.log(solution());
