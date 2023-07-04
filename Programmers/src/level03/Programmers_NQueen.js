/**
 * Programmers_NQueen
 *  1. 문제 분류 : 백트래킹
 *  2. 접근 방법
 *    - visited 배열을, 가로, 세로, 좌우 대각선으로 나누어 생성
 *    - r, c를 돌면서 visited 배열을 채워보자
 */
const solution = (n) => {
  /* 초기 변수 */
  let answer = 0;
  const vHorz = Array.from({ length: n }, () => false);
  const vVert = Array.from({ length: n }, () => false);
  const vCrss1 = Array.from({ length: 2 * n - 1 }, () => false);
  const vCrss2 = Array.from({ length: 2 * n - 1 }, () => false);

  dfs(0, 0, 0);
  return answer;

  function dfs(r) {
    if (r === n) {
      answer++;
      return;
    }

    for (let c = 0; c < n; c++) {
      if (!vVert[c] && !vCrss1[r + c] && !vCrss2[Math.abs(r - c + n - 1)]) {
        vHorz[r] = vVert[c] = true;
        vCrss1[r + c] = vCrss2[Math.abs(r - c + n - 1)] = true;
        dfs(r + 1);
        vHorz[r] = vVert[c] = false;
        vCrss1[r + c] = vCrss2[Math.abs(r - c + n - 1)] = false;
      }
    }
  }
};

console.log(solution(12));
