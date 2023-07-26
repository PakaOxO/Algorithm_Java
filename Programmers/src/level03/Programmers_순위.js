/**
 * Programmers_순위
 *  1. 문제 분류 : 그래프
 *  2. 접근 방법
 *    - 이긴 선수 - 진 선수 쌍을 단방향 그래프로 아래로 흐르는 그래프라고 생각을 한다면... -> 결국 못품
 *    - 이기는 방향을 +, 지는 방향을 -의 가중치를 두고 플로이드-워셜로 모든 경로에 대해 누적 가중치를 구함
 *    -> 가중치의 크기는 중요하지 않으므로, 가중치의 합이 0인지 아닌지 확인 -> 0이면 순위를 매길 수 없음
 *      -> 누적 가중치가 0이면 동등한 레벨에 있다는 것을 의미하므로 서로 우위를 가를 수 없다는 것을 뜻하게 됨
 */
const solution = (n, results) => {
  /* 변수 선언부 */
  let answer = n;
  const d = Array.from({ length: n }, () => Array.from({ length: n }, () => 0));

  /* 메인 로직 */

  results.forEach((r) => {
    const [from, to] = r.map((item) => item - 1);
    d[from][to] = 1;
    d[to][from] = -1;
  });

  for (let i = 0; i < n; i++) {
    for (let j = 0; j < n; j++) {
      if (d[j][i] === 0) continue;
      for (let k = 0; k < n; k++) {
        if (d[i][k] === 0) continue;
        if (d[j][i] === 1 && d[i][k] === 1) {
          d[j][k] = 1;
          d[k][j] = -1;
        }
        if (d[j][i] === -1 && d[i][k] === -1) {
          d[j][k] = -1;
          d[k][j] = 1;
        }
      }
    }
  }
  for (let i = 0; i < n; i++) {
    for (let j = 0; j < n; j++) {
      if (i === j || d[i][j] !== 0) continue;
      answer--;
      break;
    }
  }

  return answer;
};

console.log(
  solution(5, [
    [4, 3],
    [4, 2],
    [3, 2],
    [1, 2],
    [2, 5],
  ])
);
