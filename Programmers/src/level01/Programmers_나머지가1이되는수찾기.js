function solution(n) {
  const isNotPrime = new Array(n).fill(false);
  isNotPrime[0] = isNotPrime[1] = true;

  for (let i = 2; i * i < n; i++) {
    if (isNotPrime[i]) continue;
    for (let j = i * i; j < n; j += i) {
      isNotPrime[j] = true;
    }
  }

  if (!isNotPrime[n - 1]) return n - 1;

  for (let i = 2; i < n; i++) {
    if ((n - 1) % i === 0) return i;
  }
  return 1;
}

console.log(solution(10));
console.log(solution(3));
