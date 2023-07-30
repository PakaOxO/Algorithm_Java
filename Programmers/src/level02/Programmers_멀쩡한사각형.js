/**
 * Programmers_멀쩡한 사각형
 *    1. 문제 분류 : 그리디
 *    2. 접근 방법
 *      - 규칙이 있네
 *      - 처음 1,1(w, h)을 기준으로
 *        - 현재 기울기가 대각선으로 자른 라인의 기울기보다 크면 w를 1 증가시켜 기울기를 줄여주고
 *        - 작으면 h를 1 증가시켜 기울기를 늘려줌
 *        - 만약 같으면 w와 h를 둘다 늘려 주는데, 사실 이 이후론 반복할 필요가 없음 -> 같은 기울기만큼 반복하기 때문에
 *      - 따라서 최대공약수를 구해 같은 기울기가 나오는 반복 횟수를 구한 다음 단위 기울기에 대해 필요없는 사각형의 수 * 반복 횟수를 하면 전체 필요없는 사각형 수가 도출
 *      - w * h - (전체 필요없는 사각형의 수)를 리턴
 */
const solution = (w, h) => {
  /* 변수 선언부 */
  let count = 0;
  let degree = h / w;
  const gcd = getGCD(w, h);
  const unitW = w / gcd;
  const repeatCount = w / unitW;
  let [r, c] = [1, 1];

  /* 메인 로직 */
  while (r <= h || c <= w) {
    count++;
    const compare = degree > r / c;
    if (degree === r / c) {
      break;
    }
    if (compare) {
      r++;
    } else {
      if (compare) r++;
      c++;
    }
  }

  return w * h - count * repeatCount;

  /* 메서드 */
  function getGCD(x, y) {
    if (y === 0) return x;
    return getGCD(y, x % y);
  }
};

console.log(solution(8, 12));
