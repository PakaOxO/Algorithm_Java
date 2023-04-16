function solution(arr) {
  // 최대공약수
  const gcd = (a, b) => {
    if (b === 0) {
      return a;
    }
    return gcd(b, a % b);
  };
  // 최소공배수
  const lcm = (a, b) => {
    return (a * b) / gcd(a, b);
  };
  const len = arr.length;
  let answer = lcm(1, arr[0]);
  for (let i = 1; i < len; i++) {
    answer = lcm(answer, arr[i]);
  }
  return answer;
}

console.log(solution([2, 6, 8, 14]));
console.log(solution([1, 2, 3]));
console.log(solution([4]));
