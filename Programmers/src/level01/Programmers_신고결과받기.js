/**
 * Programmers_신고 결과 받기
 *    1. 문제 분류 : 구현, 자료형(Map, Set)
 *    2. 접근 방법
 *      -
 */
const solution = (id_list, report, k) => {
  /* 변수 선언부 */
  const answer = Array.from({ length: id_list.length }, () => 0);
  const userIdx = new Map();
  const reports = [...new Set(report)].map((r) => r.split(" "));
  const counts = new Map();

  /* 메인 로직부 */
  // 사용자 고유 인덱스 저장
  id_list.forEach((name, idx) => userIdx.set(name, idx));

  // 신고 당한 사람 기준 신고 받은 횟수 저장
  for (const r of reports) {
    counts.set(r[1], counts.get(r[1]) + 1 || 1);
  }

  // 신고한 사람 기준 신고한 사람
  for (const r of reports) {
    if (counts.get(r[1]) >= k) {
      answer[userIdx.get(r[0])]++;
    }
  }

  return answer;
};

console.log(
  solution(
    ["muzi", "frodo", "apeach", "neo"],
    ["muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"],
    2
  )
);
console.log(
  solution(["con", "ryan"], ["ryan con", "ryan con", "ryan con", "ryan con"], 3)
);
