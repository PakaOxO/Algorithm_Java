function solution(n, a, b) {
  let answer = 1; // 가장 처음 경기는 1번째 경기
  a--, b--; // 1,2 보단 0,1로 바꿔서 서로 2로 나누었을 때 몫이 같으면 서로 맞붙은 경우로 간주
  while (Math.floor(a / 2) !== Math.floor(b / 2)) {
    a = Math.floor(a / 2);
    b = Math.floor(b / 2);
    answer++;
    if (a === b) break;
  }

  return answer;
}

console.log(solution(8, 4, 7));
