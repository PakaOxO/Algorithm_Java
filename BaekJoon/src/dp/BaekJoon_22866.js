/**
 * BaekJoon_22866, 탑 보기
 *  - 문제 분류: 다이나믹 프로그래밍, 스택
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/22866.txt").toString().split("\n");
  const N = +input[0];
  const dp = Array.from({ length: N }, () => [0, -1]);
  const tower = input[1].split(" ").map((item) => +item);
  const answer = [];
  const INF = 100000;

  /* 메인 로직 */
  const stack = [];

  for (let i = N - 1; i >= 0; i--) {
    let top = stack.length - 1;
    while (top >= 0 && tower[stack[top]] <= tower[i]) {
      stack.pop();
      top--;
    }

    dp[i][1] = top >= 0 ? stack[top] : INF * 2;
    dp[i][0] += top + 1;

    stack.push(i);
  }

  while (stack.length > 0) stack.pop();

  for (let i = 0; i < N; i++) {
    let top = stack.length - 1;
    while (top >= 0 && tower[stack[top]] <= tower[i]) {
      stack.pop();
      top--;
    }

    dp[i][1] = top >= 0 ? (i - stack[top] <= dp[i][1] - i ? stack[top] : dp[i][1]) : dp[i][1];
    dp[i][0] += top + 1;

    stack.push(i);
  }

  for (let i = 0; i < N; i++) {
    answer.push(`${dp[i][0]}${dp[i][0] === 0 ? "" : " " + (dp[i][1] + 1)}`);
  }

  /* 정답 반환 */
  return answer.join("\n");
};

console.log(solution());

