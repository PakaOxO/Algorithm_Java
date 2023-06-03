const solution = (land) => {
  const N = land.length;
  const dp = [];
  dp.push([...land[0]]);
  for (let i = 1; i < N; i++) {
    const sum = [];
    for (let j = 0; j < 4; j++) {
      let max = 0;
      for (let k = 0; k < 4; k++) {
        if (j === k) continue;
        if (dp[i - 1][k] > max) {
          max = dp[i - 1][k];
        }
      }
      sum.push(land[i][j] + max);
    }
    dp.push(sum);
  }
  return Math.max(...dp[N - 1]);
};

console.log(
  solution([
    [1, 2, 3, 5],
    [5, 6, 7, 8],
    [4, 3, 2, 1],
  ])
);
