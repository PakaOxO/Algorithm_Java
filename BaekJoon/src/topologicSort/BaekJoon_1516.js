/**
 * BaekJoon_1516, 게임 개발
 *  - 문제 분류: 위상 정렬
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/1516.txt").toString().trim().split("\n");
  const N = +input[0];
  const adjList = Array.from({ length: N + 1 }, () => []);
  const time = new Array(N + 1);
  const count = new Array(N + 1);
  const dp = new Array(N + 1);
  const q = [];

  /* 메인 로직 */
  for (let i = 1; i <= N; i++) {
    const [t, ...prevs] = input[i].split(" ");
    time[i] = +t;

    for (const prev of prevs) {
      if (+prev > 0) {
        adjList[+prev].push(i);
      }
    }

    count[i] = prevs.length - 1;
    if (count[i] === 0) {
      q.push(i);
      dp[i] = time[i];
    } else {
      dp[i] = 0;
    }
  }

  // 위상정렬 시작
  while (q.length > 0) {
    const curr = q.shift();

    for (const next of adjList[curr]) {
      count[next]--;
      dp[next] = Math.max(dp[next], dp[curr] + time[next]);
      if (count[next] === 0) {
        q.push(next);
      }
    }
  }

  /* 정답 반환 */
  return dp.slice(1).join("\n");
};

console.log(solution());

