function solution(s) {
  const getCharIndex = (char) => {
    return char.charCodeAt(0) - 97;
  };

  // Main Process
  const answer = [];
  const charPos = new Array(26);
  charPos.fill(-1);
  const len = s.length;

  // 입력 문자열의 각 문자를 순회
  for (let i = 0; i < len; i++) {
    const index = getCharIndex(s.charAt(i));
    if (charPos[index] < 0) {
      answer.push(charPos[index]);
    } else {
      answer.push(i - charPos[index]);
    }
    charPos[index] = i;
  }
  return answer;
}
