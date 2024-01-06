/**
 * BaekJoon_11964, Fruit Feast
 *  - 문제 분류: 너비우선탐색, 메모이제이션
 */
const solution = () => {
  /* 변수 관리 */
  const [T, A, B] = require("fs").readFileSync("./dev/stdin/11964.txt").toString().trim().split(" ").map(Number);
  let answer = 0;
  const v = Array.from({ length: T + 1 }, () => false);

  /* 메인 로직 */
  const q = [[0, 1]];
  v[0] = true;
  while (q.length > 0) {
    const [sum, flag] = q.shift();
    answer = Math.max(answer, sum);

    if (sum + A <= T && !v[sum + A]) {
      q.push([sum + A, flag]);
      v[sum + A] = true;
    }
    if (sum + B <= T && !v[sum + B]) {
      q.push([sum + B, flag]);
      v[sum + B] = true;
    }
    if (flag && !v[Math.floor(sum / 2)]) {
      q.push([Math.floor(sum / 2), 0]);
    }
  }

  /* 정답 반환 */
  return answer;
};

console.log(solution());

