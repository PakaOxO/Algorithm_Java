/**
 * CodeTree_줄 겹치게 접기
 *  - 문제 분류: 탐색
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/줄겹치게접기.txt").toString().trim().split("\n");
  const [N, L] = input[0].split(" ").map(Number);
  const left = input.slice(1).map(Number);
  const right = [];
  let answer = 0;

  /* 메인 로직 */
  left.sort((a, b) => b - a);

  while (true) {
    const point = left.pop();
    if (left.length === 0) break;

    if (right.length > 0) check(point);
    right.push(point);

    const [l, r] = [left[left.length - 1], right[right.length - 1]];
    const mid = (l + r) / 2;
    check(mid);
  }

  /* 정답 반환 */
  return answer;

  // check
  function check(joint) {
    let flag = true;
    const len = Math.min(left.length, right.length);
    for (let i = 0; i < len; i++) {
      if (left[left.length - 1 - i] - joint === joint - right[right.length - 1 - i]) continue;
      flag = false;
      break;
    }

    if (flag) {
      answer++;
    }
  }
};

console.log(solution());

