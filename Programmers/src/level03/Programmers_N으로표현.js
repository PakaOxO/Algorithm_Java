/**
 * Programmers_N으로 표현
 *  - 문제 분류: 다이나믹 프로그래밍
 */
const solution = (N, number) => {
  /* 변수 관리 */
  const INF = 32000 * 9;
  const dp = Array.from({ length: INF + 1 }, () => 9);

  /* 메인 로직 */
  let str = "";
  for (let i = 1; i <= 5; i++) {
    str += "5";
    getDp(+str, i);
  }
  console.log(dp.slice(0, 100));

  /* 정답 반환 */
  return dp[number];

  // dp[num]을 구하는 재귀
  function getDp(num, depth) {
    dp[i] = Math.min(dp[i], depth);
    return dp[num];
  }

  // N만으로 이루어진 숫자인지
  function isNsNumber(num) {
    const strNum = "" + num;
    for (let i = 0; i < strNum; i++) {
      if (+strNum.charAt(i) !== N) return 0;
    }
    return strNum.length;
  }
};

console.log(solution(5, 12));

// 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
// ? 2 3 ? ? 1 ? ? ? ? 2  3
// 일단 5로 이루어진 수에서 아닌 수로 접근할 것인지 -> 5가 아닌 수에서 접근하는 경우가 더 적은 자원을 사용할 수도 있음
// 아니면 모든 수에 대해 접근할 수 있는 가지 수를 찾던지 -> 문제는 자신보다 작은 수에도, 큰 수에서도 자신에게 접근할 수 있는 경우가 있음
// 경우의 수가 너무 많다.
// 현재 숫자에서 갈 수 있는 방향 -> 사칙연산이므로 4가지

