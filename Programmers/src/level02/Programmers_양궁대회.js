/**
 * Programmers_양궁 대회
 *    1. 문제 분류 : 조합, 완전탐색
 *    2. 접근 방법
 *      - 라이언이 각각의 점수에 대해 화살을 쏘는 경우의 수는 다음과 같다
 *        -> 점수를 획득하기 위해 어피치가 쏜 횟수 + 1만큼 쏘는 경우
 *        -> 점수를 획득하지 않는 경우
 *          -> 이 경우에는 어피치가 쏜 화살이 있다면 어피치가 점수를 획득한다
 *      - 0~10점으로 각 점수를 순회하며 모든 경우의 수를 찾는다.(각각의 경우에 대해 쏘거나 안쏘거나 2가지 경우 -> 2^11의 경우의 수)
 *      - 점수의 차이가 최대가 되는 조합을 찾아 answer를 갱신한다
 *      - 적당히 화살을 쏘다보면 남는 화살이 생긴다 이때 남는 화살을 처리하는 로직은
 *        -> 가장 점수가 낮은 점수부터 순회하면서
 *          -> 어피치보다 이미 많이 쏜 화살이 있다면 여기다 다 써버린다.
 *          -> 어피치가 쏜 점수라면 여기에는 어피치랑 쏜 화살 개수가 같을 때까지만 소모한다.
 *
 */
const solution = (n, info) => {
  /* 변수 초기화 */
  const comb = Array.from({ length: 11 }, () => 0);
  let answer = [-1];
  let max = 0;

  /* 메인 로직 */
  dfs(10, n, 0);

  /* 정답 반환 */
  return answer;

  function dfs(i, res, sum) {
    if (i < 0) {
      if (sum > max) {
        answer = [...comb];
        max = sum;
        useResArrows(res);
      }
      return;
    }

    // 어피치가 쏜 화살이 있으면 그거보다 1개 많이 쏴서 점수를 얻자(화살이 모자라면 쏘지 않는다)
    if (res > info[i]) {
      comb[i] = info[i] + 1;
      dfs(i - 1, res - (info[i] + 1), sum + 10 - i);
      comb[i] = 0;
    }

    // 라이언이 안쏘고, 어치피가 쐈다면 어피치 점수 획득
    if (info[i] > 0) {
      dfs(i - 1, res, sum + i - 10);
    } else {
      // 어피치도 안쐈다면 둘다 점수 X
      dfs(i - 1, res, sum);
    }
  }

  /* 남은 화살 처리 */
  function useResArrows(res) {
    let i = 10;
    while (res > 0 && i >= 0) {
      // 라이언이 점수를 획득한 점수에서는 화살 전부 소모
      if (answer[i] > info[i]) {
        answer[i]++;
        res--;
      } else {
        // 어피치랑 화살이 같아질 때까지만 소모
        if (answer[i] + 1 <= info[i]) {
          answer[i]++;
          res--;
        } else {
          i--;
        }
      }
    }
  }
};

console.log(solution(5, [2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0]));
console.log(solution(1, [1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]));
console.log(solution(9, [0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1]));
console.log(solution(10, [0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3]));

