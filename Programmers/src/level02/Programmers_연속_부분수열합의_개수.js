/*
  Programmers, 연속 부분 수열합의 개수
  Sketch Idea
    1. dp로 풀어봤는데 반복문이랑 차이가 없는 듯
    2. 이전 요소의 길이 N-1개의 합에 나 자신을 더하면 나 자신의 N개 요소의 합을 구한다는 점화식을 사용해 풀이
*/
function solution(elements) {
  const N = elements.length;
  const dp = new Array(N);
  const set = new Set();

  dp[0] = [];
  dp[0][0] = elements[0];
  set.add(dp[0][0]);

  for (let i = 1; N - i > 0; i++) {
    dp[0][i] = dp[0][i - 1] + elements[N - i];
    set.add(dp[0][i]);
  }

  for (let i = 1; i < N; i++) {
    dp[i] = new Array(N);
    dp[i][0] = elements[i];
    set.add(dp[i][0]);
    for (let j = 1; j < N; j++) {
      dp[i][N - j] = dp[i - 1][N - j - 1] + elements[i];
      set.add(dp[i][N - j]);
    }
  }

  return set.size;
}

console.log(solution([7, 9, 1, 1, 4]));
