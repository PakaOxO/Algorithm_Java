/**
 * Programmers_후보키
 *    1. 문제 분류 : 조합, 해시
 *    2. 접근 방법
 *      - 모든 조합을 탐색하면서 해당 조합들에 대해 유일성을 만족하는 후보키인지 체크
 *        -> 후보키이면 그 조합 뒤로는 더 이상 탐색하지 않고 리턴 -> 제2규칙을 만족하기 위해
 *      - 조합 탐색을 위해 처음에 배열을 사용했으나 만약 [1, 2]가 이미 후보키에 있을 때 [0, 1, 2]가 후보키가 될 수 없음을 검증하려면 루프를 돌아야 했음
 *        -> 비트마스킹으로 조합을 표현한 뒤 & 연산의 결과가 이전 키와 같으면 새로 후보키로 등록하지 못하도록 코드 수정
 */
const solution = (relation) => {
  /* 변수 초기화 */
  const keys = [];
  const N = relation.length;
  const keyCount = relation[0].length;

  /* 메인 로직 */
  combination();

  return keys.length;

  /* 모든 조합 탐색(개수가 적은 조합부터, bfs) */
  function combination() {
    const q = Array.from({ length: keyCount }, (_, i) => 1 << i);

    while (q.length > 0) {
      const comb = q.shift();
      const flag = isTuplesUnique(comb);
      if (flag) {
        keys.push(comb);
        continue;
      }
      for (let i = comb.toString(2).length; i < keyCount; i++) {
        q.push(comb | (1 << i));
      }
    }
  }

  /* 만들어진 조합에 대해 튜플들이 유일성을 만족하는지 체크 */
  function isTuplesUnique(comb) {
    const set = new Set();

    for (let i = 0; i < keys.length; i++) {
      if ((comb & keys[i]) === keys[i]) return false;
    }

    for (let i = 0; i < N; i++) {
      let data = "";
      for (let j = 0; j < keyCount; j++) {
        if (comb & (1 << j)) data += `${j}_${relation[i][j]}`;
      }
      if (set.has(data)) return false;
      set.add(data);
    }

    return true;
  }
};

console.log(
  solution([
    ["100", "ryan", "music", "2"],
    ["200", "apeach", "math", "2"],
    ["300", "tube", "computer", "3"],
    ["400", "con", "computer", "4"],
    ["500", "muzi", "music", "3"],
    ["600", "apeach", "music", "2"],
  ])
);
console.log(
  solution([
    ["a", "b", "c"],
    ["1", "b", "c"],
    ["a", "b", "4"],
    ["a", "5", "c"],
  ])
);
console.log(
  solution([
    ["a", "2", "4"],
    ["2", "1", "5"],
    ["a", "2", "5"],
  ])
);

