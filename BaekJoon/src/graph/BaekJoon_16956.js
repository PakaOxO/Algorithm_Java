/**
 * BaekJoon_16956, 늑대와 양
 *  - 문제 분류: 그래프 탐색
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/16956.txt").toString().trim().split("\n");
  const [N, M] = input[0].split(" ").map(Number);
  const map = [];
  const q = [];
  let flag = false;
  const drc = [
    [0, 1],
    [0, -1],
    [1, 0],
    [-1, 0],
  ];

  for (let i = 1; i <= N; i++) {
    const line = input[i].split("");
    const arr = [];
    for (let j = 0; j < M; j++) {
      arr.push(line[j]);
      if (line[j] === "S") {
        q.push([i - 1, j]);
      }
    }
    map.push(arr);
  }

  /* 메인 로직 */
  loop: for (let i = 0; i < q.length; i++) {
    const [r, c] = q[i];

    for (const [dr, dc] of drc) {
      const [nr, nc] = [r + dr, c + dc];
      if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;

      if (map[nr][nc] === "W") {
        flag = true;
        break loop;
      }

      if (map[nr][nc] === ".") {
        map[nr][nc] = "D";
      }
    }
  }

  /* 정답 반환 */
  if (flag) {
    return 0;
  } else {
    return `${1}\n${map.map((line) => line.join("")).join("\n")}`;
  }
};

console.log(solution());

