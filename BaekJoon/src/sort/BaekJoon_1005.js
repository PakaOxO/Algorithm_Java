/**
 * BaekJoon_1005, ACM Craft
 *  - 문제 분류: 위상 정렬
 */
const solution = () => {
  /* 메인 로직 */
  const input = require("fs").readFileSync("./dev/stdin/1005.txt").toString().trim().split("\n");
  const T = +input[0];
  let pointer = 1;
  const answer = [];

  /* 메인 로직 */
  for (let tc = 1; tc <= T; tc++) {
    const [N, K] = input[pointer++].split(" ");
    acmCraft(+N, +K);
  }

  /* 정답 반환 */
  return answer.join("\n");

  // acm craft(위상 정렬)
  function acmCraft(n, k) {
    const time = [0, ...input[pointer++].split(" ")];
    const adjList = Array.from({ length: n + 1 }, () => []);
    const count = new Array(n + 1).fill(0);
    const dp = new Array(n + 1).fill(0);

    for (let i = 0; i < k; i++) {
      const [x, y] = input[pointer++].split(" ");
      count[+y]++;
      adjList[+x].push(+y);
    }

    const target = +input[pointer++];

    // 위상 정렬 시작
    const q = [];

    for (let i = 1; i <= n; i++) {
      if (count[i] > 0) continue;
      q.push(i);
      dp[i] = +time[i];
    }

    while (q.length > 0) {
      const curr = q.shift();
      if (curr === target) break;

      for (const next of adjList[curr]) {
        count[next]--;
        dp[next] = Math.max(dp[next], dp[curr] + +time[next]);

        if (count[next] === 0) {
          q.push(next);
        }
      }
    }

    answer.push(dp[target]);
  }
};

console.log(solution());
