const solution = (x, y, n) => {
  const INF = 1000000007;
  const dp = new Array(y + 1).fill(INF);
  let answer = INF;

  const setDp = (num, depth) => {
    if (dp[num] <= depth || depth >= answer) return;
    dp[num] = depth;
    if (num === x) {
      answer = depth;
      return;
    }

    if (num % 3 === 0 && num / 3 >= x) {
      setDp(num / 3, dp[num] + 1);
    }

    if (num % 2 === 0 && num / 2 >= x) {
      setDp(num / 2, dp[num] + 1);
    }

    if (num - n >= x) {
      setDp(num - n, dp[num] + 1);
    }
  };

  setDp(y, 0);

  return answer === INF ? -1 : answer;
};

console.log(solution(10, 40, 5));
console.log(solution(10, 40, 30));
console.log(solution(2, 1000000, 4));
