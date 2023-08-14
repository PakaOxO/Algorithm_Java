/**
 * Programmers_숫자 블록
 *    1. 문제 분류 : 수학
 *    2. 접근 방법
 *      - 자기를 나눌 수 있는 약수 중 자신을 제외한 가장 큰 수를 반환하면 된다.
 *      - 반환된 값이 10000000(1천만)보다 클 수는 없음 -> 사용한 블록의 최대 크기가 천만이기 때문
 *      - 범위를 탐색하면서 2부터 해당 위치의 제곱근까지 탐색하면서 해당 수를 처음으로 나누어 떨어지게 하는 수를 찾음
 *        -> 그 수로 나눈 몫이 해당 위치의 가장 큰 약수
 *        -> 근데 그 수가 1천만보다 커지면?
 *        -> 나누어 떨어지게 하는 수 중 가장 큰 수를 기억하고 있다가 그 수를 정답으로 넣는다
 */
const solution = (begin, end) => {
  /* 변수 초기화 */
  const INF = 10000000;
  const answer = [];

  /* 메인 로직 */
  loop: for (let i = begin; i < end + 1; i++) {
    if (i === 1) {
      answer.push(0);
      continue;
    }

    let max = 1;
    for (let j = 2; j * j <= i; j++) {
      if (i % j > 0) continue;
      if (i / j > INF) {
        max = Math.max(max, j);
        continue;
      }
      answer.push(i / j);
      continue loop;
    }

    answer.push(max);
  }
  return answer;
};

console.log(solution(1, 20));
console.log(solution(999999998, 1000000000));
console.log(solution(100000015, 100000015));

