const solution = (word) => {
  const AEIOU = ["A", "E", "I", "O", "U"];

  const comb = [];
  let flag = false;
  let answer = 0;

  const dfs = (depth) => {
    if (depth > 5) return;
    if (depth > 0) {
      const w = comb.join("");
      answer++;
      if (w === word) {
        flag = true;
      }
    }

    for (let i = 0; i < AEIOU.length; i++) {
      if (flag) break;

      comb.push(AEIOU[i]);
      dfs(depth + 1);
      comb.pop();
    }
  };
  dfs(0, false);

  return answer;
};

console.log(solution("AAAAE"));
console.log(solution("AAAE"));
console.log(solution("I"));
console.log(solution("EIO"));
