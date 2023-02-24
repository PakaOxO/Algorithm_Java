function solution(s, skip, index) {
  const skipLetter = new Set();

  const setSkipLetter = (str) => {
    for (const letter of str) {
      skipLetter.add(letter);
    }
  };

  const getAlphabetIndex = (letter) => {
    return letter.charCodeAt(0) - 97;
  };

  const getAlphabet = (index) => {
    return String.fromCharCode(index + 97);
  };

  const decode = (code, idx) => {
    let word = "";
    for (const letter of code) {
      let index = getAlphabetIndex(letter);
      let count = 0;
      while (count < idx) {
        index = (index + 1) % 26;
        if (!skipLetter.has(getAlphabet(index))) {
          count++;
        }
      }
      word += getAlphabet(index);
    }

    return word;
  };

  // main process
  setSkipLetter(skip);
  return decode(s, index);
}

console.log(solution("aukks", "wbqd", 5));
console.log(solution("z", "a", 1));
