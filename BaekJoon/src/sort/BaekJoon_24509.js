/**
 * BaekJoon_24509, 상품의 주인은?
 *  - 문제 분류: 정렬, 구현
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/24509.txt").toString().trim().split("\n");
  const N = +input[0];
  const scores = [[], [], [], []];
  const v = Array.from({ length: N }, () => false);
  const answer = [];

  /* 메인 로직 */
  for (let i = 1; i <= N; i++) {
    const info = input[i].split(" ").map(Number);
    for (let j = 0; j < 4; j++) {
      scores[j].push([info[0], info[j + 1]]);
    }
  }

  for (let i = 0; i < 4; i++) {
    scores[i].sort((a, b) => {
      if (a[1] === b[1]) return a[0] - b[0];
      return b[1] - a[1];
    });

    for (let j = 0; j < N; j++) {
      if (v[scores[i][j][0] - 1]) continue;
      v[scores[i][j][0] - 1] = true;
      answer.push(scores[i][j][0]);
      break;
    }
  }

  /* 정답 반환 */
  return answer.join(" ");
};

console.log(solution());

