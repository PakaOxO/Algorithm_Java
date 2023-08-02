/**
 * BaekJoon_12891, DNA 비밀번호
 *  1. 문제 분류: 투포인터, 문자열
 *  2. 접근 방법
 *    - 앞에서 부터 먼저 주어진 부분 문자열의 길이(P)만큼 탐색하면서 각 DNA 문자의 개수를 카운팅
 *    - 다음 투 포인터를 모두 한칸씩 전진하면서 끝까지 반복
 *    - 모든 부분 문자열에 대해 개수를 충족했으면 answer + 1
 */
const solution = () => {
  const input = require("fs").readFileSync("./dev/stdin/12891.txt").toString().split("\n");

  /* 변수 초기화 */
  const [S, P] = input[0].split(" ").map((item) => +item);
  let [p1, p2] = [0, 0];
  const map = {
    A: 0,
    C: 1,
    G: 2,
    T: 3,
  };
  const counts = input[2].split(" ").map((item) => +item);
  const givenCounts = input[2].split(" ").map((item) => +item);
  const str = input[1];
  let answer = 0;

  /* 메인 로직 */
  while (p2 < S) {
    counts[map[str.charAt(p2++)]]++;

    if (p2 - p1 < P) {
      continue;
    } else if (p2 - p1 > P) {
      counts[map[str.charAt(p1++)]]--;
    }

    if (check()) answer++;
  }

  return answer;

  /* 메서드 */
  function check() {
    for (let i = 0; i < 4; i++) {
      if (counts[i] < givenCounts[i]) return false;
    }
    return true;
  }
};

console.log(solution());

