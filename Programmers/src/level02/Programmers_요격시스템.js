/**
 * Programmers_요격 시스템
 *    1. 문제 분류 : 다이나믹 프로그래밍, 누적합, 포인터
 *    2. 접근 방법
 *      -
 */
const solution = (targets) => {
  /* 변수 초기화 */
  const N = targets.length;
  let [pointer, count] = [0, 0];
  let answer = 1;

  /* 메인 로직 */
  targets.sort((a, b) => {
    if (a[0] === b[0]) {
      return a[1] - b[1];
    }
    return a[0] - b[0];
  });

  for (let i = 1; i < N; i++) {
    if (targets[i][0] >= targets[pointer][1]) {
      count += i - pointer;
      pointer = i;
      answer++;
    } else {
      if (targets[i][1] <= targets[pointer][1]) {
        pointer = i;
      }
    }
    if (count >= N) break;
  }

  return answer;
};

console.log(
  solution([
    [4, 5],
    [4, 8],
    [10, 14],
    [11, 13],
    [5, 12],
    [3, 7],
    [1, 4],
  ])
);
console.log(
  solution([
    [1, 4],
    [2, 3],
    [3, 5],
  ])
);
