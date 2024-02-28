/**
 * BaekJoon_1679, 숫자놀이
 *  - 문제 분류: 그리디
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/1679.txt").toString().trim().split("\n");
  const N = +input[0];
  const arr = input[1].split(" ").map(Number);
  const K = +input[2];
  let answer = 0;

  /* 메인 로직 */
  arr.sort((a, b) => b - a);
  const MAX = arr[0] * K + 1;

  for (let i = 1; i <= MAX; i++) {
    answer = i;
    if (!check(i)) break;
  }

  /* 정답 반환 */
  return `${answer % 2 === 0 ? "holsoon" : "jjaksoon"} win at ${answer}`;

  // check
  function check(target) {
    let pointer = 0;
    let count = 0;
    let sum = 0;
    while (sum < target && pointer < N) {
      if (sum + arr[pointer] > target) {
        pointer++;
        continue;
      }

      const share = Math.floor((target - sum) / arr[pointer]);
      if (share + count > K) {
        return false;
      }
      sum += share * arr[pointer];
      count += share;
    }

    return true;
  }
};

console.log(solution());

