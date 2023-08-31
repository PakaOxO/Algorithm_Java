/**
 * BaekJoon_2467, 용액
 *    1. 문제 분류 : 포인터
 *    2. 접근 방법
 *      - 먼저 절대값이 가장 작은 위치(mid)를 찾아 left와 right의 위치 초기화
 *      - mid를 기준으로 좌우로 절대값이 작은 숫자가 있는 방향으로 mid를 포함해 각각 left, right로 지정
 */
const solution = () => {
  /* 변수 초기화 */
  const input = require("fs").readFileSync("./dev/stdin/2467.txt").toString().trim().split("\n");
  const N = +input[0];
  const arr = input[1].split(" ").map((item) => +item);
  let [left, right] = [0, N - 1];
  let minAbs = 2000000000;
  const answer = [0, 0];

  /* 메인 로직 */
  while (left < right) {
    const sum = arr[left] + arr[right];
    const abs = Math.abs(sum);

    if (abs <= minAbs) {
      minAbs = abs;
      answer[0] = arr[left];
      answer[1] = arr[right];
      if (abs === 0) break;
    }

    if (sum < 0) {
      left++;
    } else {
      right--;
    }
  }

  /* 정답 반환 */
  return answer.join(" ");
};

console.log(solution());
