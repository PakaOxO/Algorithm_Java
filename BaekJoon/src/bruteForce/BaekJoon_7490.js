/**
 * BaekJoon_7490, 0 만들기
 *  - 완전 탐색, 스택, 문자열
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/7490.txt").toString().split("\n");
  const T = +input[0];
  const stack = [];
  const answer = Array.from({ length: T }, () => []);

  /* 메인 로직 */
  for (let tc = 1; tc <= T; tc++) {
    const N = +input[tc];
    getComb(N, 1);
    answer.push("\n");
  }

  /* 정답 반환 */
  return answer.join("").trim();

  /**
   * 모든 수식 조합 탐색
   */
  function getComb(n, x) {
    if (x > n) {
      if (calculate() === 0) {
        answer.push(stack.join("") + "\n");
      }
      return;
    }

    // 연산
    if (x === 1) {
      stack.push(x);
      getComb(n, x + 1);
      stack.pop();
    } else {
      operate(n, x, " ");
      operate(n, x, "+");
      operate(n, x, "-");
    }
  }

  /**
   * 덧셈, 뺄셈, 숫자 합치기
   */
  function operate(n, x, operator) {
    if (x === 1) {
      stack.push(x);
      getComb(n, x + 1);
      stack.pop();
      return;
    }
    stack.push(operator);
    stack.push(x);
    getComb(n, x + 1);
    stack.pop();
    stack.pop();
  }

  /**
   * stack 내부 수식 계산
   */
  function calculate() {
    const newStack = [];

    for (let i = 0; i < stack.length; i++) {
      if (stack[i] === " ") {
        newStack.push(+(newStack.pop() + "" + stack[++i]));
      } else {
        newStack.push(stack[i]);
      }
    }

    let pointer = 1;
    let result = newStack[0];

    while (pointer < newStack.length) {
      if (newStack[pointer] === "+") {
        result += newStack[pointer + 1];
        pointer += 2;
      } else {
        result -= newStack[pointer + 1];
        pointer += 2;
      }
    }

    return result;
  }
};

console.log(solution());

