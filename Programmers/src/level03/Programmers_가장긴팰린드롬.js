/**
 * Programemrs_가장 긴 팰린드롬
 *    - 문제 분류 : 문자열, 슬라이딩 윈도우, 투포인터
 */
const solution = (s) => {
  /* 변수 초기화 */
  let answer = 0;
  const len = s.length;

  /* 메인 로직 */
  loop: for (let i = len; i > 0; i--) {
    let [left, right] = [0, i - 1];
    while (right < len) {
      const flag = check(left, right);
      if (flag) {
        answer = i;
        break loop;
      }
      left++;
      right++;
    }
  }

  /* 정답 반환 */
  return answer;

  /**
   * 인덱스 i에서 시작, j에서 끝나는 문자열에 대해 팰린드롬인지 체크
   */
  function check(i, j) {
    while (i < j) {
      if (s.charAt(i) !== s.charAt(j)) return false;
      i++;
      j--;
    }
    return true;
  }
};

console.log(solution("abcdcba"));
console.log(solution("abacde"));
