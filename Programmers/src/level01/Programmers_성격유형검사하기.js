/**
 * Programmers_성격 유형 검사하기
 *  1. 문제 분류 : 구현
 *  2. 접근 방법
 *    - 각 유형(RT or TR)에 대해 앞 타입에 대답을 어떻게 했냐에 따라 얻을 점수를 미리 해시에 저장
 *    - 뒷 타입에 답변했을 경우 값을 -(음수)처리해서 계산, 결과가 음수이면 뒷 타입, 양수이면 앞 타입으로 배정하면 될 듯
 */
const solution = (survey, choices) => {
  /* 변수 선언부 */
  let answer = Array.from({ length: 4 }, () => null);
  let scores = Array.from({ length: 4 }, () => 0);
  const hashmap = {
    RT: { idx: 0, points: [3, 2, 1, 0, -1, -2, -3] },
    TR: { idx: 0, points: [-3, -2, -1, 0, 1, 2, 3] },
    CF: { idx: 1, points: [3, 2, 1, 0, -1, -2, -3] },
    FC: { idx: 1, points: [-3, -2, -1, 0, 1, 2, 3] },
    JM: { idx: 2, points: [3, 2, 1, 0, -1, -2, -3] },
    MJ: { idx: 2, points: [-3, -2, -1, 0, 1, 2, 3] },
    AN: { idx: 3, points: [3, 2, 1, 0, -1, -2, -3] },
    NA: { idx: 3, points: [-3, -2, -1, 0, 1, 2, 3] },
  };
  const characters = {
    0: "RT",
    1: "CF",
    2: "JM",
    3: "AN",
  };
  const len = survey.length;

  /* 로직 구현부 */
  for (let i = 0; i < len; i++) {
    const type = survey[i];
    const point = choices[i] - 1;
    scores[hashmap[type].idx] += hashmap[type].points[point];
  }

  scores.forEach((score, idx) => {
    if (score >= 0) {
      answer[idx] = characters[idx].charAt(0);
    } else {
      answer[idx] = characters[idx].charAt(1);
    }
  });

  return answer.join("");
};

console.log(solution(["AN", "CF", "MJ", "RT", "NA"], [5, 3, 2, 7, 5]));
