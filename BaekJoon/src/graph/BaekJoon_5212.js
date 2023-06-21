const solution = () => {
  /* 초기 변수 */
  let [R, C] = [0, 0];
  const map = [];
  const queue = [];
  const drc = [
    [0, 1],
    [0, -1],
    [1, 0],
    [-1, 0],
  ];
  let answer = "";

  /* 입력 */
  const fs = require("fs");
  const input = fs.readFileSync("./dev/stdin/5212.txt").toString().split("\n");
  [R, C] = input[0].split(" ").map((item) => +item);
  for (let i = 0; i < R; i++) {
    map.push(input[i + 1].trim().split(""));
  }

  /* 50년 뒤 지도 */
  const after50Years = () => {
    for (let i = 0; i < R; i++) {
      for (let j = 0; j < C; j++) {
        if (map[i][j] !== "X") continue;
        let cnt = 0;

        for (let k = 0; k < 4; k++) {
          const nr = i + drc[k][0];
          const nc = j + drc[k][1];
          if (nr < 0 || nc < 0 || nr >= R || nc >= C || map[nr][nc] === ".") {
            cnt++;
          }
        }

        if (cnt >= 3) {
          queue.push([i, j]);
        }
      }
    }

    while (queue.length > 0) {
      const [r, c] = queue.pop();
      map[r][c] = ".";
    }
  };

  /* 지도 여백 제거 */
  const delWhiteSpace = () => {
    let [minR, maxR, minC, maxC] = [R, 0, C, 0];

    for (let i = 0; i < R; i++) {
      for (let j = 0; j < C; j++) {
        if (map[i][j] === "X") {
          minR = Math.min(minR, i);
          maxR = Math.max(maxR, i);
          minC = Math.min(minC, j);
          maxC = Math.max(maxC, j);
        }
      }
    }

    for (let i = 0; i < R; i++) {
      if (i < minR || i > maxR) continue;
      for (let j = 0; j < C; j++) {
        if (j < minC || j > maxC) continue;
        answer += map[i][j];
      }
      answer += "\n";
    }
  };

  /* 메인 로직 */
  after50Years();
  delWhiteSpace();
  return answer;
};

console.log(solution());
