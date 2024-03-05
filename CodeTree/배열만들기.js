/**
 * CodeTree_배열 만들기
 *  - 문제 분류: 그리디
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/배열만들기.txt").toString().trim().split("\n");
  const N = +input[0];
  const arr = input[1].split(" ").map(Number);
  let answer = 0;

  /* 메인 로직 */
  while (true) {
    const f = makeEvenArr();
    const f2 = makeHalfArr();
    if (!f && !f2) break;
  }

  /* 정답 반환 */
  return answer;

  // makeEvenArr
  function makeEvenArr() {
    let prev = answer;
    for (let i = 0; i < N; i++) {
      if (arr[i] % 2 === 0) continue;
      arr[i]--;
      answer++;
    }

    return answer !== prev;
  }

  // makeHalfArr
  function makeHalfArr() {
    let flag = false;
    for (let i = 0; i < N; i++) {
      if (arr[i] === 0) continue;
      arr[i] /= 2;
      flag = true;
    }

    if (flag) answer++;
    return flag;
  }
};

console.log(solution());

