/**
 * Programmers_최소값만들기
 *  1. 문제 분류 : 정렬, 그리디
 *  2. 접근 방법
 *    - 정렬된 두 배열에 대해 곱의 합의 최소가 되기 위해서는 양 배열에서 뽑은 숫자의 차이가 클 수록?
 *    - 한 배열에서 작은 수부터 뽑는 다면, 또 다른 배열에서는 큰 수부터 뽑아보자
 */
const solution = (A, B) => {
  /* 초기 변수 및 정렬 */
  const len = A.length;
  A.sort((a, b) => a - b);
  B.sort((a, b) => b - a);

  /* 메인 로직 */
  let sum = 0;
  for (let i = 0; i < len; i++) {
    sum += A[i] * B[i];
  }
  return sum;
};

console.log(solution([1, 4, 2], [5, 4, 4]));
console.log(solution([1, 2], [3, 4]));
