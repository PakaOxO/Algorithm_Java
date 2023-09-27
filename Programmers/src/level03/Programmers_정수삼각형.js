/**
 * Programmers_정수 삼각형
 *  - 문제 분류: 다이나믹 프로그래밍
 *
 * @param {Number[]} triangle
 * @returns Number
 */
const solution = (triangle) => {
  /* 변수 선언부 */
  let answer = 0;
  const N = triangle.length;
  const dp = Array.from({ length: N }, (_, idx) => Array.from({ length: idx + 1 }, () => -1));

  /* 메인 로직 */
  for (let i = 0; i < N; i++) {
    answer = Math.max(answer, getDp(N - 1, i));
    console.log(dp);
  }

  /* 정답 반환 */
  return answer;

  /**
   * dfs
   */
  function getDp(level, idx) {
    if (level < 0 || idx < 0) return 0;
    if (dp[level][idx] >= 0) return dp[level][idx];

    const left = getDp(level - 1, idx - 1);
    const right = getDp(level - 1, idx);
    dp[level][idx] = triangle[level][idx] + Math.max(left, right);
    return dp[level][idx];
  }
};

console.log(solution([[7], [3, 8], [8, 1, 0], [2, 7, 4, 4], [4, 5, 2, 6, 5]]));
