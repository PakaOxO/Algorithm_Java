/**
 * BaekJoon_24954, 물약 구매
 *  - 문제 분류: 완전 탐색
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/24954.txt").toString().trim().split("\n");
  const N = +input[0];
  const prices = input[1].split(" ").map(Number);
  const discounts = Array.from({ length: N }, () => []);
  const v = Array.from({ length: N }, () => false);
  let pointer = 2;
  let answer = prices.reduce((acc, base) => acc + base, 0);

  for (let i = 0; i < N; i++) {
    const len = +input[pointer++];
    for (let j = 0; j < len; j++) {
      const [target, decrease] = input[pointer++].split(" ").map(Number);
      discounts[i].push([target - 1, decrease]);
    }
  }

  /* 메인 로직 */
  for (let i = 0; i < N; i++) {
    v[i] = true;
    dfs(i, 1, prices[i]);
    v[i] = false;
  }

  /* 정답 반환 */
  return answer;

  // dfs
  function dfs(pos, count, sum) {
    if (sum >= answer) return;
    if (count === N) {
      answer = Math.min(answer, sum);
      return;
    }

    for (const [target, decrease] of discounts[pos]) {
      prices[target] -= decrease;
    }

    for (let i = 0; i < N; i++) {
      if (v[i]) continue;
      v[i] = true;
      dfs(i, count + 1, sum + Math.max(prices[i], 1));
      v[i] = false;
    }

    for (const [target, decrease] of discounts[pos]) {
      prices[target] += decrease;
    }
  }
};

console.log(solution());

