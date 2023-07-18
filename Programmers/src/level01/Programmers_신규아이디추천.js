/**
 *  Programmers_신규 아이디 추천
 *    1. 문제 분류 : 문자열, 구현
 *    2. 접근 방법
 *      - 주어진 신규 아이디 변환 방법에 따른 함수들을 분리해 구현
 */
const solution = (new_id) => {
  /* 메인 로직부 */
  let answer = new_id;
  answer = stage01(answer);
  answer = stage02(answer);
  answer = stage03(answer);
  answer = stage04(answer);
  answer = stage05(answer);
  answer = stage06(answer);
  answer = stage04(answer);
  answer = stage07(answer);

  return answer;

  /* 메서드 */
  function stage01(new_id) {
    if (new_id.length < 1) return new_id;
    return new_id.toLowerCase();
  }

  function stage02(new_id) {
    return new_id.replace(/[^a-z0-9\.\-\_]/g, "");
  }

  function stage03(new_id) {
    return new_id.replace(/\.{2,}/g, ".");
  }

  function stage04(new_id) {
    return new_id.replace(/^\.|\.$/g, "");
  }

  function stage05(new_id) {
    if (new_id.length > 0) return new_id;
    return "a";
  }

  function stage06(new_id) {
    if (new_id.length > 15) return new_id.slice(0, 15);
    return new_id;
  }

  function stage07(new_id) {
    if (new_id.length > 2) return new_id;
    const last = new_id.charAt(new_id.length - 1);
    return new_id + last.repeat(3 - new_id.length);
  }
};

console.log(solution("...!@BaT#*..y.abcdefghijklm"));
console.log(solution("z-+.^."));
console.log(solution("=.="));
console.log(solution("123_.def"));
console.log(solution("abcdefghijklmn.p"));
