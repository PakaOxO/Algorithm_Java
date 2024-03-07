/**
 * BaekJoon_8983, 사냥꾼
 *  - 문제 분류: 그리디, 정렬
 *  - 시간 복잡도: 동물, 사대 위치 정렬(MlogM + NlogN)
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/8983.txt").toString().trim().split("\n");
  const [M, N, L] = input[0].split(" ").map(Number);
  const shotPoints = input[1].split(" ").map(Number);
  const animals = [];
  let answer = 0;

  for (let i = 2; i <= N + 1; i++) {
    animals.push(input[i].split(" ").map(Number));
  }
  shotPoints.sort((a, b) => a - b);
  animals.sort((a, b) => a[0] - b[0]);

  /* 메인 로직 */
  let [sPointer, aPointer] = [0, 0];
  while (aPointer < N) {
    while (
      sPointer + 1 < M &&
      Math.abs(shotPoints[sPointer + 1] - animals[aPointer][0]) < Math.abs(shotPoints[sPointer] - animals[aPointer][0])
    ) {
      sPointer++;
    }

    if (Math.abs(shotPoints[sPointer] - animals[aPointer][0]) + animals[aPointer][1] <= L) {
      answer++;
    }
    aPointer++;
  }

  /* 정답 반환 */
  return answer;
};

console.log(solution());

