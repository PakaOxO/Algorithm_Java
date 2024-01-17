/**
 * CodeTree_괄호열의 값
 *  - 문제 분류: stack
 */
const solution = () => {
  /* 변수 관리 */
  const braces = require("fs").readFileSync("./dev/stdin/괄호열의값.txt").toString().trim();
  const len = braces.length;
  const stack = [];
  let top = -1;
  let flag = true;
  let answer = 0;

  /* 메인 로직 */
  for (let i = 0; i < len; i++) {
    const char = braces.charAt(i);
    if (char === "(" || char === "[") {
      stack.push(char);
      top++;
    } else {
      if (char === ")") {
        if (stack[top] === "(") {
          pop();
          pushNumber(2);
        } else if (typeof stack[top] === "number") {
          if (stack[top - 1] === "(") {
            let sum = pop() * 2;
            pop();
            pushNumber(sum);
          } else {
            flag = false;
            break;
          }
        } else {
          flag = false;
          break;
        }
      } else if (char === "]") {
        if (stack[top] === "[") {
          pop();
          pushNumber(3);
        } else if (typeof stack[top] === "number") {
          if (stack[top - 1] === "[") {
            let sum = pop() * 3;
            pop();
            pushNumber(sum);
          } else {
            flag = false;
            break;
          }
        } else {
          flag = false;
          break;
        }
      }
    }
  }

  /* 정답 반환 */
  if (flag && stack.length === 1) {
    answer = stack[0];
  }
  return answer;

  // push number
  function pushNumber(num) {
    while (typeof stack[top] === "number") {
      num += stack.pop();
      top--;
    }
    stack.push(num);
    top++;
  }

  // pop
  function pop() {
    if (top < 0) return null;
    top--;
    return stack.pop();
  }
};

console.log(solution());

