/**
 * BaekJoon_15723, n단 논법
 *  - 문제 분류: 그래프 탐색
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/15723.txt").toString().trim().split("\n");
  const N = +input[0];
  let parent = Array.from({ length: 26 }, () => []);
  const answer = [];

  /* 메인 로직 */
  for (let i = 1; i <= N; i++) {
    const [from, to] = input[i].split(" is ");
    const [j, k] = [findCode(from), findCode(to)];
    parent[k].push(j);
  }

  const M = +input[N + 1];
  for (let i = N + 2; i < N + M + 2; i++) {
    const [from, to] = input[i].split(" is ");
    const [j, k] = [findCode(from), findCode(to)];
    const v = Array.from({ length: 26 }, () => false);
    const q = [k];
    let flag = false;
    v[k] = true;

    while (q.length > 0) {
      const curr = q.shift();
      for (const next of parent[curr]) {
        if (v[next]) continue;
        if (next === j) {
          flag = true;
          break;
        }
        v[next] = true;
        q.push(next);
      }
    }

    answer.push(flag ? "T" : "F");
  }

  /* 정답 반환 */
  return answer.join("\n");

  // findCode
  function findCode(char) {
    return char.charCodeAt(0) - 97;
  }
};

console.log(solution());

