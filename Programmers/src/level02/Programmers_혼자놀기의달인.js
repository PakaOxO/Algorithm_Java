/**
 * Programmers_혼자 놀기의 달인
 *    1. 문제 분류 : dfs, 완전 탐색
 *    2. 접근 방법
 *      - 카드 그룹은 모두 연결되게 되므로 어디에서 시작하든 하나로 연결된 고리형태로 묶임
 *        -> 모든 상자를 돌면서 dfs
 *        -> 이미 방문한 상자는 방문처리
 *        -> dfs의 리턴 값으로 탐색한 상자의 개수를 리턴
 *      - 리턴 받은 상자의 개수 묶음들을 counts 배열에 넣은 뒤 내림 차순으로 정렬
 *      - 앞에서 두개를 꺼내 곱한 뒤 answer에 저장
 *        -> 만약 개수 묶음이 1개 이하면(0일린 없지만) answer에 아무것도 저장X(이미 0으로 초기화)
 */
const solution = (cards) => {
  /* 변수 초기화 */
  let answer = 0;
  const N = cards.length;
  const v = Array.from({ length: N }, () => false);
  const counts = [];

  /* 메인 로직 */
  for (let i = 0; i < N; i++) {
    if (v[i]) continue;
    counts.push(dfs(i, 1));
  }

  if (counts.length >= 2) {
    counts.sort((a, b) => b - a);
    answer = counts[0] * counts[1];
  }

  return answer;

  /* 연결된 카드 개수 찾기 */
  function dfs(n, depth) {
    v[n] = true;
    const next = cards[n] - 1;
    if (v[next]) {
      return depth;
    }
    return dfs(next, depth + 1);
  }
};

console.log(solution([8, 6, 3, 7, 2, 5, 1, 4]));

