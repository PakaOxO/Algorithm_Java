/**
 * Programmers_다음 큰 숫자
 *    1. 문제 분류 : 그리디
 *    2. 접근 방법
 *      - 현재 숫자를 2진수로 표현했을 때 다음 큰 숫자의 조건은
 *        - 1의 개수가 같은 이진수 중 가장 작은 수
 *        - 만약 현재 숫자를 2진수로 표현했을 때 1보다 앞에 있는 0이 한 개라도 있다면 가장 뒤의 0을 그 뒤의 1과 swap
 *        - 1보다 앞에 있는 0이 한 개도 없다면 맨 앞의 1뒤에 새로운 0을 추가
 */
const solution = (n) => {
  /* 변수 선언부 */
  let answer = 0;
  const binary = n.toString(2);
  const len = binary.length;
  let idx = -1;

  /* 메인 로직부 */
  for (let i = len - 1; i > 0; i--) {
    if (binary.charAt(i) === "1" && binary.charAt(i - 1) === "0") {
      idx = i;
      break;
    }
  }

  let [front, mid, back] = [null, null, null];
  if (idx < 0) {
    front = "1";
    mid = "0";
    back = binary.slice(1).split("").sort().join("");
  } else {
    front = binary.slice(0, idx - 1);
    mid = "10";
    back = binary
      .slice(idx + 1)
      .split("")
      .sort()
      .join("");
  }
  answer = parseInt(front + mid + back, 2);

  return answer;
};

console.log(solution(78));
console.log(solution(15));
console.log(solution(6));
