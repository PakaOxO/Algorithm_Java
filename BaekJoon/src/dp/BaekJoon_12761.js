/**
 * BaekJoon_12761, 돌다리
 *    1. 문제 분류 : dp
 *    2. 접근 방법
 *      -
 */
const solution = () => {
  /* 변수 초기화 */
  const input = require("fs").readFileSync("./dev/stdin/12761.txt").toString().trim();
  const [A, B, N, M] = input.split(" ").map((item) => +item);
  const INF = 100000;
  const dp = Array.from({ length: INF + 1 }, () => INF);
  const q = [N];
  dp[N] = 0;

  /* 메인 로직 */
  let pointer = 0;
  while (pointer < q.length) {
    const pos = q[pointer++];
    jump(pos, A);
    jump(pos, B);
    move(pos, A);
    move(pos, B);
    move(pos, 1);
  }

  return dp[M];

  /* 좌우로 dist만큼 이동 */
  function move(pos, dist) {
    if (pos - dist >= 0 && dp[pos - dist] > dp[pos] + 1) {
      dp[pos - dist] = dp[pos] + 1;
      q.push(pos - dist);
    }

    if (pos + dist <= INF && dp[pos + dist] > dp[pos] + 1) {
      dp[pos + dist] = dp[pos] + 1;
      q.push(pos + dist);
    }
  }

  /* X배의 위치로 점프 */
  function jump(pos, x) {
    if (pos * x <= INF && dp[pos * x] > dp[pos] + 1) {
      dp[pos * x] = dp[pos] + 1;
      q.push(pos * x);
    }
  }
};

console.log(solution());
