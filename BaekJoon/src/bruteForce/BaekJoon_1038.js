/**
 * BaekJoon_1038, 감소하는 수
 *  - 문제 분류: 완전 탐색
 */
const solution = () => {
  /* 변수 관리 */
  const N = +require('fs').readFileSync('./dev/stdin/1038.txt').toString().trim();
  let count = -1;
  let answer = -1;

  /* 메인 로직 */
  for (let i = 1; i < 11; i++) {
    dfs(0, i, 0);
  }

  /* 정답 반환 */
  return answer;

  // dfs
  function dfs(len, depth, num) {
    if (answer >= 0) return;
    if (len >= depth) {
      count++;
      if (count === N) answer = num;
      return;
    }

    for (let i = 0; i < 10; i++) {
      if (len > 0 && i === num % 10) break;
      dfs(len + 1, depth, num * 10 + i);
    }
  }
};

console.log(solution());
