/**
 * BaekJoon_15501, 부당한 퍼츨
 *  - 문제 분류: 애드혹, 시간 복잡도 O(2N)
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/15501.txt").toString().trim().split("\n");
  const N = +input[0];
  const arr1 = input[1].split(" ").map(Number);
  const arr2 = input[2].split(" ").map(Number);
  let start = -1;

  /* 메인 로직 */
  for (let i = 0; i < N; i++) {
    if (arr1[i] === arr2[i]) {
      start = i;
      break;
    }
  }

  let flag = true;
  if (arr1[(start + 1) % N] === arr2[(start + 1) % N]) {
    for (let i = start; i < (start - 1 + N) % N; i++) {
      if (arr1[i] !== arr2[i]) {
        flag = false;
        break;
      }
    }
  } else {
    for (let i = start; i < (start + 1) % N; i--) {
      if (arr1[i] !== arr2[i]) {
        flag = false;
        break;
      }
    }
  }

  /* 정답 반환 */
  return flag ? "good puzzle" : "bad puzzle";
};

console.log(solution());

