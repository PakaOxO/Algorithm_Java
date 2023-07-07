/**
 * Programmers_두큐합같게만들기
 *  1. 문제 분류 : 자료 구조, 큐
 *  2. 접근 방법
 *    - 두 큐의 누적 합을 비교하며 큰 쪽에서 하나 빼 한 쪽으로 이동
 *    - 배열을 사용해 큐로 사용했더니 시간 초과 -> 배열 하나로 만들어 원형 큐라 생각하고 포인터로 사용
 *    - 1번 테케가 계속 틀렸음. 두 합을 같게 만들지 못하는 경우까지 탐색할 범위가 작아서 틀림..
 */
const solution = (q1, q2) => {
  /* 초기 변수 */
  let answer = 0;
  const len = q1.length;
  const size = len * 2;
  const circle = [...q1, ...q2];
  let [acc1, acc2, half] = [0, 0, 0];
  for (let i = 0; i < len; i++) {
    acc1 += q1[i];
    acc2 += q2[i];
  }
  half = acc1 + acc2;
  let [s1, s2] = [0, len];

  /* 메인 로직 */
  if (half % 2 > 0) {
    answer = -1;
  } else {
    while (acc1 !== acc2) {
      if (acc1 > acc2) {
        const num = circle[s1];
        s1 = (s1 + 1) % size;
        acc1 -= num;
        acc2 += num;
      } else {
        const num = circle[s2];
        s2 = (s2 + 1) % size;
        acc2 -= num;
        acc1 += num;\
      }
      answer++;
      if (answer >= size * 3 || s1 === s2) {
        answer = -1;
        break;
      }
    }
  }
  return answer;
};

console.log(solution([3, 2, 7, 2], [4, 6, 5, 1]));
console.log(solution([3, 1], [5, 1]));
console.log(solution([5], [5]));
