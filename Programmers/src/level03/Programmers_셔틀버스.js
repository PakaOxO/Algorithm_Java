/**
 * Programmers_셔틀 버스
 *    - 문제 분류 :
 */
const solution = (n, t, m, timeTable) => {
  /* 변수 초기화 */
  let answer = "";
  const N = timeTable.length;
  let pointer = 0;
  let busCount = 0;
  let waitingCrew = 0;
  const firstBus = getMinute(9, 0);
  const initTime = getMinute(0, 1);
  const endTime = getMinute(24, 0);
  const convertedTimeTable = [];

  /* 메인 로직 */
  for (let i = 0; i < N; i++) {
    const [h, m] = timeTable[i].split(":").map((item) => +item);
    convertedTimeTable.push(getMinute(h, m));
  }
  convertedTimeTable.sort((a, b) => a - b);

  for (let time = initTime; time < endTime; time++) {
    let count = 0;
    while (pointer < N && time === convertedTimeTable[pointer]) {
      count++;
      pointer++;
    }

    if (waitingCrew + count >= m * (n - busCount)) {
      answer = getTime(time - 1);
      break;
    }

    waitingCrew += count;

    if (time === firstBus + busCount * t) {
      waitingCrew -= m;
      if (waitingCrew < 0) waitingCrew = 0;
      busCount++;
    }
  }

  if (answer.length === 0) {
    answer = getTime(firstBus + (n - 1) * t);
  }

  /* 정답 반환 */
  return answer;

  /**
   * 시간(h, m)을 분으로 변환
   */
  function getMinute(h, m) {
    return h * 60 + m;
  }

  /**
   * 분을 시간으로 변환
   */
  function getTime(min) {
    const h = Math.floor(min / 60);
    const m = min - h * 60;
    return `${h < 10 ? "0" + h : h}:${m < 10 ? "0" + m : m}`;
  }
};

// console.log(solution(1, 1, 5, ["08:00", "08:01", "08:02", "08:03"]));
// console.log(solution(2, 10, 2, ["09:10", "09:09", "08:00"]));
// console.log(solution(2, 1, 2, ["09:00", "09:00", "09:00", "09:00"]));
// console.log(solution(1, 1, 5, ["00:01", "00:01", "00:01", "00:01", "00:01"]));
// console.log(solution(1, 1, 1, ["23:59"]));
// console.log(
//   solution(10, 60, 45, [
//     "23:59",
//     "23:59",
//     "23:59",
//     "23:59",
//     "23:59",
//     "23:59",
//     "23:59",
//     "23:59",
//     "23:59",
//     "23:59",
//     "23:59",
//     "23:59",
//     "23:59",
//     "23:59",
//     "23:59",
//     "23:59",
//   ])
// );
console.log(solution(3, 1, 2, ["09:00", "09:00", "09:00", "09:01", "09:01", "09:02"]));
