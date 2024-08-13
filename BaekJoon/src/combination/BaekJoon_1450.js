/**
 * BaekJoon_1450, 냅색문제
 *  - 문제 분류: 조합
 */
const solution = () => {
  /* 변수 관리 */
  const input = require('fs').readFileSync('./dev/stdin/1450.txt').toString().trim().split('\n');
  const [N, C] = input[0].split(' ').map(Number);
  const weight = input[1].split(' ').map(Number);
  const list = Array.from(new Array(2), () => []);
  let answer = 0;

  /* 메인 로직 */
  const half = Math.floor(N / 2);
  dfs(0, half, 0, 0, 0);
  dfs(half + 1, N - 1, half + 1, 0, 1);
  list[1].sort((a, b) => a - b);

  for (let i = 0; i < list[0].length; i++) {
    let [left, right] = [0, list[1].length - 1];
    const t = list[0][i];
    while (left <= right) {
      const mid = Math.floor((left + right) / 2);
      if (list[1][mid] + t > C) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }

    answer += right + 1;
  }

  /* 정답 반환 */
  return answer;

  //dfs
  function dfs(l, r, c, s, i) {
    if (c > r) {
      list[i].push(s);
      return;
    }

    dfs(l, r, c + 1, s + weight[c], i);
    dfs(l, r, c + 1, s, i);
  }
};

console.log(solution());

