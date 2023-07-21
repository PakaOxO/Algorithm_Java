/**
 * Programmers_괄호 변환
 *  1. 문제 분류 : 문자열, 구현, 스택
 *  2. 접근 방법
 *    - 문제에서 주어진 로직대로 구현만 하면 될 것 같다. 일단 시도해보자.
 */
const solution = (p) => {
  /* 메인 로직부 */
  return convert(p);

  /* 메서드 */
  // 올바른 괄호 문자열을 만들기 위한 메인 함수
  function convert(str) {
    if (str.length < 1) return str;
    let fixed = "";
    const [u, v] = cut(str);

    if (check(u)) {
      fixed = u + convert(v);
    } else {
      fixed = fix(u, v);
    }
    return fixed;
  }

  // 두 균형잡힌 문자열 u, v로 분리
  function cut(str) {
    let [left, right, breakPoint] = [0, 0, 0];
    const len = str.length;

    for (let i = 0; i < len; i++) {
      if (str.charAt(i) === "(") {
        left++;
      } else {
        right++;
      }
      if (left === right) {
        breakPoint = i;
        break;
      }
    }

    return [str.slice(0, breakPoint + 1), str.slice(breakPoint + 1)];
  }

  // 올바른 괄호 문자열인지 체크하는 함수
  function check(str) {
    const arr = [];
    let top = -1;
    const len = str.length;

    for (let i = 0; i < len; i++) {
      const brace = str.charAt(i);
      if (top < 0) {
        arr.push(brace);
        top++;
        continue;
      }

      if (arr[top] === "(") {
        if (brace === ")") {
          arr.pop();
        } else {
          arr.push(brace);
        }
      } else {
        return false;
      }
    }

    if (top > 0) return false;
    return true;
  }

  // u가 올바른 괄호 문자열이 아니라면 수정
  function fix(u, v) {
    let newStr = "(";
    newStr += convert(v) + ")";
    for (let i = 1; i < u.length - 1; i++) {
      newStr += u.charAt(i) === "(" ? ")" : "(";
    }
    return newStr;
  }
};

console.log(solution("(()())()"));
console.log(solution(")("));
console.log(solution("()))((()"));
