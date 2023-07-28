/**
 * Programmers_숫자 카드 나누기.js
 *    1. 문제 분류 : 수학, 그리디
 *    2. 접근 방법
 *      - 각 배열에 대해 전체의 최대 공약수를 구함
 *      - 각각의 최대 공약수로 다른 쪽 배열들에 나눌 수 있는 값이 있는지 체크
 */
const solution = (arrayA, arrayB) => {
  /* 변수 선언부 */
  let answer = 0;
  const N = arrayA.length;

  /* 메인 로직 */
  let [gcdA, gcdB] = [arrayA[N - 1], arrayB[N - 1]];
  for (let i = 0; i < N - 1; i++) {
    gcdA = getGCD(arrayA[i], gcdA);
    gcdB = getGCD(arrayB[i], gcdB);
  }

  let [flagA, flagB] = [true, true];
  for (let i = 0; i < N; i++) {
    if (arrayB[i] % gcdA === 0) flagA = false;
    if (arrayA[i] % gcdB === 0) flagB = false;
    if (!flagA && !flagB) break;
  }
  if (flagA) answer = gcdA;
  if (flagB) answer = Math.max(answer, gcdB);

  return answer;

  /* 메서드 */
  function getGCD(x, y) {
    if (y === 0) {
      return x;
    }
    return getGCD(y, x % y);
  }
};

console.log(solution([10, 17], [5, 20]));
console.log(solution([10, 20], [5, 17]));
console.log(solution([14, 35, 119], [18, 30, 102]));
