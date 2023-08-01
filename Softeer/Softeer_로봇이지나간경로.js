/**
 * Softeer_로봇이 지나간 경로
 *  1. 문제 분류 : 그래프 탐색
 *  2. 접근 방법
 *     - 일단 NXM 지도를 탐색하면서 #을 만나면 dfs 탐색을 시작해 끝의 #을 찾자!
 *     - 끝의 #을 시작점으로 dfs 탐색을 다시 해보자
 *     - 시작점을 찾았다면...
 *        - 시작점을 기준으로 dfs 시작
 *        - 앞으로 두칸 전진 가능하면 두칸을 방문 처리후 다음 dfs로 넘어감
 *        - 전진이 불가하면, 왼/오를 바라본 뒤 #이 있는지 판단해서 방향 전환(findNextDir)
 *        - 전환된 방향을 기준으로 다시 dfs 탐색
 *        - 만약 왼/오를 바라봤는데도 갈데가 없으면 dfs stop
 */
const solution = () => {
  const rl = require("readline").createInterface({
    input: process.stdin,
    output: process.stdout,
  });

  const lines = [];

  /* 변수 초기화 */
  const ansArr = [];
  let routes = "";
  let [N, M] = [0, 0];
  const map = [];
  let start = [0, 0];
  let v = null;
  const drc = [
    [-1, 0],
    [0, 1],
    [1, 0],
    [0, -1],
  ];
  const dirMark = ["^", ">", "v", "<"];

  rl.on("line", (input) => {
    lines.push(input.trim());
  });

  rl.on("close", () => {
    /* 메인 로직 */
    [N, M] = lines[0].split(" ").map((item) => +item);
    for (let i = 1; i <= N; i++) {
      map.push(lines[i].split(""));
    }

    v = Array.from({ length: N }, () => Array.from({ length: M }, () => false));
    loop: for (let i = 0; i < N; i++) {
      for (let j = 0; j < M; j++) {
        if (map[i][j] !== "#") continue;
        v[i][j] = true;
        findStart(i, j, 0);
        break loop;
      }
    }

    start[2] = (start[2] + 2) % 4;
    v = Array.from({ length: N }, () => Array.from({ length: M }, () => false));
    v[start[0]][start[1]] = true;
    dfs(start[0], start[1], start[2]);

    ansArr.push(`${start[0] + 1} ${start[1] + 1}`);
    ansArr.push(dirMark[start[2]]);
    ansArr.push(routes);

    console.log(ansArr.join("\n"));
    process.exit();
  });

  /* 메서드 */
  function findStart(r, c, dir) {
    start = [r, c, dir];

    for (let i = 0; i < drc.length; i++) {
      const [nr, nc] = [r + drc[i][0], c + drc[i][1]];
      if (nr < 0 || nc < 0 || nr >= N || nc >= M || map[nr][nc] === "." || v[nr][nc]) continue;

      v[nr][nc] = true;
      findStart(nr, nc, i);
    }
  }

  function dfs(r, c, dir) {
    const f1 = [r + drc[dir][0], c + drc[dir][1]];
    const f2 = [f1[0] + drc[dir][0], f1[1] + drc[dir][1]];
    let flag = false;
    if (f1[0] < 0 || f1[1] < 0 || f1[0] >= N || f1[1] >= M || map[f1[0]][f1[1]] === "." || v[f1[0]][f1[1]]) flag = true;
    if (f2[0] < 0 || f2[1] < 0 || f2[0] >= N || f2[1] >= M || map[f2[0]][f2[1]] === "." || v[f2[0]][f2[1]]) flag = true;

    if (!flag) {
      v[f1[0]][f1[1]] = true;
      v[f2[0]][f2[1]] = true;
      routes += "A";
      dfs(f2[0], f2[1], dir);
    } else {
      const nextDir = findNextDir(r, c, dir);
      if (nextDir[0] < 0) return;
      routes += nextDir[1];
      dfs(r, c, nextDir[0]);
    }
  }

  function findNextDir(r, c, dir) {
    const dir1 = (dir - 1 + 4) % 4;
    const dir2 = (dir + 1) % 4;

    const [nr1, nc1] = [r + drc[dir1][0], c + drc[dir1][1]];
    if (nr1 >= 0 && nr1 < N && nc1 >= 0 && nc1 < M && map[nr1][nc1] === "#" && !v[nr1][nc1]) {
      return [dir1, "L"];
    }
    const [nr2, nc2] = [r + drc[dir2][0], c + drc[dir2][1]];
    if (nr2 >= 0 && nr2 < N && nc2 >= 0 && nc2 < M && map[nr2][nc2] === "#" && !v[nr2][nc2]) {
      return [dir2, "R"];
    }
    return [-1, "X"];
  }
};

solution();
