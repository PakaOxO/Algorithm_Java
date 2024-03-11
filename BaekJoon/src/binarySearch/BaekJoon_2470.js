/**
 * BaekJoon_2470, 두 용액
 *  - 문제 분류: 이분 탐색, 투 포인터, 정렬
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/2470.txt").toString().trim().split("\n");
  const N = +input[0];
  const resolution = input[1].split(" ").map(Number);
  const INF = 1000000000;
  const acid = [];
  const basic = [];
  let min = INF * 2;
  const answer = [0, 0];

  for (let i = 0; i < N; i++) {
    if (resolution[i] < 0) acid.push(resolution[i]);
    else basic.push(resolution[i]);
  }
  acid.sort((a, b) => b - a);
  basic.sort((a, b) => a - b);

  /* 메인 로직 */
  for (let i = 0; i < acid.length; i++) {
    let [left, right] = [0, basic.length - 1];
    while (left <= right) {
      const mid = Math.floor((left + right) / 2);
      const diff = acid[i] + basic[mid];
      if (Math.abs(diff) <= min) {
        [answer[0], answer[1]] = [acid[i], basic[mid]];
        min = Math.abs(diff);
      }

      if (diff > 0) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
  }

  if (acid.length > 1 && Math.abs(acid[0] + acid[1]) <= min) {
    min = Math.abs(acid[0] + acid[1]);
    [answer[0], answer[1]] = [acid[1], acid[0]];
  }

  if (basic.length > 1 && Math.abs(basic[0] + basic[1]) <= min) {
    min = Math.abs(basic[0] + basic[1]);
    [answer[0], answer[1]] = [basic[0], basic[1]];
  }

  /* 정답 반환 */
  return answer.join(" ");
};

console.log(solution());

