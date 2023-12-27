/**
 * BaekJoon_1253, 문자 해독
 *  - 문제 분류: 문자열, 슬라이딩 윈도우
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/1253.txt").toString().trim().split("\n");
  const [g, S] = input[0].split(" ").map(Number);
  const pattern = input[1];
  const target = input[2];
  let [left, right] = [-1, -1];
  const counts = new Array(123).fill(0);
  const keys = new Set();
  let answer = 0;

  /* 메인 로직 */
  for (let i = 0; i < g; i++) {
    const code = pattern.charCodeAt(i);
    counts[code]++;
    keys.add(code);
  }

  while (right < S) {
    while (right - left < g) {
      const rcode = target.charCodeAt(++right);
      counts[rcode]--;
    }
    const flag = check();
    if (flag) answer++;

    const lcode = target.charCodeAt(++left);
    counts[lcode]++;
  }

  /* 정답 반환 */
  return answer;

  // check
  function check() {
    for (const key of keys) {
      if (counts[key] !== 0) return false;
    }
    return true;
  }
};

console.log(solution());
