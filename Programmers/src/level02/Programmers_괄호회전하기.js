function solution(s) {
  let answer = 0;
  const len = s.length;
  const stack = new Array(len);
  loop: for (let i = 0; i < len; i++) {
    let size = 0;
    for (let j = 0; j < len; j++) {
      const pos = (i + j) % len;
      if (size < 1) {
        if (
          s.charAt(pos) === "]" ||
          s.charAt(pos) === "}" ||
          s.charAt(pos) === ")"
        ) {
          continue loop;
        }
        stack[size] = s.charAt(pos);
        size++;
      } else {
        if (stack[size - 1] === "[" && s.charAt(pos) === "]") {
          size--;
        } else if (stack[size - 1] === "{" && s.charAt(pos) === "}") {
          size--;
        } else if (stack[size - 1] === "(" && s.charAt(pos) === ")") {
          size--;
        } else {
          if (
            (s.charAt(pos) === "]" ||
              s.charAt(pos) === "}" ||
              s.charAt(pos) === ")") &&
            size > 0
          ) {
            break;
          }
          stack[size] = s.charAt(pos);
          size++;
        }
      }
    }
    if (size < 1) answer++;
  }
  return answer;
}

console.log(solution("[](){}"));
console.log(solution("}]()[{"));
console.log(solution("[)(]"));
console.log(solution("}}}"));
