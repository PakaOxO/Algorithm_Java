/**
 * BaekJoon_2623, 음악 프로그램
 *    - 문제 분류: 위상 정렬
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/2623.txt").toString().trim().split("\n");
  const [N, M] = input[0].split(" ").map(Number);
  const adjList = Array.from({ length: N + 1 }, () => []);
  const count = new Array(N + 1).fill(0);
  const answer = [];

  /* 메인 로직 */
  for (let i = 1; i <= M; i++) {
    const [len, ...arr] = input[i].split(" ");
    let prev = +arr[0];

    for (let j = 1; j < +len; j++) {
      const next = +arr[j];
      adjList[prev].push(next);
      prev = next;
      count[next]++;
    }
  }

  // 위상정렬
  const q = [];
  for (let i = 1; i <= N; i++) {
    if (count[i] === 0) q.push(i);
  }

  while (q.length > 0) {
    const curr = q.shift();
    answer.push(curr);

    for (const next of adjList[curr]) {
      count[next]--;
      if (count[next] === 0) q.push(next);
    }
  }

  /* 정답 반환 */
  return answer.length < N ? 0 : answer.join("\n");
};

console.log(solution());

