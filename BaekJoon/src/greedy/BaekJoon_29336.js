/**
 * BaekJoon_월향, 비상
 *  - 문제 분류: 그리디
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/29336.txt").toString().split("\n");
  const [N, M] = input[0].split(" ").map(Number);
  const skill = input[1].split(" ").map(Number);
  let pointer = 0;
  let flag = true;
  let lastDay = 0;
  let sum = 0;
  let answer = -1;

  /* 메인 로직 */
  skill.sort((a, b) => b - a);
  for (let i=2; i<2+M; i++) {
    const [day, target] = input[i].split(" ").map(Number);
    lastDay = day;
    while (sum < target && pointer < N) {
      sum += skill[pointer++] + day;
    }

    if (sum < target) {
      flag = false;
      break;
    }
  }


  if (flag) {
    while (pointer < N) {
      sum += skill[pointer++] + lastDay;
    }
    answer = sum;
  }

  /* 정답 관리 */
  return answer;
}

console.log(solution());