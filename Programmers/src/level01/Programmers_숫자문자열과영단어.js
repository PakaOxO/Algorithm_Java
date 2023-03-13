function solution(s) {
  const dic = {
    on: [3, 1],
    tw: [3, 2],
    th: [5, 3],
    fo: [4, 4],
    fi: [4, 5],
    si: [3, 6],
    se: [5, 7],
    ei: [5, 8],
    ni: [4, 9],
  };

  let answer = 0;
  const len = s.length;
  let key = "";
  let keyLen = 0;
  for (let i = 0; i < len; i++) {
    const char = s.charAt(i);
    const code = s.charCodeAt(i);
    if (code >= 49 && code <= 57) {
      answer = answer * 10 + char * 1;
    } else {
      key += char;
      keyLen++;
      if (keyLen === 2) {
        answer = answer * 10 + dic[key][1];
        i += dic[key][0] - 2;
        key = "";
        keyLen = 0;
      }
    }
  }
  return answer;
}

console.log(solution("one4seveneight"));
console.log(solution("23four5six7"));
console.log(solution("2three45sixseven"));
