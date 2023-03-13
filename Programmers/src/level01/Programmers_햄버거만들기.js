function solution(ingredient) {
  let answer = 0;
  const hamberger = [1, 2, 3, 1];
  const len = ingredient.length;
  const hLen = hamberger.length;

  let hPointer = 0;
  const stack = new Stack();
  for (let i = 0; i < len; i++) {
    if (ingredient[i] === hamberger[hPointer]) {
      stack.push([ingredient[i], ++hPointer]);
      if (hPointer === hLen) {
        for (let j = 0; j < hLen; j++) {
          stack.pop();
        }
        hPointer = stack.peek() ? stack.peek() : 0;
        answer++;
      }
    } else {
      hPointer = ingredient[i] !== hamberger[0] ? 0 : 1;
      stack.push([ingredient[i], hPointer]);
    }
  }

  return answer;
}

class Stack {
  constructor() {
    this.arr = [];
    this.pointer = 0;
  }

  push(num) {
    this.arr[this.pointer++] = num;
  }

  pop() {
    this.arr[--this.pointer] = null;
  }

  peek() {
    return this.arr[this.pointer - 1] ? this.arr[this.pointer - 1][1] : null;
  }
}

console.log(solution([2, 1, 1, 2, 3, 1, 2, 3, 1]));
console.log(solution([1, 3, 2, 1, 2, 1, 3, 1, 2]));
