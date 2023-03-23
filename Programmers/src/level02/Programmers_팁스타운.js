function solution(s) {
  const len = s.length;
  const stack = new Stack();
  for (let i = 0; i < len; i++) {
    const c = s.charAt(i);
    if (stack.top < 1) {
      stack.push(c);
    } else {
      if (stack.peek() === c) {
        stack.pop();
      } else {
        stack.push(c);
      }
    }
  }

  return stack.top === 0 ? 1 : 0;
}

class Stack {
  constructor() {
    this.arr = [];
    this.top = 0;
  }

  push(val) {
    this.arr[this.top++] = val;
  }

  pop() {
    if (this.top === 0) return null;
    return this.arr[--this.top];
  }

  peek() {
    if (this.top === 0) return null;
    return this.arr[this.top - 1];
  }
}

console.log(solution("baabaa"));
console.log(solution("cdcd"));
