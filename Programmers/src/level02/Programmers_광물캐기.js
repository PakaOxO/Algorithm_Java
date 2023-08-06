/**
 * Programmers_광물캐기
 *    1. 문제 분류 : 그리디, 정렬
 *    2. 접근 방법
 *      - 곡괭이는 집으면 무조건 5개씩 캐야하니까 광물들을 5개씩 묶어(마지막 광물은 남으면 5개 이하로 그대로 묶는다) 각 묶음의 피로도 합을 구함
 *      - 피로도 합은 돌 곡괭이 기준으로 하자
 *      - 피로도 합이 큰 패키지 순으로 묶어 무조건 피로도가 적게 드는 곡괭이를 우선적으로 사용(다이아, 철, 돌 순서)
 */
const solution = (picks, minerals) => {
  /* 변수 초기화 */
  let answer = 0;
  const faigue = [
    { diamond: 1, iron: 1, stone: 1 },
    { diamond: 5, iron: 1, stone: 1 },
    { diamond: 25, iron: 5, stone: 1 },
  ];
  const pack = [];
  let m = [];
  let pickCount = 0;
  let sum = 0;

  /* 메인 로직 */
  // 곡괭이의 전체 개수를 먼저 구함
  pickCount = picks.reduce((acc, base) => acc + base, 0);

  // 5개씩 패키지로 묶어 패키지의 피로도 합(돌 곡괭이 기준)을 구해 패키지 배열에 넣음
  // 내 맘대로 순서를 바꿔 사용할 수 있는 패키지는 남은 곡괭이 개수 만큼임
  for (let i = 0; i < minerals.length && pack.length < pickCount; i++) {
    m.push(minerals[i]);
    sum += faigue[2][minerals[i]];

    if (m.length === 5 || i === minerals.length - 1) {
      m.push(sum);
      pack.push(m);
      sum = 0;
      m = [];
    }
  }

  // 피로도 합 기준 내림차순 정렬
  pack.sort((a, b) => b[b.length - 1] - a[a.length - 1]);

  // 정렬하고 남은 자원들도 패키지로 묶음
  for (let i = pack.length * 5; i < minerals.length; i++) {
    m.push(minerals[i]);
    sum += faigue[2][minerals[i]];

    if (m.length === 5 || i === minerals.length - 1) {
      m.push(sum);
      pack.push(m);
      sum = 0;
      m = [];
    }
  }

  // 각 패키지를 순회하면서 다이아 -> 철 -> 돌 곡괭이 우선으로 사용
  let pointer = 0;
  console.log(pack);
  for (let i = 0; i < picks.length && pointer < pack.length; i++) {
    while (picks[i] > 0 && pointer < pack.length) {
      for (let j = 0; j < pack[pointer].length - 1; j++) {
        answer += faigue[i][pack[pointer][j]];
      }
      picks[i]--;
      pointer++;
    }
  }

  /* 결과 반환 */
  return answer;
};

console.log(solution([1, 3, 2], ["diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"]));
console.log(
  solution(
    [0, 0, 1],
    ["stone", "stone", "stone", "stone", "stone", "diamond", "diamond", "diamond", "diamond", "diamond", "diamond"]
  )
);

