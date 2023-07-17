/**
 * Programmers_최소직사각형
 *  1. 문제 분류 : 수학
 *  2. 접근 방법
 *    - 모든 명함들에 대해 w, h의 최대값을 각각 구하고 곱하면 될듯
 *    - 명함이 가로가 길지 세로가 길지 모르므로 무조건 긴 길이가 가로라고 가정하고 최대값을 구하자
 */
const solution = (sizes) => {
  /* 변수 선언부 */
  let [maxW, maxH] = [0, 0];

  /* 메인 로직부 */
  sizes.forEach((card) => {
    const [big, small] = [
      Math.max(card[0], card[1]),
      Math.min(card[0], card[1]),
    ];
    maxW = Math.max(maxW, big);
    maxH = Math.max(maxH, small);
  });

  return maxW * maxH;
};

console.log(
  solution([
    [60, 50],
    [30, 70],
    [60, 30],
    [80, 40],
  ])
);
console.log(
  solution([
    [10, 7],
    [12, 3],
    [8, 15],
    [14, 7],
    [5, 15],
  ])
);
console.log(
  solution([
    [14, 4],
    [19, 6],
    [6, 16],
    [18, 7],
    [7, 11],
  ])
);
