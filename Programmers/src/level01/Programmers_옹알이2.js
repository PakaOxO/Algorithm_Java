function solution(babbling) {
  const check = (str1, str2, pointer) => {
    const len1 = str1.length;
    const len2 = str2.length;
    if (len1 - pointer < len2) return false;
    for (let i = 0; i < 4; i++) {
      let flag = true;
      for (let j = 0; j < len2; j++) {
        if (str1[pointer + j] !== str2[j]) {
          flag = false;
          break;
        }
      }
      if (flag) {
        return true;
      }
    }
    return false;
  };

  const proun = ["aya", "ye", "woo", "ma"];
  const len = babbling.length;
  const pLen = proun.length;
  let answer = 0;
  let prevProun = -1;
  while (pointer < len) {
    for (let i = 0; i < pLen; i++) {}
  }
  return answer;
}

console.log(solution(["aya", "yee", "u", "maa"]));
