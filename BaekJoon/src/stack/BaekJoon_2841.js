/**
 * BaekJoon_2841, 외계인의 기타 연주
 *  - 문제 분류: 자료구조, 스택
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/2841.txt").toString().trim().split("\n");
  const [N, _] = input[0].split(" ").map(Number);
  const stack = Array.from({ length: 7 }, () => []);
  let answer = 0;

  /* 메인 로직 */
  for (let i = 1; i <= N; i++) {
    const [s, p] = input[i].split(" ").map(Number);
    let top = stack[s].length - 1;
    while (top >= 0 && stack[s][top] > p) {
      stack[s].pop();
      top--;
      answer++;
    }

    if (top >= 0 && stack[s][top] === p) {
      continue;
    }
    answer++;
    stack[s].push(p);
  }

  /* 정답 반환 */
  return answer;
};

console.log(solution());

