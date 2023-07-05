/**
 * Programmers_삼각달팽이
 *  1. 문제 분류 :
 *  2. 접근 방법
 *    - 각 행마다 2개의 배열을 사용
 *    -> 다른 풀이 : rol, col이 각 변마다 어떻게 이동하는지 규칙을 찾은 풀이
 */
const solution = (n) => {
  const arr = Array.from({ length: n }).map((_, idx) =>
    Array.from({ length: idx + 1 })
  );
  let [r, c, num] = [-1, 0, 1];
  for (let i = n; i > 0; i -= 3) {
    for (let j = 0; j < i; j++) {
      arr[++r][c] = num++;
    }
    for (let j = 0; j < i - 1; j++) {
      arr[r][++c] = num++;
    }
    for (let j = 0; j < i - 2; j++) {
      arr[--r][--c] = num++;
    }
  }
  return arr.flat();
};

console.log(solution(5));
