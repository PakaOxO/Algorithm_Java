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
  let [minDiscount, maxDiscount] = [40, 1];
  const comb = Array.from({ length: eCount }, () => 0);
  const v = Array.from({ length: uCount }, () => false);
  const prices = Array.from({ length: uCount }, () => 0);

  /* 메인 로직 */
  users.sort((a, b) => {
    if (a[0] === b[0]) return a[1] - b[1];
    return a[0] - b[0];
  });
  emoticons.sort((a, b) => b[0] - a[0]);

  // 최대, 최소 할인율 범위 갱신
  users.forEach((user) => {
    minDiscount = Math.min(minDiscount, user[0]);
    maxDiscount = Math.max(maxDiscount, user[0]);
  });

  combination(0, 0, 0);

  return answer;

  /* 각 이모티콘 할인 조합 찾기 */
  function combination(depth, ePlus, totalPrice) {
    if (depth === eCount) {
      if (ePlus < answer[0]) return;

      if (ePlus === answer[0]) {
        answer[1] = Math.max(answer[1], totalPrice);
      } else {
        answer[1] = totalPrice;
      }
      answer[0] = Math.max(answer[0], ePlus);

      // if (ePlus === 4) {
      //   console.log(prices, users, totalPrice);
      // }
      if (totalPrice === 16614 && ePlus === 4) {
        console.log("-------------");
        console.log(ePlus, totalPrice, prices, users, comb);
      }
      return;
    }

    for (let discount = minDiscount; discount <= maxDiscount; discount++) {
      let sum = 0;
      let newEPlus = 0;
      const discountedPrice = (emoticons[depth] * (100 - discount)) / 100;

      for (let i = 0; i < uCount; i++) {
        if (discount < users[i][0]) continue;

        if (prices[i] + discountedPrice >= users[i][1]) {
          if (!v[i]) {
            newEPlus++;
            sum -= prices[i];
          }
          v[i] = true;
        } else {
          sum += discountedPrice;
        }
        prices[i] += discountedPrice;
      }

      comb[depth] = discount;
      combination(depth + 1, ePlus + newEPlus, totalPrice + sum);

      for (let i = 0; i < uCount; i++) {
        if (discount < users[i][0]) continue;

        prices[i] -= discountedPrice;
        if (prices[i] < users[i][1]) {
          v[i] = false;
        }
      }
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
