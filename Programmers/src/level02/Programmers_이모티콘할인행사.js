/**
 * Programmers_이모티콘 할인행사
 *    1. 문제 분류 : 완전탐색?, 조합, 백트래킹
 *    2. 접근 방법
 *      - 최대 할인율이 40프로니 사람 입력값 중 최소 할인율부터 40까지 돌려볼까...
 *        -> 사람 수, n명(1~100)
 *        -> 이모티콘, 개수 m개(1 ~ 7) -> 각각 1 ~ 40프로 할인이면... -> 40^7가지 경우의 수가 나오네 -> 대충 천만
 *      - 최대한 구매하는 이모티콘 개수가 많게 하려면 할인을 결국 많이 해줘야함
 *        -> 싼 이모티콘을 많이, 비싼 이모티콘을 덜 할인해줘야 할거 같다. -> 반대려나
 */
const solution = (users, emoticons) => {
  /* 변수 초기화 */
  const [uCount, eCount] = [users.length, emoticons.length];
  const answer = [0, 0];
  const comb = Array.from({ length: eCount }, () => 0);
  const prices = Array.from({ length: uCount }, () => 0);

  /* 메인 로직 */
  combination(0, 0, 0);

  /* 정답 반환 */
  return answer;

  /* 각 이모티콘 할인 조합 찾기 */
  function combination(depth) {
    if (depth === eCount) {
      let ePlus = 0;
      let totalPrice = 0;
      prices.fill(0);

      for (let i = 0; i < uCount; i++) {
        for (let j = 0; j < eCount; j++) {
          if (comb[j] < users[i][0]) continue;
          prices[i] += (emoticons[j] * (100 - comb[j])) / 100;
        }

        if (prices[i] >= users[i][1]) {
          ePlus++;
        } else {
          totalPrice += prices[i];
        }
      }

      if (ePlus < answer[0]) return;

      if (ePlus === answer[0]) {
        answer[1] = Math.max(answer[1], totalPrice);
      } else {
        answer[1] = totalPrice;
      }
      answer[0] = Math.max(answer[0], ePlus);
      return;
    }

    for (let discount = 40; discount >= 10; discount -= 10) {
      comb[depth] = discount;
      combination(depth + 1);
    }
  }
};

console.log(
  solution(
    [
      [40, 10000],
      [25, 10000],
    ],
    [7000, 9000]
  )
);
console.log(
  solution(
    [
      [40, 2900],
      [23, 10000],
      [11, 5200],
      [5, 5900],
      [40, 3100],
      [27, 9200],
      [32, 6900],
    ],
    [1300, 1500, 1600, 4900]
  )
);
// console.log(
//   solution(
//     [
//       [1, 10000],
//       [2, 10000],
//       [5, 10000],
//       [10, 10000],
//       [15, 10000],
//       [20, 10000],
//       [25, 10000],
//       [30, 10000],
//       [35, 10000],
//       [40, 10000],
//     ],
//     [3000, 4000, 5000, 6000, 7000, 8000, 9000, 10000]
//   )
// );

