function solution(k, tangerine) {
  const map = new Map();
  const cnt = [];

  tangerine.forEach((t) => {
    if (!map.has(t)) {
      map.set(t, cnt.length);
      cnt.push(1);
    } else {
      cnt[map.get(t)]++;
    }
  });
  cnt.sort((a, b) => b - a);

  let answer = 0;
  for (let i = 0; i < cnt.length; i++) {
    if (k <= 0) break;
    k -= cnt[i];
    answer++;
  }

  return answer;
}

console.log(solution(6, [1, 3, 2, 5, 4, 5, 2, 3]));
console.log(solution(4, [1, 3, 2, 5, 4, 5, 2, 3]));
console.log(solution(2, [1, 1, 1, 1, 2, 2, 2, 3]));
