/**
 * plaformName_probName
 *  - 문제 분류: type
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/1972.txt").toString().trim().split("\n");
  let pointer = 0;
  const answer = [];

  /* 메인 로직 */
  while (true) {
    const str = input[pointer++];
    if (str === "*") break;
    const N = str.length;

    let flag = true;
    loop: for (let i = 1; i < N; i++) {
      const map = new Map();
      for (let j = 0; i + j < N; j++) {
        const comb = str.charAt(j) + str.charAt(j + i);
        if (map.has(comb)) {
          flag = false;
          break loop;
        }
        map.set(comb, 0);
      }
    }

    answer.push(`${str} is${flag ? " " : " NOT "}surprising.`);
  }

  /* 정답 반환 */
  return answer.join("\n");
};

console.log(solution());

