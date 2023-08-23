/**
 * Programmers_징검다리 건너기
 *    1. 문제 분류 : 구간 최대 값, 세그먼트트리
 *    2. 접근 방법
 *      -
 */
const solution = (stones, k) => {
  /* 변수 초기화 */
  const N = stones.length;
  const INF = 200000001;
  let answer = INF;
  let [left, right, max] = [0, k - 1, Math.max(...stones.slice(0, k))];

  /* 메인 로직 */
  while (right < N - 1) {
    if (right >= 0) {
      if (stones[left] === max) {
        max = 0;
        for (let i = left + 1; i <= right; i++) {
          max = Math.max(max, stones[i]);
        }
      }
      left++;
    }

    right++;
    if (stones[right] > max) {
      max = stones[right];
    }

    answer = Math.min(answer, max);
  }

  return answer;
};

console.log(solution([2, 4, 5, 3, 2, 1, 4, 2, 5, 1], 3));

