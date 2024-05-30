/**
 * BaekJoon_2630, 색종이 만들기
 *  - 문제 분류: 분할정복, 누적합
 */
const solution = () => {
  /* 변수 관리 */
  const input = require('fs').readFileSync('./dev/stdin/2630.txt').toString().trim().split('\n');
  const N = +input[0];
  const acc = [Array.from({ length: N + 1 }, () => 0)];

  for (let i = 1; i <= N; i++) {
    const line = [0, ...input[i].split(' ').map(Number)];
    for (let j = 1; j <= N; j++) {
      line[j] += line[j - 1] + acc[i - 1][j] - acc[i - 1][j - 1];
    }
    acc.push(line);
  }

  /* 메인 로직 */
  const answer = check(acc, 1, 1, N);

  /* 정답 반환 */
  return answer.join('\n');

  // 분할 정복
  function check(arr, r, c, size) {
    const acc =
      arr[r + size - 1][c + size - 1] - arr[r - 1][c + size - 1] - arr[r + size - 1][c - 1] + arr[r - 1][c - 1];

    if (size === 1) return acc ? [0, 1] : [1, 0];
    if (acc === size * size) return [0, 1];
    if (acc === 0) return [1, 0];

    const half = size / 2;
    const c1 = check(arr, r, c, half);
    const c2 = check(arr, r, c + half, half);
    const c3 = check(arr, r + half, c, half);
    const c4 = check(arr, r + half, c + half, half);
    return [c1[0] + c2[0] + c3[0] + c4[0], c1[1] + c2[1] + c3[1] + c4[1]];
  }
};

console.log(solution());

