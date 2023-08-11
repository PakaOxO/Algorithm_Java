/**
 * Softeer_사물인식 최소 면적 산출 프로그램
 *      1. 문제 분류 : 조합, 백트래킹
 *      2. 접근 방법
 *          - 처음에 사각형을 만들기 위한 두 점을 뽑는다고 생각해서 계속 틀림
 *            -> 두 점이 사각형의 꼭지점이 아닐 수도 있기 때문
 *          - K개의 색을 가진 점들을 각 색(1 ~ K)별로 묶어 배열에 넣은 뒤
 *            -> 각 인덱스 1 ~ K 별로 1개씩 뽑자.
 *            -> K개를 뽑으면서 minX, minY, maxX, maxY 갱신 -> 뽑은 점들이 모두 포함되기 위한 최소 사각형 넓이
 *            -> 만약 뽑으면서 생기는 최소 넓이가 이전에 갱신된 최소 넓이(answer)보다 커졌다면 return
 */
const solution = () => {
  /* 점의 데이터를 표현하기 위해 클래스 선언 */
  class Point {
    constructor(x, y) {
      this.x = x;
      this.y = y;
    }
  }

  const rl = require("readline").createInterface({
    input: process.stdin,
    output: process.stdout,
  });

  /* 변수 초기화 */
  const input = [];
  let [N, K] = [0, 0];
  let points = null;
  let answer = 987654321;

  rl.on("line", (i) => {
    input.push(i.trim());
  });

  rl.on("close", () => {
    /* 입력값 할당 */
    [N, K] = input[0].split(" ").map((item) => +item);
    points = Array.from({ length: K + 1 }, () => []);
    for (let i = 0; i < N; i++) {
      const [x, y, color] = input[i + 1].split(" ").map((item) => +item);
      points[color].push(new Point(x, y));
    }

    /* 메인 로직 */
    combination([], 1000, -1000, 1000, -1000);
    console.log(answer);
    process.exit();
  });

  /* 사각형을 만들기 위해 K개의 점을 뽑는 조합 : 백트래킹 필요 */
  function combination(comb, minX, maxX, minY, maxY) {
    if (K === 1) {
      answer = 0;
      return;
    }

    const size = (maxX - minX) * (maxY - minY);
    if (size >= answer) return;

    if (comb.length === K) {
      answer = size;
      return;
    }

    const depth = comb.length + 1;
    for (let i = 0; i < points[depth].length; i++) {
      const nextMinX = Math.min(minX, points[depth][i].x);
      const nextMaxX = Math.max(maxX, points[depth][i].x);
      const nextMinY = Math.min(minY, points[depth][i].y);
      const nextMaxY = Math.max(maxY, points[depth][i].y);
      combination([...comb, points[depth][i]], nextMinX, nextMaxX, nextMinY, nextMaxY);
    }
  }
};

solution();
