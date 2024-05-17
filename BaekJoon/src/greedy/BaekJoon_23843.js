/**
 * BaekJoon_23843, 콘센트
 *  - 문제 분류: 그리디, 정렬
 */
const solution = () => {
  class Gadget {
    constructor(inputTime, chargeTime) {
      this.inputTime = inputTime;
      this.chargeTime = chargeTime;
    }

    getResTime(currTime) {
      return this.chargeTime - (currTime - this.inputTime);
    }
  }

  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/23843.txt").toString().trim().split("\n");
  const [N, M] = input[0].split(" ").map(Number);
  const arr = input[1].split(" ").map(Number);
  const stack = [];

  /* 메인 로직 */
  arr.sort((a, b) => b - a);

  let pointer = 0;
  let time = 0;
  while (true) {
    if (pointer >= N) {
      if (stack.length > 0) {
        stack.sort((a, b) => b.getResTime(time) - a.getResTime(time));
        time += stack[0].getResTime(time);
      }
      break;
    }

    if (stack.length < M) {
      stack.push(new Gadget(time, arr[pointer++]));
      continue;
    }

    stack.sort((a, b) => b.getResTime(time) - a.getResTime(time));
    const diff = stack[M - 1].getResTime(time);
    time += diff;

    while (stack.length > 0) {
      if (stack[stack.length - 1].getResTime(time) > 0) break;
      stack.pop();
    }
  }

  /* 정답 반환 */
  return time;
};

console.log(solution());

