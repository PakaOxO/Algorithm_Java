const solution = (dirs) => {
  const drc = [
    [1, 0],
    [-1, 0],
    [0, 1],
    [0, -1],
  ];
  const dict = {
    U: 0,
    D: 1,
    R: 2,
    L: 3,
  };

  // 격자의 범위는 -5 ~ 5이므로 +5를 해서 범위를 0 ~ 10으로 조정
  let [r, c] = [5, 5];
  const isVisited = [];
  for (let i = 0; i < 11; i++) {
    isVisited.push([]);
    for (let j = 0; j < 11; j++) {
      const arr = new Array(4).fill(false);
      isVisited[i].push(arr);
    }
  }

  const len = dirs.length;
  let answer = 0;
  for (let i = 0; i < len; i++) {
    const dir = dict[dirs[i]];
    const [nr, nc] = [r + drc[dir][0], c + drc[dir][1]];

    if (nr < 0 || nc < 0 || nr > 10 || nc > 10) continue;

    if (!isVisited[nr][nc][dir]) {
      isVisited[nr][nc][dir] = true;
      isVisited[r][c][dir % 2 === 0 ? dir + 1 : dir - 1] = true; // 길의 반대방향도 방문처리
      answer++;
    }
    [r, c] = [nr, nc];
  }
  return answer;
};

console.log(solution("ULURRDLLU"));
console.log(solution("LULLLLLLU"));
console.log(solution("LLLLLRRRRRLLLLL"));
console.log(solution("RRRRRLLLLL"));
