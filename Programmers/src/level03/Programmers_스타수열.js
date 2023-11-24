/**
 * Programmers_스타 수열
 *  - 문제 분류: 그리디
 */
const solution = (a) => {
  /* 변수 관리 */
  const len = a.length;
  let answer = 0;

  /* 메인 로직 */
  // 길이 범위는 최대 len -> 50만
  // 이분 탐색으로 일단 길이 지정 -> 대충 경우의 수 20
  let [left, right] = [0, len];
  while (left <= right) {
    let mid = Math.floor((left + right) / 2);
    if (mid % 2 > 0) mid++;
    // 해당 길이를 가진 스타 수열이 있는지? -> 50만
    if (check(mid)) {
      answer = Math.max(answer, mid);
      left = mid + 2;
    } else {
      right = mid - 2;
    }
  }

  /* 정답 반환 */
  return answer;

  // check
  function check(size) {
    const goalCount = size / 2;
    const dp = Array.from({ length: len }, () => [0, -1]);

    for (let i=0; i<len; i++) {
      const num = a[i];
      if (i > 0) {
        if (a[i - 1] !== num && dp[num][1] !== i - 1) {
          dp[num][0]++;
          dp[num][1] = i - 1;
          if (dp[num][0] === goalCount) return true;
          continue;
        }
      }
      
      if (i < len - 1) {
        if (a[i + 1] !== num && dp[num][1] !== i + 1) {
          dp[num][0]++;
          dp[num][1] = i + 1;
          if (dp[num][0] === goalCount) return true;
          continue;
        }
      }
    }

    return false;
  }
}

console.log(solution([5,2,3,3,5,3]));
console.log(solution([0,3,3,0,7,2,0,2,2,0]));
console.log(solution([0, 0, 0, 0, 3, 1, 0, 0]));