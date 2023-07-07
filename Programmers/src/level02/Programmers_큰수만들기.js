/**
 * Programmers_큰수만들기
 *  1. 문제 분류 : 그리디
 *  2. 접근 방법
 *    -
 */
const solution = (number, k) => {
  let answer = "";
  const len = number.length;
  for (let i = 0; i < len; i++) {
    if (k === 0) {
      answer += number.slice(i);
      break;
    } else if (len - i === k) {
      break;
    }

    let [max, idx] = [+number.charAt(i), i];
    for (let j = i + 1; j <= i + k && j < len; j++) {
      if (+number.charAt(j) > max) {
        [max, idx] = [+number.charAt(j), j];
      }
      if (max === 9) break;
    }
    answer += max;
    k -= idx - i;
    i = idx;
  }
  return answer;
};

console.log(solution("1924", 2));
console.log(solution("1231234", 3));
console.log(solution("4177252841", 4));
console.log(solution("213", 2));
