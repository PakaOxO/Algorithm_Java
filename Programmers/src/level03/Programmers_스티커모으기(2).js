/**
 * Programmers_스티커 모으기
 *    1. 문제 분류 : 다이나믹 프로그래밍
 *    2. 접근 방법
 *      - 뜯은 스티커 합의 최대는 결국 한 칸씩 띄어서 뗄 수 있는 모든 스티커를 떼면 된다.
 *      - 첫 번째 스티커를 뜯느냐 아니냐를 dp, dp2로 나누어 계산
 *      - dp는 첫 번째 스티커를 뗐다고 가정하고 dp[0] = sticker[0] 할당
 *      - dp2는 첫 번째 스티커를 떼지 않았으므로 dp2[0] = 0, dp2[1] = sticker[1]로 할당
 *        - 이후부터는 i(1 ~ N - 1)만큼 순회하며
 *            -> 이전 스티커를 뗀 경우, dp[i - 2] + sticker[i] 로 이번 스티커를 떼고,
 *            -> 이전 스티커를 떼지 않은 경우, dp[i - 1]
 *            -> 두 값 중 최대값을 dp[i]에 할당
 *    3. 이슈
 *      - for문을 i부터 N - 1까지 순회하며 dp와 dp2를 모두 할당하기 위해 범위 조건(dp는 1 ~ N - 2, dp2는 2 ~ N - 1)을 주었는데 이게 10만(N) 곱하기 비교(if문)연산자를 타다보니 js에서 시간초과
 *        -> 두 개의 for문으로 분리... 이게 그렇게 차이가 많이 나나...
 */
const solution = (sticker) => {
  /* 변수 초기화 */
  const N = sticker.length;
  const dp = Array.from({ length: N }, () => 0);
  const dp2 = Array.from({ length: N }, () => 0);
  let answer = 0;

  /* 메인 로직 */
  dp[0] = sticker[0];
  if (N === 1) {
    answer = sticker[0];
  } else {
    dp2[1] = sticker[1];
    // 첫번째 스티커 포함(맨 끝 스티커 미포함)
    for (let i = 1; i < N - 1; i++) {
      dp[i] = dp[i - 1];
      if (i >= 2) {
        dp[i] = Math.max(dp[i], dp[i - 2] + sticker[i]);
      }
    }
    for (let i = 2; i < N; i++) {
      // 첫번째 스티커 미포함
      if (i >= 2) {
        dp2[i] = dp2[i - 1];
        dp2[i] = Math.max(dp2[i], dp2[i - 2] + sticker[i]);
      }
    }
    answer = Math.max(dp[N - 2], dp2[N - 1]);
  }
  return answer;
};

console.log(solution([14, 6, 5, 11, 3, 9, 2, 10]));
console.log(solution([1, 3, 2, 5, 4]));
console.log(solution([10]));
