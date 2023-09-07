/**
 * BaekJoon_15685, 드래곤 커브
 *    - 문제 분류 : 구현, 재귀
 */
const solution = () => {
  /* 변수 초기화 */
  const input = require("fs").readFileSync("./dev/stdin/15685.txt").toString().trim().split("\n");
  const N = +input[0];
  const map = Array.from({ length: 101 }, () => Array.from({ length: 101 }, () => false));
  const dir = [
    [1, 0],
    [0, -1],
    [-1, 0],
    [0, 1],
  ];
  let [minX, minY, maxX, maxY] = [100, 100, 0, 0];

  /* 메인 로직 */
  for (let i = 1; i <= N; i++) {
    const [x, y, d, g] = input[i].split(" ").map((item) => +item);
    makeDragonCurve(x, y, d, g);
  }

  return countsSquare();

  /**
   * 시작점(x, y)과 시작방향(d), 세대(g)를 입력받아 평면좌표 상에 드래곤 커브 생성
   */
  function makeDragonCurve(x, y, d, g) {
    const points = [];

    if (g < 1) {
      points.push([x, y, -1]);
      points.push([x + dir[d][0], y + dir[d][1], d]);
      map[x][y] = true;
      map[x + dir[d][0]][y + dir[d][1]] = true;

      refreshCoordArea(x, y);
      refreshCoordArea(x + dir[d][0], y + dir[d][1]);
    } else {
      points.push(...makeDragonCurve(x, y, d, g - 1));
      const len = points.length;
      [x, y] = [points[len - 1][0], points[len - 1][1]];
      refreshCoordArea(x, y);

      for (let i = len - 1; i > 0; i--) {
        const nextDir = rotate(points[i][2]);
        x += dir[nextDir][0];
        y += dir[nextDir][1];
        points.push([x, y, nextDir]);
        map[x][y] = true;
        refreshCoordArea(x, y);
      }
    }

    return points;
  }

  /**
   * 현재 방향(dir)이 주어졌을 때 시계 방향으로 90도 회전 시킨 방향을 반환
   */
  function rotate(dir) {
    return (dir + 1) % 4;
  }

  /**
   * 좌표상에 드래곤 커브로 만들어진 사각형의 개수 카운트
   */
  function countsSquare() {
    let count = 0;

    for (let x = minX; x < maxX; x++) {
      for (let y = minY; y < maxY; y++) {
        if (!map[x][y]) continue;
        if (map[x][y + 1] && map[x + 1][y] && map[x + 1][y + 1]) {
          count++;
        }
      }
    }
    return count;
  }

  /**
   * 좌표 x, y 최소/최대값 갱신
   */
  function refreshCoordArea(x, y) {
    minX = Math.min(minX, x);
    minY = Math.min(minY, y);
    maxX = Math.max(maxX, x);
    maxY = Math.max(maxY, y);
  }
};

console.log(solution());

