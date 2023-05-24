function solution(str1, str2) {
  // 대문자 알파벳인지 체크
  const isAlphabet = (char) => {
    return char >= "A" && char <= "Z";
  };

  // 부분 문자집합 도출
  const getSubset = (str) => {
    const map = new Map();
    const len = str.length;
    str = str.toUpperCase();

    for (let i = 0; i < len - 1; i++) {
      let substr = "";
      for (let j = 0; j < 2; j++) {
        if (isAlphabet(str.charAt(i + j))) {
          substr += str.charAt(i + j);
        }
      }
      if (substr.length < 2) continue; // 2글자 완성이 안되면 다음 루프

      if (!map.has(substr)) {
        map.set(substr, 1);
      } else {
        map.set(substr, map.get(substr) + 1);
      }
    }
    return map;
  };

  // 유사도 검증
  const similarity = (subset1, subset2) => {
    const [keys1, keys2] = [subset1.keys(), subset2.keys()];
    let [top, bottom] = [0, 0];
    for (const key of keys1) {
      if (subset2.has(key)) {
        top += Math.min(subset1.get(key), subset2.get(key));
        bottom += Math.max(subset1.get(key), subset2.get(key));
      } else {
        bottom += subset1.get(key);
      }
    }
    for (const key of keys2) {
      if (subset1.has(key)) continue;
      bottom += subset2.get(key);
    }
    return top === 0 && bottom === 0
      ? 65536
      : Math.floor(65536 * (top / bottom));
  };

  const [subset1, subset2] = [getSubset(str1), getSubset(str2)];
  return similarity(subset1, subset2);
}

console.log(solution("FRANCE", "french"));
console.log(solution("handshake", "shake hands"));
console.log(solution("aa1+aa2", "AAAA12"));
console.log(solution("E=M*C^2", "e=m*c^2"));
