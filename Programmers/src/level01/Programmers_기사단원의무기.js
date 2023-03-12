function solution(number, limit, power) {
  let answer = 0;
  const dp = new Array(number + 1);
  for (let i = 1; i <= number; i++) {
    dp[i] = 1;
    let num = i;
    while (num > 1) {
      for (let j = 2; j <= num; j++) {
        if (num === 1) break;
        let cnt = 0;
        while (num % j === 0) {
          cnt++;
          num /= j;
        }
        dp[i] *= cnt + 1;
      }
    }
    answer += dp[i] > limit ? power : dp[i];
  }
  return answer;
}

console.log(solution(5, 3, 2));
console.log(solution(10, 3, 2));
