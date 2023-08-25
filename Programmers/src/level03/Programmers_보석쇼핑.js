/**
 * Programmers_보석 쇼핑
 *    1. 문제 분류 : 투 포인터
 *    2. 접근 방법
 *      - 보석 배열의 맨 앞(왼쪽 인덱스)를 가리키는 포인터에 해당하는 보석의 개수가 1개 보다 많으면 포인터를 뒤로 이동
 *      - 좌우 포인터 사이 보석 종류의 개수를 전체 보석의 종류 개수만큼 유지하면서 앞의 포인터를 이동시켜야 함
 *      - 보석의 종류 개수가 전체 보석 종류의 개수와 같으면 위 로직 대로 이동한 좌우 포인터 사이의 거리를 구해 이전 거리보다 짧은 구간일 경우 정답 갱신
 */
const solution = (gems) => {
  /* 변수 초기화 */
  const N = gems.length;
  let pointer = 0;
  const map = new Map();
  let [count, totalCount] = [0, 0];
  let answer = [0, 0];
  let len = N + 1;

  /* 메인 로직 */
  for (let i = 0; i < N; i++) {
    const gem = gems[i];
    if (map.get(gem) === undefined) {
      totalCount++;
      map.set(gem, 0);
    }
  }

  for (let i = 0; i < N; i++) {
    const gem = gems[i];
    if (map.get(gem) < 1) {
      count++;
    }
    map.set(gem, map.get(gem) + 1);

    while (count === totalCount && map.get(gems[pointer]) > 1) {
      map.set(gems[pointer], map.get(gems[pointer]) - 1);
      pointer++;
    }

    if (count === totalCount && i - pointer + 1 < len) {
      answer = [pointer + 1, i + 1];
      len = i - pointer + 1;
    }
  }

  /* 정답 리턴 */
  return answer;
};

console.log(solution(["DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"]));
console.log(solution(["AA", "AB", "AC", "AA", "AC"]));
console.log(solution(["XYZ", "XYZ", "XYZ"]));
console.log(solution(["ZZZ", "YYY", "NNNN", "YYY", "BBB"]));

