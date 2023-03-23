function solution(s) {
  var answer = -1;
  const len = s.length;
  const stack = new Stack();
  for (let i = 0; i < len; i++) {
    const c = s.charAt(i);
    if (stack.getSize() < 1) {
      stack.push(c);
    } else {
      if (stack.peek() === c) {
        stack.pop();
      } else {
        stack.push(c);
      }
    }
  }

  return stack.getSize() === 0 ? 1 : 0;
}

class Stack {
  constructor() {
    this.arr = [];
    this.top = 0;
    this.size = 0;
  }

  push(val) {
    this.arr[this.top++] = val;
    this.size++;
  }

  pop() {
    if (this.size === 0) return null;
    this.size--;
    return this.arr[--this.top];
  }

  peek() {
    if (this.size === 0) return null;
    return this.arr[this.top - 1];
  }

  getSize() {
    return this.size;
  }
}

console.log(solution("baabaa"));
console.log(solution("cdcd"));
