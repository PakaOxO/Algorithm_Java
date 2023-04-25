function solution(n, k) {
  const isPrime = (x) => {
    if (!x || x === 1) return false;
    for (let i = 2; i <= Math.sqrt(x); i++) {
      if (x % i === 0) return false;
    }
    return true;
  };

  const arr = n.toString(k).split("0");
  return arr.reduce((acc, curr) => acc + (isPrime(+curr) ? 1 : 0), 0);
}

console.log(solution(437674, 3));
console.log(solution(110011, 10));
