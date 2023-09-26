/**
 * BaekJoon_1138, 한 줄로 서기
 *  - 문제 분류 : 조합, 백트래킹
 */
const solution = () => {
  /* 변수 초기화 */
  const input = require("fs").readFileSync("./dev/stdin/1138.txt").toString().split("\n");
  const N = +input[0];
  const arr = input[1].split(" ").map((item) => +item);
  const comb = Array.from({ length: N }, () => 0);
  const v = Array.from({ length: N }, () => false);
  let answer = null;

  /* 메인 로직 */
  dfs(0);

  /* 정답 반환 */
  return answer;

  /**
   * 조합 탐색
   */
  function dfs(depth) {
    if (depth > 0) {
      const flag = check(depth);
      if (!flag) return;
    }

    if (depth === N) {
      answer = comb.join(" ");
      return;
    }

    for (let i = 1; i <= N; i++) {
      if (v[i]) continue;
      v[i] = true;
      comb[depth] = i;
      dfs(depth + 1);
      v[i] = false;
    }
  }

  /**
   * depth까지 선택된 줄 탐색
   */
  function check(depth) {
    for (let i = 0; i < depth; i++) {
      let count = 0;
      for (let j = 0; j < i; j++) {
        if (comb[i] < comb[j]) count++;
      }
      if (count !== arr[comb[i] - 1]) return false;
    }
    return true;
  }
};

console.log(solution());

