function solution(a, b, n) {
  const getCola = (n) => {
    if (n < a) return 0;
    const share = Math.floor(n / a);
    const res = n - share * a;
    const newCola = share * b;
    return newCola + getCola(newCola + res);
  };

  return getCola(n);
}
