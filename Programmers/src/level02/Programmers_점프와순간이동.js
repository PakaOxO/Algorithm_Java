function solution(n) {
  const dp = (x) => {
    if (x <= 1) return x;

    if (x % 2 === 0) return dp(x / 2); // 2의 배수이면 /2 지점에서 오면 됨
    return dp(x - 1) + 1; // 2의 배수가 아니라면 바로 앞칸에서 오면 됨
  };

  return dp(n);
}

console.log(solution(5));
console.log(solution(6));
console.log(solution(5000));
console.log(solution(1000000000));
console.log(solution(999999999));
