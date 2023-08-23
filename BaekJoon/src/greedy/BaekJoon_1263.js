/**
 * BaekJoon_1263, 시간 관리
 *    1. 문제 분류 : 그리디
 *    2. 접근 방법
 *      - 타임 테이블을 만들어 걸린 시간과 종료 시간 쌍을 시작 시간과 종료 시간 쌍으로 변환한 배열로
 *      - 타임 테이블을 종료시간이 늦은 순서대로 정렬
 *      - 타임 테이블 배열의 현재 일정(pointer)과 다음 일정(i)를 비교해 시간이 겹치면 다음 일정의 시간을 겹친 만큼 앞으로 당김
 *          -> 반복...
 *      - 맨 마지막 타임 테이블 시작 시간이 0보다 작아지면 -1, 아니면 시작 시간을 정답으로 반환
 */
const solution = () => {
  /* 변수 초기화 */
  const input = require("fs").readFileSync("./dev/stdin/1263.txt").toString().split("\n");
  const N = +input[0];
  const timeTable = [];
  for (let i = 1; i <= N; i++) {
    const [time, endTime] = input[i].split(" ").map((item) => +item);
    timeTable.push([endTime - time, endTime]);
  }
  let pointer = 0;

  timeTable.sort((a, b) => b[1] - a[1]);
  for (let i = 1; i < N; i++) {
    if (timeTable[pointer][0] < timeTable[i][1]) {
      timeTable[i][0] -= timeTable[i][1] - timeTable[pointer][0];
    }
    pointer++;
  }

  return timeTable[N - 1][0] < 0 ? -1 : timeTable[N - 1][0];
};

console.log(solution());

