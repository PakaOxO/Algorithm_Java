/**
 * BaekJoon_2504, 괄호의 값
 *  1. 문제 분류 : 스택
 *  2. 접근 방법
 *    - 스택에 입력 괄호들을 순서대로 담으며 진행
 *    - 스택 상단 괄호와 새로 넣을 괄호를 비교하며 닫힌 괄호가 완성되었을 경우, 숫자로 변환
 *    - 숫자로 변환했는데 안에 스택의 top에 숫자가 이미 있다면
 *      -> 만든 숫자와 top를 덧셈 연산 후 스택에 추가
 *    - 괄호가 닫는 괄호인데 스택 top에 숫자가 있으면서 숫자 앞에 닫는 괄호와 쌍인 여는 괄호가 있다면,
 *      -> 해당 괄호 쌍에 해당하는 수 * 스택 top의 숫자 계산 후 스택에 추가
 */
const solution = () => {
  /* 초기 입력 */
  const input = require("fs")
    .readFileSync("./dev/stdin/2504.txt")
    .toString()
    .trim();

  /* 변수 선언부 */
  let answer = 1;
  const len = input.length;
  const stack = [];

  for (let i = 0; i < len; i++) {
    if (stack.length > 0) {
      const top = stack[stack.length - 1];
      if (input.charAt(i) === ")") {
        if (top === "(") {
          stack.pop();
          add(2);
        } else if (
          stack.length > 1 &&
          typeof top === "number" &&
          stack[stack.length - 2] === "("
        ) {
          multiply(2);
        } else {
          stack.push(input.charAt(i));
        }
      } else if (input.charAt(i) === "]") {
        if (top === "[") {
          stack.pop();
          add(3);
        } else if (
          stack.length > 1 &&
          typeof top === "number" &&
          stack[stack.length - 2] === "["
        ) {
          multiply(3);
        } else {
          stack.push(input.charAt(i));
        }
      } else {
        stack.push(input.charAt(i));
      }
    } else {
      stack.push(input.charAt(i));
    }
  }
  return stack.length > 1 || typeof stack[0] !== "number" ? 0 : stack[0];

  /* 메서드 */
  function add(num) {
    if (stack.length > 0 && typeof stack[stack.length - 1] === "number") {
      stack.push(stack.pop() + num);
    } else {
      stack.push(num);
    }
  }

  function multiply(num) {
    const val = stack.pop();
    stack.pop();
    add(val * num);
  }
};

console.log(solution());
