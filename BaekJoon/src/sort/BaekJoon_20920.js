/**
 * BaekJoon_20920, 영단어 암기는 괴로워
 *  - 문제 분류: 정렬, 해시
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/20920.txt").toString().trim().split("\n");
  const [N, M] = input[0].split(" ");
  const map = new Map();
  const lib = [];

  /* 메인 로직 */
  for (let i = 1; i <= N; i++) {
    const word = input[i];
    if (word.length < M) continue;
    const count = map.get(word);
    if (count) {
      map.set(word, count + 1);
    } else {
      map.set(word, 1);
    }
  }

  for (const [a, b] of map) {
    lib.push([a, b]);
  }

  lib.sort((a, b) => {
    if (a[1] === b[1] && a[0].length === b[0].length) return a[0] > b[0] ? 1 : -1;
    if (a[1] === b[1]) return b[0].length - a[0].length;
    return b[1] - a[1];
  });

  /* 정답 반환 */
  return lib.map((item) => item[0]).join("\n");
};

console.log(solution());

