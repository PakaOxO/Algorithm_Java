/**
 * Programmers_두 원 사이의 정수쌍
 *    1. 문제 분류 : 수학
 *    2. 접근 방법
 *      - 1사분면 기준 점의 개수를 구한다음 4배를 하면 될 듯
 *      - y를 0부터 y2까지 증가시키며 카운팅
 *      - y가 정해지면 x의 범위는 자동 계산(r1의 제곱과 r2의 제곱 각각에서 y의 제곱을 뺀 값의 제곱근 사이의 범위)
 *      - 1사분면에서 x가 0인 y축 위의 점은 x축 위의 점을 세면서 4배해 이미 카운팅 되었으므로 x의 범위에서 하한선이 0이면 1로 증가시킴
 */
const solution = (r1, r2) => {
  /* 변수 초기화 */
  let answer = 0;
  const [rr1, rr2] = [Math.pow(r1, 2), Math.pow(r2, 2)];
  /* 메인 로직 */
  for (let i = 0; i <= r2; i++) {
    const p1 = Math.pow(i, 2);
    const range = [Math.ceil(Math.sqrt(rr1 >= p1 ? rr1 - p1 : 0, 2)), ~~Math.sqrt(rr2 - p1, 2)];
    if (range[0] <= range[1]) {
      if (range[0] === 0) range[0]++;
      answer += (range[1] - range[0] + 1) * 4;
    }
  }
  return answer;
};

console.log(solution(2, 3));

