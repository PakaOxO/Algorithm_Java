function solution(lottos, win_nums) {
  const rank = [6, 6, 5, 4, 3, 2, 1];
  const hasNum = new Array(46).fill(false);

  let zCount = 0;
  for (const num of lottos) {
    hasNum[num] = true;
    if (num === 0) zCount++;
  }

  let min = 0;
  for (const num of win_nums) {
    if (hasNum[num]) min++;
  }

  return [rank[min + zCount], rank[min]];
}

console.log(solution([44, 1, 0, 0, 31, 25], [31, 10, 45, 1, 6, 19]));
console.log(solution([0, 0, 0, 0, 0, 0], [38, 19, 20, 40, 15, 25]));
console.log(solution([45, 4, 35, 20, 3, 9], [20, 9, 3, 45, 4, 35]));
