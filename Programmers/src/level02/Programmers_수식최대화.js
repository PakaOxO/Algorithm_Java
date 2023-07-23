/**
 * Programmers_수식최대화
 *  1. 문제 분류 : 순열, 스택
 *  2. 접근 방법
 *    - 연산자는 +, -, * 3가지 밖에 없으므로 세 종류의 연산자 우선 순위를 매기는 경우의 수는 3! = 6가지
 *    - 처음 입력 받을 때 각 연산자의 위치를 먼저 저장
 *    - 순열을 만든 뒤 저장된 연산자의 위치를 가져와 연산 수행
 *    - 전체 시간 복잡도는 3!(순열 만들기) * 100(보다 작은 연산) * 100(보다 작은 처음 탐색) = 대충 6000?
 */
const solution = (expression) => {
  /* 변수 선언부 */
  let answer = 0;
  const operators = ["*", "+", "-"];
  perm(0, 0);

  return answer;

  /* 메서드 */
  function swap(i, j) {
    const temp = operators[j];
    operators[j] = operators[i];
    operators[i] = temp;
  }

  function perm(start, depth) {
    if (depth === operators.length) {
      answer = Math.max(answer, Math.abs(calculate(expression)));
      return;
    }

    for (let i = start; i < operators.length; i++) {
      swap(start, i);
      perm(start + 1, depth + 1);
      swap(start, i);
    }
  }

  function calculate(expr) {
    let arr = [];
    let num = 0;
    for (let i = 0; i <= expr.length; i++) {
      const char = expr.charAt(i);
      if (operators.includes(char)) {
        arr.push(num);
        arr.push(char);
        num = 0;
      } else if (i === expr.length) {
        arr.push(num);
      } else {
        num = num * 10 + +char;
      }
    }

    for (let i = 0; i < operators.length; i++) {
      const op = operators[i];
      const stack = [];
      let top = -1;

      for (let j = 0; j < arr.length; j++) {
        const curr = arr[j];
        if (!operators.includes(curr)) {
          if (top > 0 && stack[top] === op) {
            stack.push(operation(stack.pop(), stack.pop(), curr));
            top--;
          } else {
            stack.push(curr);
            top++;
          }
        } else {
          stack.push(curr);
          top++;
        }
      }
      arr = stack;
    }
    return arr[0];
  }

  function operation(operator, a, b) {
    if (operator === "+") {
      return a + b;
    } else if (operator === "-") {
      return a - b;
    } else {
      return a * b;
    }
  }
};

console.log(solution("100-200*300-500+20"));
console.log(solution("50*6-3*2"));
