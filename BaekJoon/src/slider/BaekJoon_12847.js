/**
 * BaekJono_12847, 꿀 아르바이트
 *  - 문제 분류: 슬라이딩 윈도우
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/12847.txt").toString().trim().split("\n");
  const [N, M] = input[0].split(" ").map(Number);
  const payments = input[1].split(" ").map(Number);
  let length = 0;
  let sum = 0;
  let answer = 0;

  /* 메인 로직 */
  for (let i = 0; i < N; i++) {
    sum += payments[i];
    length++;
    while (length > M) {
      sum -= payments[i - --length];
    }

    answer = Math.max(answer, sum);
  }

  /* 정답 반환 */
  return answer;
};

console.log(solution());
