/**
 * Programmers_인사고과
 *  - 문제 분류: 그리디, 정렬
 */
const solution = (scores) => {
  /* 변수 초기화 */
  let answer = 0;
  const N = scores.length;
  let sum;
  let me;
  let maxB = 0;

  /* 메인 로직 */
  me = scores[0];
  sum = me[0] + me[1];

  console.log(me);

  scores.sort((a, b) => (a[0] === b[0] ? a[1] - b[1] : b[0] - a[0]));

  for (let i = 0; i < N; i++) {
    if (i > 0 && scores[i][0] < scores[i - 1][0]) {
      maxB = Math.max(maxB, scores[i - 1][1]);
    }

    if (scores[i] !== me && scores[i][0] + scores[i][1] <= sum) continue;
    answer++;

    if (scores[i][1] < maxB) {
      if (scores[i] === me) {
        answer = -1;
        break;
      }
      answer--;
    }
  }

  /* 정답 반환 */
  return answer;
};

console.log(
  solution([
    [2, 1],
    [2, 2],
    [1, 4],
    [3, 2],
    [3, 2],
  ])
);

