/**
 * BaekJoon_18243, Small world network
 *  - 문제 분류: 그래프, 플로이드-워셜
 */
const solution = () => {
  /* 변수 관리 */
  const input = require('fs').readFileSync('./dev/stdin/18243.txt').toString().trim().split('\n');
  const [N, K] = input[0].split(' ').map(Number);
  const INF = Number.MAX_SAFE_INTEGER;
  const dist = Array.from({ length: N + 1 }, (_, i) => Array.from({ length: N + 1 }, (_, j) => (i === j ? 0 : INF)));
  let answer = 'Small World!';

  for (let i = 1; i <= K; i++) {
    const [s, e] = input[i].split(' ').map(Number);
    dist[s][e] = 1;
    dist[e][s] = 1;
  }

  /* 메인 로직 */
  for (let m = 1; m <= N; m++) {
    for (let i = 1; i <= N; i++) {
      for (let j = 1; j <= N; j++) {
        if (dist[i][j] > dist[i][m] + dist[m][j]) {
          dist[i][j] = dist[i][m] + dist[m][j];
        }
      }
    }
  }

  for (let i = 1; i <= N; i++) {
    for (let j = 1; j <= N; j++) {
      if (dist[i][j] > 6) {
        answer = 'Big World!';
        break;
      }
    }
  }

  /* 정답 반환 */
  return answer;
};

console.log(solution());

