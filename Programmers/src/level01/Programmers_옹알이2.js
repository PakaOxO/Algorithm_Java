function solution(babbling) {
  const proun = ["aya", "ye", "woo", "ma"];
  const pLen = proun.length;
  const len = babbling.length;

  const check = (str) => {
    const strLen = str.length;
    let prev = "";
    let pointer = 0;
    while (pointer < strLen) {
      let hasProun = false;
      loop: for (const p of proun) {
        const prounLen = p.length;
        if (strLen - pointer < prounLen) continue;
        let flag = true;
        for (let idx = 0; idx < prounLen; idx++) {
          if (str[pointer + idx] !== p[idx]) {
            flag = false;
            break;
          }
        }

        if (flag) {
          if (p === prev) {
            return false;
          }
          pointer += prounLen;
          prev = p;
          hasProun = true;
          break loop;
        }
      }

      if (!hasProun) return false;
    }
    return true;
  };

  let answer = 0;
  for (let i = 0; i < len; i++) {
    if (!check(babbling[i])) continue;
    answer++;
  }

  return answer;
}

console.log(solution(["aya", "yee", "u", "maa"]));
console.log(solution(["ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"]));
