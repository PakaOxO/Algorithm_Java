/**
 * BaekJoon_2866, 문자열 잘라내기
 *  - 문제 분류: 문자열, 해시, 이분 탐색
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/2866.txt").toString().split("\n");
  const [R, C] = input[0].split(" ").map((item) => +item);
  const arr = Array.from({ length: R }, () => null);
  let answer = 0;

  /* 메인 로직 */
  for (let i = 1; i <= R; i++) {
    arr[i - 1] = input[i].split("");
  }

  answer = binarySearch(0, R);

  /* 정답 반환 */
  return answer;

  /**
   * 이분 탐색
   */
  function binarySearch(left, right) {
    while (left <= right) {
      const mid = Math.floor((left + right) / 2);
      if (check(mid)) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    return right;
  }

  /**
   * 중복 문자열이 있는지 체크
   */
  function check(size) {
    const set = new Set();

    for (let i = 0; i < C; i++) {
      let str = "";
      for (let j = size; j < R; j++) {
        str += arr[j][i];
      }

      if (set.has(str)) return false;
      set.add(str);
    }

    return true;
  }
};

console.log(solution());
