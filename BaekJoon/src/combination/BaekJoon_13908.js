/**
 * BaekJoon_13908, 비밀번호
 *    1. 문제 분류 : 조합론
 *    2. 접근 방법
 *      - 비밀번호 길이의 배열을 만든 뒤 알고 있는 숫자를 1개씩만 배열에 넣는 순열들을 찾는다
 *      - 순열을 찾았다면 숫자를 넣지 않는 부분에 들어갈 수 있는 숫자를 유추해 개수를 카운팅한다
 */
const solution = () => {
  /* 변수 초기화 */
  const input = require("fs").readFileSync("./dev/stdin/13908.txt").toString().trim().split("\n");
  const [n, m] = input[0].split(" ").map((item) => +item);
  let numbers = null;
  const limit = Math.pow(10, n);
  if (m > 0) {
    numbers = new Set(input[1].split(" ").map((item) => +item));
  }
  const v = Array.from({ length: 10 }, () => false);
  let answer = 0;

  /* 메인 로직 */
  if (m < 1) {
    answer = limit;
  } else {
    dfs(0, 0, 0);
  }

  /* 정답 반환 */
  return answer;

  function dfs(depth, number, count) {
    if (depth === n) {
      if (count === m) answer++;
      return;
    }

    for (let i = 0; i < 10; i++) {
      if (numbers.has(i) && !v[i]) {
        if (!v[i]) {
          v[i] = true;
          dfs(depth + 1, number * 10 + i, count + 1);
          v[i] = false;
        } else {
          dfs(depth + 1, number * 10 + i, count);
        }
      } else {
        dfs(depth + 1, number * 10 + i, count);
      }
    }
  }
};

console.log(solution());
