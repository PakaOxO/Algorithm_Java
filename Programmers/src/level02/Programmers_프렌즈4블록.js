const solution = (m, n, board) => {
  let answer = 0;
  const board_arr = board.map((line) => line.split(""));
  const drc = [
    [0, 1],
    [1, 0],
    [1, 1],
  ];

  const swap = (p1, p2) => {
    const temp = board_arr[p1[0]][p1[1]];
    board_arr[p1[0]][p1[1]] = board_arr[p2[0]][p2[1]];
    board_arr[p2[0]][p2[1]] = temp;
  };

  const remove = () => {
    let isRemoved = false;
    const pos = [];
    for (let i = 0; i < m - 1; i++) {
      for (let j = 0; j < n - 1; j++) {
        const type = board_arr[i][j];
        if (type === " ") continue;
        let cnt = 1;
        for (let k = 0; k < drc.length; k++) {
          const [nr, nc] = [i + drc[k][0], j + drc[k][1]];
          if (board_arr[nr][nc] === type) cnt++;
        }
        if (cnt === 4) {
          pos.push([i, j]);
        }
      }
    }

    while (pos.length > 0) {
      isRemoved = true;

      const [r, c] = pos.pop();
      board_arr[r][c] = " ";
      answer++;
      for (let j = 0; j < drc.length; j++) {
        const [nr, nc] = [r + drc[j][0], c + drc[j][1]];
        if (board_arr[nr][nc] !== " ") {
          answer++;
          board_arr[nr][nc] = " ";
        }
      }
    }

    return isRemoved;
  };

  const down = () => {
    for (let i = m - 1; i >= 0; i--) {
      for (let j = n - 1; j >= 0; j--) {
        if (board_arr[i][j] !== " ") continue;
        let k = i - 1;
        while (k >= 0) {
          if (board_arr[k][j] !== " ") {
            swap([i, j], [k, j]);
            break;
          }
          k--;
        }
      }
    }
  };

  let flag = true;
  while (flag) {
    if (!remove()) {
      flag = false;
    } else {
      down();
    }
  }
  return answer;
};

console.log(solution(4, 5, ["CCBDE", "AAADE", "AAABF", "CCBBF"]));
console.log(
  solution(6, 6, ["TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"])
);
