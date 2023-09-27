/**
 * Programmers_정수 삼각형
 *  - 문제 분류: 다이나믹 프로그래밍
 *
 * @param {Number[]} triangle
 * @returns Number
 */
const solution = (triangle) => {
  /* 변수 선언부 */
  const N = triangle.length;
  const dp = Array.from({ length: N }, (_, idx) => Array.from({ length: idx + 1 }, () => -1));

  /* 메인 로직 */
  for (let i = N - 1; i >= 0; i--) {
    for (let j = 0; j <= i; j++) {
      if (i === N - 1) {
        dp[i][j] = triangle[i][j];
        continue;
      }
      dp[i][j] = triangle[i][j] + Math.max(dp[i + 1][j], dp[i + 1][j + 1]);
    }
  }

  /* 정답 반환 */
  return dp[0][0];
};

console.log(solution([[7], [3, 8], [8, 1, 0], [2, 7, 4, 4], [4, 5, 2, 6, 5]]));

