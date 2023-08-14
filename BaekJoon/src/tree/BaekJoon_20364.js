/**
 * BaekJoon_20364, 부동산 다툼
 *    1. 문제 분류 : 트리, 재귀
 *    2. 접근 방법
 *      - 부모에서 아래로 내려가는건 방향을 모르니 안될 거 같고..
 *      - 자식에서 부모로 재귀를 통해 올라가보자
 *        -> 올라가다 방문한 노드를 만나면 해당 노드를 저장하면서 올라간다
 *        -> 마지막으로 저장된 노드가 내려가면서 처음 만나는 점유된 땅
 *        -> 자식에서 올라갈 때, 맨 처음 위치가 점유된 땅이 아니면 해당 땅 visited 체크
 */
const solution = () => {
  /* 변수 초기화 */
  const input = require("fs").readFileSync("./dev/stdin/20364.txt").toString().trim().split("\n");
  const [N, Q] = input[0].split(" ").map((item) => +item);
  const v = Array.from({ length: N + 1 }, () => false);
  let answer = [];

  /** 메인 로직 */
  for (let i = 1; i <= Q; i++) {
    const xi = +input[i];
    answer.push(findParent(xi, xi, 0)[2]);
  }

  return answer.join("\n");

  /* 부모 노드로 이동 */
  function findParent(x, y, z) {
    if (x === 0) return [0, 0, z];
    if (v[x]) return findParent(~~(x / 2), y, x);
    if (x === y) {
      v[x] = true;
    }
    return findParent(~~(x / 2), y, z);
  }
};

console.log(solution());

