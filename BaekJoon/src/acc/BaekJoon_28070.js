/*
  BaekJoon_28070, 유니의 편지 쓰기
  Sketch Idea
    1. 
*/
const solution = () => {
  let fs = require("fs");
  let input = fs.readFileSync("./dev/stdin/28070.txt").toString().split("\n");

  /* 초기값 */
  const N = +input[0];
  const dates = [];
  const isIn = [false];
  const enter = [];
  const exit = [];

  for (let i = 1; i <= N; i++) {
    const date = input[i]
      .split(" ")
      .map((item) => item.split("-").map((str) => +str));
    dates.push([...date, false]);
    enter.push([...date[0], i]);
    exit.push([...date[1], i]);
    isIn.push(false);
  }

  /* 메서드 */
  const compareDate = (d1, d2) => {
    if (d1[0] === d2[0]) return d1[1] - d2[1];
    return d1[0] - d2[0];
  };

  enter.sort((a, b) => {
    return compareDate(a, b);
  });
  exit.sort((a, b) => {
    return compareDate(a, b);
  });

  let answer = 0;
  let [max, count] = [0, 0];
  let [pointer1, pointer2] = [0, 0];

  while (pointer1 < N && pointer2 < N) {
    count++;
    isIn[pointer1] = true;

    let hasExit = false;
    if (compareDate(enter[pointer1], exit[pointer2]) >= 0 && isIn[pointer2]) {
      isIn[pointer2] = false;
      if (compareDate(enter[pointer1], exit[pointer2]) === 0) {
        hasExit = true;
      } else {
        count--;
        pointer2++;
      }
    }

    if (count > max) {
      max = count;
      answer = enter[pointer1][0] + "-" + enter[pointer1][1];
    }
    max = Math.max(max, count);

    if (hasExit) {
      count--;
      pointer2++;
    }
    pointer1++;
  }

  return answer;
};

console.log(solution());
