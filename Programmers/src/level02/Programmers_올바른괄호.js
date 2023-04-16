function solution(s) {
  const len = s.length;
  const arr = [];
  let top = -1,
    pointer = 0;
  while (pointer < len) {
    if (top < 0) {
      arr[++top] = s.charAt(pointer++);
      continue;
    }

    const c = s.charAt(pointer++);
    if (arr[top] === "(") {
      if (c === ")") {
        top--;
      } else {
        arr[++top] = c;
      }
    } else {
      // 맨 위에 소모되지 못한 ")" 괄호가 있을 경우
      return false;
    }
    // 남은 괄호 개수보다 이미 스택에 있는 괄호의 개수가 많을 경우
    if (len - pointer <= top) return false;
  }

  return top < 0 ? true : false;
}

console.log(solution("()()"));
console.log(solution("(())()"));
console.log(solution(")()("));
console.log(solution("(()("));
