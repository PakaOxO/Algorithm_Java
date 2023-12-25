/**
 * BaekJoon_14567, 선수 과목
 *  - 문제 분류: 위상정렬
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/14567.txt").toString().trim().split("\n");
  const [N, M] = input[0].split(" ").map(Number);
  const counts = new Array(N + 1).fill(0);
  const adjList = Array.from({ length: N + 1 }, () => []);
  const answer = new Array(N + 1).fill(0);

  /* 메인 로직 */
  for (let i = 1; i <= M; i++) {
    const [from, to] = input[i].split(" ").map(Number);
    adjList[from].push(to);
    counts[to]++;
  }
  topologicSort();

  /* 정답 반환 */
  return answer.slice(1).join(" ");

  // 위상 정렬
  function topologicSort() {
    const q = [];
    for (let i = 1; i <= N; i++) {
      if (counts[i] > 0) continue;
      q.push([i, 1]);
    }

    while (q.length > 0) {
      const [curr, semester] = q.shift();
      answer[curr] = semester;

      for (const next of adjList[curr]) {
        counts[next]--;
        if (counts[next] === 0) {
          q.push([next, semester + 1]);
        }
      }
    }
  }
};

console.log(solution());

