/**
 * Programmers_택배상자
 *   1. 문제 분류 : 자료구조, 스택
 *   2. 접근 방법
 *    - 메인 컨베이어 벨트가 이동하면서 차례인 상자는 담고, 아니면 스택에 넣음
 *    - 스택이 비어있지 않다면 상단 상자가 차례인지도 체크
 */
const solution = (order) => {
  /* 변수 초기화 */
  let answer = 0;
  const N = order.length;
  const stack = [];
  let pointer = 0;

  for (let i = 1; i <= N && pointer < N; i++) {
    if (i === order[pointer]) {
      pointer++;
      answer++;
    } else {
      stack.push(i);
    }

    while (
      stack.length > 0 &&
      pointer < N &&
      stack[stack.length - 1] === order[pointer]
    ) {
      stack.pop();
      pointer++;
      answer++;
    }
  }

  return answer;
};

console.log(solution([4, 3, 1, 2, 5]));
console.log(solution([5, 4, 3, 2, 1]));
