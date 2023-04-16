function solution(n, m, section) {
  let answer = 0;
  const len = section.length;
  let left = 0;

  while (left < len) {
    const prevLeft = left; // 지금 칠하는 위치의 가장 왼쪽
    while (section[++left] < section[prevLeft] + m) {} // 1번 칠할 때 영역내에 포함되는 다음 포인트들 pass
    answer++;
  }
  return answer;
}

console.log(solution(5, 4, [2, 3, 6]));
