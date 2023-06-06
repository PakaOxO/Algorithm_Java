const solution = (begin, target, words) => {
  const len = words.length;
  const isVisited = new Array(len).fill(false);
  let answer = len + 1;

  const dfs = (word, depth) => {
    if (depth > len) return;
    if (word === target) {
      answer = Math.min(answer, depth);
      return;
    }

    for (let i = 0; i < len; i++) {
      if (words[i].length !== word.length) continue;
      if (isVisited[i]) continue;

      let count = 0;
      const wl = word.length;
      for (let j = 0; j < wl; j++) {
        if (word[j] === words[i][j]) count++;
      }
      if (count < wl - 1) continue;
      isVisited[i] = true;
      dfs(words[i], depth + 1);
      isVisited[i] = false;
    }
  };

  dfs(begin, 0);
  return answer > len ? 0 : answer;
};

console.log(solution("hit", "cog", ["hot", "dot", "dog", "lot", "log", "cog"]));
console.log(solution("hit", "cog", ["hot", "dot", "dog", "lot", "log"]));
