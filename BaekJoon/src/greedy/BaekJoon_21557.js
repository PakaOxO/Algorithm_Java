/**
 * BaekJoon_21557, 폭죽놀이
 *  - 문제 분류: 그리디
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/21557.txt").toString().trim().split("\n");
  const N = +input[0];
  const fireworks = input[1].split(" ").map(Number);
  let [left, right] = [fireworks[0], fireworks[N - 1]];
  let res = N - 2;

  /* 메인 로직 */
  while (res > 0) {
    if (left === right) {
      const half = Math.floor(res / 2);
      const remain = res % 2;
      left -= half;
      right -= half;

      if (remain > 0) {
        left--;
        right--;
      } else {
        left--;
      }
      break;
    }

    if (left > right) {
      let min = Math.min(left - right, res);
      res -= min;
      left -= min;
    } else {
      let min = Math.min(right - left, res);
      res -= min;
      right -= min;
    }
  }

  /* 정답 반환 */
  return Math.max(left, right);
};

console.log(solution());

