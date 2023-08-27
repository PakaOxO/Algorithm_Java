/**
 * BaekJoon_2343, 기타 레슨
 *    1. 문제 분류 : 이분 탐색
 *    2. 접근 방법(**풀이 실패)
 *      - 시긴 1부터 최대 전체 누적합까지 시간 사이를 이분 탐색
 *        -> 해당 시간 기준으로 카운트 했을 때 카운팅 된 개수가 m개 이하인 시간의 최대값
 */
const solution = () => {
  /* 변수 초기화 */
  const input = require("fs").readFileSync("./dev/stdin/2343.txt").toString().trim().split("\n");
  let [N, M] = input[0].split(" ").map((item) => +item);
  const acc = [0, ...input[1].split(" ").map((item) => +item)];
  let answer = null;

  for (let i = 1; i <= N; i++) {
    acc[i] += acc[i - 1];
  }

  answer = acc[N];
  binarySearch(1, acc[N]);

  return answer;

  /* 이분 탐색 */
  function binarySearch(left, right) {
    let flag = false;
    while (left < right) {
      if (right - left === 1) {
        if (flag) break;
        flag = true;
      }
      const mid = ~~((left + right) / 2);
      const count = check(mid);
      if (count <= M) {
        answer = Math.min(answer, mid);
        right = mid;
      } else {
        left = mid;
      }
    }
  }

  /* check */
  function check(time) {
    let count = 1;
    let pointer = 0;
    for (let i = 1; i <= N; i++) {
      if (acc[i] - acc[i - 1] > time) return M + 1;
      if (acc[i] - acc[pointer] > time) {
        count++;
        pointer = i - 1;
      }
    }

    return count;
  }
};

console.log(solution());
