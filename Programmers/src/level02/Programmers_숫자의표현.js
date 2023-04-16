function solution(n) {
  const finn = (x) => (x * (x + 1)) / 2;

  let answer = 0;
  for (let i = n; i > 0; i--) {
    if (finn(i) < n) break; // 누적합 값이 n보다 작으면 확인안해도 됨
    let sum = i;
    for (let j = i - 1; j > 0; j--) {
      if (sum >= n) break;
      if (sum < n) {
        sum += j;
      }
    }
    if (sum === n) {
      answer++;
    }
  }
  return answer;
}
