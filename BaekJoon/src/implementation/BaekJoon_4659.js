/**
 * BaekJoon_4659, 비밀번호 발음하기
 *  - 문제 분류: 문자열, 구현
 */
const solution = () => {
  // validation
  function isvalid(pw) {
    const len = pw.length;
    let hasAEIOU = false;
    let count = 0;
    let prev = "";
    let prevAEIOU = false;

    for (let i = 0; i < len; i++) {
      const char = pw.charAt(i);
      const isAEIOU = char === "a" || char === "e" || char === "i" || char === "o" || char === "u";
      count = prevAEIOU === isAEIOU ? count + 1 : 1;
      if (char === prev && !(char === "e" || char === "o")) return false;
      if (count === 3) return false;
      if (isAEIOU) hasAEIOU = true;
      prev = char;
      prevAEIOU = isAEIOU;
    }

    return hasAEIOU;
  }

  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/4659.txt").toString().trim().split("\n");
  let pointer = 0;
  const answer = [];

  /* 메인 로직 */
  while (true) {
    const line = input[pointer++];
    if (line === "end") break;

    const flag = isvalid(line);
    answer.push(`<${line}> is${flag ? " " : " not "}acceptable.`);
  }

  /* 정답 반환 */
  return answer.join("\n");
};

console.log(solution());

