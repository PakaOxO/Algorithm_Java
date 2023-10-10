/**
 * BaekJoob_9934, 완전 이진 트리
 *  - 문제 분류: 트리, 구현
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/9934.txt").toString().split("\n");
  const DEPTH = +input[0];
  const visit = input[1].split(" ").map((item) => +item);
  const tree = Array.from({ length: DEPTH }, (_, idx) => Array.from({ length: idx + 1 }, () => 0));
  let answer = "";

  /* 메인 로직 */
  let pointer = 0;
  let level = 0;
  let count = 0;

  while (level >= 0 && count < Math.pow(2, DEPTH)) {
    if (level + 1 < DEPTH) {
      const [left, right] = [pointer * 2, pointer * 2 + 1];
      if (tree[level + 1][left] > 0 && tree[level + 1][right] > 0) {
        level--;
        pointer = Math.floor(pointer / 2);
      } else if (tree[level + 1][left] > 0) {
        tree[level][pointer] = visit[count++];
        pointer = right;
        level++;
      } else {
        pointer = left;
        level++;
      }
    } else {
      tree[level][pointer] = visit[count++];
      level--;
      pointer = Math.floor(pointer / 2);
    }
  }

  for (let i = 0; i < DEPTH; i++) {
    answer += tree[i].join(" ") + "\n";
  }

  /* 정답 반환 */
  return answer.trim();
};

console.log(solution());
