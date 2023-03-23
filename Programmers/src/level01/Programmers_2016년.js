function solution(a, b) {
  const date = [0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
  const day = ["FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"];

  let diff = 0;
  for (let i = 1; i < a; i++) {
    diff += date[i];
  }
  diff += b - 1;
  return day[diff % 7];
}

console.log(solution(5, 24));
