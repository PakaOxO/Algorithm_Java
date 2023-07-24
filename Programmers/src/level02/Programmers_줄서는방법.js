/**
 * Programmers_줄 서는 방법
 *  1. 문제 분류 : 순열, 수학
 *  2. 접근 방법
 *    - n의 최대값은 20 -> 순열의 가짓 수는 20! -> 11까지는 1억 안쪽 범위(20은 크다..)
 *    - 어차피 오름차순 정렬이니까 순열을 바로 때리지 말고,
 *      - 20자리를 기준으로 1을 맨 앞에 두고 나머지 순열을 구하면 19!
 *      - 1, 2를 맨 앞에 두고 나머지 순열을 구하면 18! ... (이렇게 줄여갈 수 있지 않을까)
 */
const solution = (n, k) => {
  /* 변수 초기화 */
  const factorials = Array.from({ length: 21 }, () => 0);
  const v = Array.from({ length: 21 }, () => false);
  const answer = [];

  /* 메인 로직 */
  let depth = 1;
  while (k > 0) {
    if (depth > n) break;
    for (let i = 1; i <= n && depth <= n + 1; i++) {
      if (v[i]) continue;
      if (k > factorial(n - depth)) {
        k -= factorial(n - depth);
        continue;
      }
      v[i] = true;
      answer.push(i);
      break;
    }
    depth++;
  }

  return answer;

  /* 메서드 */
  function factorial(x) {
    if (x < 1) return 1;
    if (factorials[x] > 0) return factorials[x];
    factorials[x] = factorial(x - 1) * x;
    return factorials[x];
  }
};

console.log(solution(4, 5));
