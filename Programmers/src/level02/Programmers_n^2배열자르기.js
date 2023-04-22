function solution(n, left, right) {
  const answer = [];
  for (let i = left; i <= right; i++) {
    // n으로 나눈 몫이 행, 나머지가 열
    const [r, c] = [Math.floor(i / n) + 1, (i % n) + 1];
    answer.push(Math.max(r, c));
  }
  return answer;
}

console.log(solution(3, 2, 5));
console.log(solution(4, 7, 14));
console.log(solution(3, 2, 5));
