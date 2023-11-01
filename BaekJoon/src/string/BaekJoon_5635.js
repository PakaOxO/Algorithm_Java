/**
 * BaekJoon_5635, 생일
 *  - 문제 분류: 문자열
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/5635.txt").toString().trim().split("\n");
  const N = +input[0];
  const [START_DATE, END_DATE] = [19900101, 20101231];
  let [min, minIdx, max, maxIdx] = [END_DATE, -1, START_DATE, -1];
  const answer = [null, null];

  /* 메인 로직 */
  for (let i=1; i<=N; i++) {
    const [name, date, month, year] = input[i].split(" ");
    const number = transToNumber(year, month, date);
    if (number <= min) {
      answer[1] = name;
      min = number;
    }
    if (number >= max) {
      answer[0] = name;
      max = number;
    }
  }

  /* 정답 반환 */
  return answer.join("\n");

  // 입력받은 날짜를 XXXXXXXX자리의 숫자로 변환
  function transToNumber(year, month, date) {
    return +year * 10000 + +month * 100 + +date;
  }
}

console.log(solution());