function solution(wallpaper) {
  const H = wallpaper.length;
  const W = wallpaper[0].length;
  const answer = new Array(4);
  answer[0] = H;
  answer[1] = W;
  answer[2] = answer[3] = 0;

  for (let i = 0; i < H; i++) {
    for (let j = 0; j < W; j++) {
      const char = wallpaper[i].charAt(j);
      if (char === "#") {
        answer[0] = Math.min(answer[0], i);
        answer[1] = Math.min(answer[1], j);
        answer[2] = Math.max(answer[2], i + 1);
        answer[3] = Math.max(answer[3], j + 1);
      }
    }
  }
  return answer;
}

console.log(solution([".#...", "..#..", "...#."]));
console.log(
  solution([
    "..........",
    ".....#....",
    "......##..",
    "...##.....",
    "....#.....",
  ])
);
console.log(
  solution([
    ".##...##.",
    "#..#.#..#",
    "#...#...#",
    ".#.....#.",
    "..#...#..",
    "...#.#...",
    "....#....",
  ])
);
console.log(solution(["..", "#."]));
