function solution(n, words) {
  const answer = [0, 0];
  const set = new Set(); // 이전 입력 단어를 확인할 Set 사용

  let lastChar = "";
  const len = words.length;
  for (let i = 0; i < len; i++) {
    // 끝말잇기 시작
    const w = words[i];
    // 이전에 상ㅇ된 단어이거나 끝말잇기가 성립되지 않을 경우
    if (set.has(w) || (lastChar != "" && lastChar !== w[0])) {
      const res = i % n;
      const share = (i - res) / n;
      answer[0] = res + 1;
      answer[1] = share + 1;
      break;
    }
    set.add(w);
    lastChar = w[w.length - 1];
  }

  return answer;
}

console.log(
  solution(3, [
    "tank",
    "kick",
    "know",
    "wheel",
    "land",
    "dream",
    "mother",
    "robot",
    "tank",
  ])
);
console.log(
  solution(5, [
    "hello",
    "observe",
    "effect",
    "take",
    "either",
    "recognize",
    "encourage",
    "ensure",
    "establish",
    "hang",
    "gather",
    "refer",
    "reference",
    "estimate",
    "executive",
  ])
);
console.log(
  solution(2, ["hello", "one", "even", "never", "now", "world", "draw"])
);
