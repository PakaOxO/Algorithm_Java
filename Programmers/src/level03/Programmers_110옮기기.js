/**
 * Programmers_110 옮기기(**못품)
 *  - 문제 분류: 문자열, 자료구조
 */
const solution = (s) => {
  /* 변수 관리 */
  const N = s.length;
  const answer = [];

  /* 메인 로직 */
  for (let i = 0; i < N; i++) {
    answer.push(getNewStr(s[i]));
  }

  /* 정답 반환 */
  return answer;

  // 입력받은 단어의 110의 위치를 조정해서 사전순으로 빠른 단어로 변환
  function getNewStr(str) {
    const stack = [];
    const len = str.length;
    let [top, str110, last0] = [-1, "", -1];
    for (let i = 0; i < len; i++) {
      stack.push(str.charAt(i));
      top++;
      if (top >= 2 && stack[top] === "0") {
        if (stack[top - 1] === "1" && stack[top - 1] === stack[top - 2]) {
          del110();
          str110 += "110";
        }
      }

      if (top >= 0 && stack[top] === "0") last0 = top;
    }

    if (last0 < 0) {
      return str110 + stack.join("");
    }

    const strRes = stack.join("");
    return strRes.slice(0, last0 + 1) + str110 + strRes.slice(last0 + 1);

    function del110() {
      for (let i = 0; i < 3; i++) stack.pop();
      top -= 3;
    }
  }
};

console.log(solution(["1110", "100111100", "0111111010", "000111000"]));

