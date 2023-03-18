function solution(n) {
  // 소수가 아닌지 확인한 값을 넣을 배열
  const isPrime = new Array(n + 1).fill(true);
  isPrime[0] = isPrime[1] = false;

  // 1은 소수가 아니므로 -1
  let answer = n - 1;
  for (let i = 2; i * i <= n; i++) {
    // 이미 소수가 아니라고 판명났으면 continue
    if (!isPrime[i]) continue;
    // 소수이면 소수의 배수는 소수가 아님
    for (let j = i * i; j <= n; j += i) {
      if (!isPrime[j]) continue;
      isPrime[j] = false;
      answer--;
    }
  }
  return answer;
}

console.log(solution(10));
console.log(solution(5));
console.log(solution(30));
