/**
 * BaekJoon_1327, 소트 게임
 *    1. 문제 분류 : 완전 탐색, 그래프 탐색
 *    2. 접근 방법
 *      - 길이가 짧은 문자열이라 완전 탐색이 가능..
 *      - 현재 문자열을 큐에 넣고 bfs를 돌리면서
 *        -> 꺼낸 문자열에서 뒤집을 수 있는 영역을 뒤집어 큐에 새로 넣음
 *        -> 뒤집었는데 이미 만난 문자열인지 체크(set 사용)
 *        -> 정렬된 문자열과 같아지면 해당 depth를 반환
 */
const solution = () => {
  /* 변수 초기화 */
  const input = require("fs").readFileSync("./dev/stdin/1327.txt").toString().trim().split("\n");
  const [N, K] = input[0].split(" ").map((item) => +item);
  const str = input[1].split(" ").join("");
  const sorted = input[1].split(" ").sort().join("");

  /* 정답 반환 */
  return bfs(str);

  /* bfs */
  function bfs(str) {
    if (str === sorted) return 0;
    const q = [[str, 0]];
    const set = new Set();
    set.add(str);

    while (q.length > 0) {
      const [curr, depth] = q.shift();
      for (let i = 0; i <= N - K; i++) {
        const front = curr.substr(0, i);
        const mid = curr.substr(i, K);
        const end = curr.substr(i + K);
        const next = front + mid.split("").reverse().join("") + end;

        if (set.has(next)) continue;
        if (next === sorted) {
          return depth + 1;
        }
        set.add(next);
        q.push([next, depth + 1]);
      }
    }
    return -1;
  }
};

console.log(solution());

