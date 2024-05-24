/**
 * BaekJoon_31872, 강의실
 *  - 문제 분류: 그리디
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/31872.txt").toString().trim().split("\n");
  const [N, K] = input[0].split(" ").map(Number);
  const classroom = input[1].split(" ").map(Number);
  let answer = 0;

  /* 메인 로직 */
  classroom.sort((a, b) => b - a);
  for (let i = 0; i < N - 1; i++) {
    classroom[i] = classroom[i] - classroom[i + 1];
  }

  classroom.sort((a, b) => b - a);

  for (let i = 0; i < N; i++) {
    if (i < K) continue;
    answer += classroom[i];
  }

  /* 정답 반환 */
  return answer;
};

console.log(solution());

