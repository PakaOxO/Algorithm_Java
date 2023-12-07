/**
 * BaekJoon_15683, 감시
 *  - 문제 분류: 구현
 */
const solution = () => {
  /* 변수 관리 */
  const input = require('fs').readFileSync('./dev/stdin/15683.txt').toString().trim().split('\n');
  const [N, M] = input[0].split(' ').map(Number); // N,M 최대 값: 8, 카메라 최대 개수: 8 -> 카메라 방향 최대 -> 4^8, 약 6.5만
  const map = Array.from({ length: N }, () => []);
  const cameras = [];
  const cameraDir = [0, 4, 2, 4, 4, 1];
  const drc = [[-1, 0], [0, 1], [1, 0], [0, -1]];
  let answer = N*M;

  /* 메인 로직 */
  for (let i=0; i<N; i++) {
    const line = input[i + 1].split(' ').map(Number);
    for (let j=0; j<M; j++) {
      map[i].push(line[j]);
      if (map[i][j] > 0 && map[i][j] < 6) {
        cameras.push([i, j, 0]);
      }
    }
  }

  dfs(0, 0);

  /* 정답 반환 */
  return answer;

  /**** 메서드 ****/
  // dfs
  function dfs(depth) {
    if (depth === cameras.length) {
      let count = 0;
      for (let i=0; i<N; i++) {
        for (let j=0; j<M; j++) {
          if (map[i][j] === 0) count++;
        }
      }
      answer = Math.min(answer, count);
      return;
    }

    const [r, c] = cameras[depth];
    const type = map[r][c] % 10;

    for (let i=0; i<cameraDir[type]; i++) {
      viewCameras(r, c, i, true);
      dfs(depth + 1);
      viewCameras(r, c, i, false);
    }
  }

  // viewCameras
  function viewCameras(r, c, dir, isView) {
    const type = map[r][c] % 10;

    if (type === 1) viewCamera01(r, c, dir, isView);
    else if (type === 2) viewCamera02(r, c, dir, isView);
    else if (type === 3) viewCamera03(r, c, dir, isView);
    else if (type === 4) viewCamera04(r, c, dir, isView);
    else if (type === 5) viewCamera05(r, c, dir, isView);
  }

  // camera 1
  function viewCamera01(r, c, dir, isView) {
    view(r, c, dir, isView);
  }

  // camera 2
  function viewCamera02(r, c, dir, isView) {
    // 정면
    view(r, c, dir, isView);
    // 뒤
    view(r, c, (dir + 2) % 4, isView);
  }

  // camera 3
  function viewCamera03(r, c, dir, isView) {
    // 정면
    view(r, c, dir, isView);
    // 우
    view(r, c, (dir + 1) % 4, isView);
  }

  // camera 4
  function viewCamera04(r, c, dir, isView) {
    // 정면
    view(r, c, dir, isView);
    // 좌
    view(r, c, (dir - 1 + 4) % 4, isView);
    // 우
    view(r, c, (dir + 1) % 4, isView);
  }

  // camera 5
  function viewCamera05(r, c, dir, isView) {
    // 정면
    view(r, c, dir, 5, isView);
    // 좌
    view(r, c, (dir - 1 + 4) % 4, isView);
    // 우
    view(r, c, (dir + 1) % 4, isView);
    // 뒤
    view(r, c, (dir + 2) % 4, isView);
  }

  // view
  function view(r, c, dir, isView) {
    let [nr, nc] = [r, c];

    while (!(nr < 0 || nr >= N || nc < 0 || nc >= M)) {
      if (map[nr][nc] === 6) break;
      map[nr][nc] += isView ? 10 : -10;
      [nr, nc] = [nr + drc[dir][0], nc + drc[dir][1]];
    }
  }
}

console.log(solution());