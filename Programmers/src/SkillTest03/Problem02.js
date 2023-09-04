/**
 * Programmers_스킬 체크 테스트, 2문항
 *    1. 문제 분류 : 다이나믹 프로그래밍
 *    2. 접근 방법
 *      - 누적합을 먼저 계산하는데 더하고, 빼고를 반복해서 누적합 배열 생성
 *      - 누적합에서 두 수를 꺼내 뺀 값의 절댓값의 최대값을 구하면 됨
 *      - 또는 숫자 하나의 절대값의 최댓값(길이가 1인 순열이 최대일 수도 있음)
 */
function solution(sequence) {
  /* 변수 초기화 */
  let answer = 0;
  const N = sequence.length;
  const acc = Array.from({ length: N + 1 }, () => 0);

  let [min, max] = [Number.MAX_SAFE_INTEGER, Number.MIN_SAFE_INTEGER];
  for (let i = 1; i <= N; i++) {
    acc[i] = acc[i - 1] + sequence[i - 1] * (i % 2 > 0 ? 1 : -1);
    if (acc[i] < min) {
      min = acc[i];
    }
    if (acc[i] > max) {
      max = acc[i];
    }
  }
  console.log(acc, max, min);

  answer = Math.abs(max - min);
  answer = Math.max(answer, Math.abs(max));
  answer = Math.max(answer, Math.abs(min));

  return answer;
}

