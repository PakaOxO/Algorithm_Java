function solution(maps) {
  const [N, M] = [maps.length, maps[0].length];
  const isVisited = Array.from(Array(N), () => new Array(M).fill(false));
  const drc = [
    [0, 1],
    [1, 0],
    [-1, 0],
    [0, -1],
  ];

  let pointer = 0,
    len = 1;
  const arr = [[0, 0, 1]];
  isVisited[0][0] = true;

  while (pointer < len) {
    const curr = arr[pointer++];
    for (let i = 0; i < 4; i++) {
      const [nr, nc] = [curr[0] + drc[i][0], curr[1] + drc[i][1]];
      if (
        nr < 0 ||
        nc < 0 ||
        nr >= N ||
        nc >= M ||
        maps[nr][nc] === 0 ||
        isVisited[nr][nc]
      )
        continue;
      if (nr === N - 1 && nc === M - 1) return curr[2] + 1;
      arr.push([nr, nc, curr[2] + 1]);
      isVisited[nr][nc] = true;
      len++;
    }
  }
  return -1;
}

console.log(
  solution([
    [1, 0, 1, 1, 1],
    [1, 0, 1, 0, 1],
    [1, 0, 1, 1, 1],
    [1, 1, 1, 0, 1],
    [0, 0, 0, 0, 1],
  ])
);

console.log(
  solution([
    [1, 0, 1, 1, 1],
    [1, 0, 1, 0, 1],
    [1, 0, 1, 1, 1],
    [1, 1, 1, 0, 0],
    [0, 0, 0, 0, 1],
  ])
);
