function solution(n) {
  const INF = 1234567;
  const dist = new Array(n + 1).fill(0);
  const dp = (x) => {
    if (dist[x] > 0) return dist[x];

    if (x <= 2) {
      dist[x] = x;
    } else {
      dist[x] = (dp(x - 1) + dp(x - 2)) % INF;
    }

    return dist[x];
  };

  return dp(n);
}

console.log(solution(4));
console.log(solution(3));
