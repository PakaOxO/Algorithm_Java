/**
 * BaekJoon_2252, 줄 세우기
 *  - 문제 분류: 정렬
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/2252.txt").toString().trim().split("\n");
  const [N, M] = input[0].split(" ").map(Number);
  const counts = Array.from({ length: N + 1 }, () => 0);
  const adjList = Array.from({ length: N + 1 }, () => []);
  const answer = [];

  /* 메인 로직 */
  for (let i = 1; i <= M; i++) {
    const [small, big] = input[i].split(" ").map(Number);
    counts[big]++;
    adjList[small].push(big);
  }

  topologicSort();

  /* 정답 반환 */
  return answer.join(" ");

  // 위상 정렬
  function topologicSort() {
    const q = [];
    for (let i = 1; i <= N; i++) {
      if (counts[i] > 0) continue;
      q.push(i);
    }

    while (q.length > 0) {
      const curr = q.shift();
      answer.push(curr);
      for (const next of adjList[curr]) {
        counts[next]--;
        if (counts[next] === 0) {
          q.push(next);
        }
      }
    }
  }
};

console.log(solution());
