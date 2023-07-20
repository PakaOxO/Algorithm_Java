/**
 * Programmers_메뉴 리뉴얼
 *  1. 문제 분류 : 해시, 맵, 조합
 *  2. 접근 방법
 *    - 각 손님들이 시킨 메뉴에서 2개 이상 메뉴를 뽑는 조합을 모두 가져와 Set 객체에 저장
 *    - Set 객체에 저장할 때 Map 객체에 해당 코스에 대해 개수를 증가 | 없으면 1로 추가
 *    - 개수가 2개 이상(2번 이상 주문된 코스)인 코스에 대해 answer에 추가
 */
const solution = (orders, course) => {
  /* 변수 선언부 */
  const answer = Array.from({ length: 21 }, () => null);
  const courses = new Set();
  const orderCount = new Map();
  const checkCount = Array.from({ length: 21 }, () => false);
  const maxCount = Array.from({ length: 21 }, () => 0);
  course.forEach((count) => (checkCount[count] = true));

  /* 메인 로직부 */
  for (let i = 0; i < orders.length; i++) {
    const sorted = orders[i].split("").sort().join("");
    combination(sorted, 0, 0, "");
  }

  return answer
    .filter((c) => c != null)
    .flat()
    .sort();

  function combination(order, start, depth, comb) {
    if (depth > order.length) return;
    if (checkCount[depth]) {
      courses.add(comb);
      orderCount.set(comb, orderCount.get(comb) + 1 || 1);
      if (
        orderCount.get(comb) >= 2 &&
        orderCount.get(comb) >= maxCount[depth]
      ) {
        if (orderCount.get(comb) === maxCount[depth]) {
          answer[depth].push(comb);
        } else {
          answer[depth] = [comb];
        }
        maxCount[depth] = orderCount.get(comb);
      }
    }

    for (let i = start; i < order.length; i++) {
      combination(order, i + 1, depth + 1, comb + order.charAt(i));
    }
  }
};

console.log(
  solution(["ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"], [2, 3, 4])
);
console.log(
  solution(["ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"], [2, 3, 5])
);
console.log(solution(["XYZ", "XWY", "WXA"], [2, 3, 4]));
