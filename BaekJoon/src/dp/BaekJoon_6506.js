/**
 * BaekJoon_6506, 엘도라도
 *    - 문제 분류 : 다이나믹 프로그래밍
 */
const solution = () => {
  console.log(Number.MAX_SAFE_INTEGER);
  /* 변수 초기화 */
  const input = require("fs").readFileSync("./dev/stdin/6506.txt").toString().trim().split("\n");
  let answer = "";
  let dp = null;
  let line = 0;

  /* 메인 로직 */
  while (true) {
    const [n, k] = input[line++].split(" ").map((item) => +item);
    const count = permCounts(n, k);
    if (count === null) break;
    answer += `${count}\n`;
  }

  /* 정답 반환 */
  return answer.trim();

  /**
   * 수열의 전체길이(n)와 부분수열의 길이(k) 그리고 수열이 주어졌을 때 정답 반환
   */
  function permCounts(n, k) {
    if (n === 0 && k === 0) return null;
    const arr = input[line++].split(" ").map((item) => +item);
    dp = Array.from({ length: n }, () => Array.from({ length: k + 1 }, () => BigInt(0)));
    let count = BigInt(0);

    // 현재 위치
    for (let i = 0; i < n; i++) {
      dp[i][1] = BigInt(1);
      // 이전 위치들
      for (let j = 0; j < i; j++) {
        // 나보다 같거나 크면 증가하는 수열을 만들 수 없음
        if (arr[j] >= arr[i]) continue;
        // 이전 친구의 각 len 길이의 개수 = 내 len + 1 길이의 개수
        // 이전 친구의 개수는 최대 현재 나(i)까지의 길이를 넘을 수 없음
        for (let c = 1; c < i + 1 && c < k; c++) {
          dp[i][c + 1] += BigInt(dp[j][c]);
        }
      }

      count += dp[i][k];
    }

    return count.toString();
  }
};

console.log(solution());

