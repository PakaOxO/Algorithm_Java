/**
 * BaekJoon_11000, 강의실 배정
 *  - 문제 분류: 정렬, 그리디
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/11000.txt").toString().trim().split("\n");
  const N = +input[0];
  const c = [];
  let count = 0;
  let answer = 0;

  /* 메인 로직 */
  for (let i = 1; i <= N; i++) {
    const [s, e] = input[i].split(" ");
    c.push([s, 1]);
    c.push([e, -1]);
  }

  c.sort((a, b) => {
    return a[0] - b[0];
  });

  c.push([-1, 0]);

  for (let i = 0; i < N * 2; i++) {
    count += c[i][1];
    if (i + 1 <= N * 2 && c[i][0] !== c[i + 1][0]) {
      answer = Math.max(answer, count);
    }
  }

  /* 정답 반환 */
  return answer;
};

console.log(solution());

