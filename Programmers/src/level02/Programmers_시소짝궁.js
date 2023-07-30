/**
 * Programmers_시소 짝궁
 *    1. 문제 분류 : 조합, 해시
 *    2. 접근 방법
 *      - 전체 무게의 개수는 10만개로 많은 편이지만 무게의 종류는 100부터 1000까지 많아봐야 약 900개 정도 뿐
 *      - 무게의 종류별 개수를 구해 개수 배열에 저장
 *      - 각 무게 종류 중 2개를 뽑은 다음 곱할 수 있는 조합(x2, x3, x4)으로 곱한 결과 양 무게의 곱이 같다면 answer + 1
 *        - 단, 각 무게의 개수가 1개 이상일 수 있으므로 무게의 조합으로 나올 수 있는 경우의 수는 각 무개의 개수를 곱한 값
 *      - 또, 각 무게의 종류별 같은 무게 중에서 뽑는 조합도 있을 수 있으므로 같은 무게를 뽑았을 경우 -> 무조건 짝궁 성립
 *        - 이때에는 조합의 연산식 n * (n - 1) / 2으로 구한 값을 answer에 더함
 */
const solution = (weights) => {
  /* 변수 선언부 */
  const counts = Array.from({ length: 1001 }, () => 0);
  const N = weights.length;
  const w = [];
  const multiplier = [2, 3, 4];
  let wCount = 0;
  let answer = 0;

  /* 메인 로직 */
  weights.sort((a, b) => a - b);
  for (let i = 0; i < N; i++) {
    if (counts[weights[i]] === 0) {
      w.push(weights[i]);
      wCount++;
    }
    counts[weights[i]]++;
  }

  for (let i = 0; i < wCount; i++) {
    if (counts[w[i]] > 1) {
      answer += (counts[w[i]] * (counts[w[i]] - 1)) / 2;
    }
    loop: for (let j = i + 1; j < wCount; j++) {
      for (let k = 0; k < 3; k++) {
        for (let h = 0; h < 3; h++) {
          if (w[i] * multiplier[k] === w[j] * multiplier[h]) {
            answer += counts[w[i]] * counts[w[j]];
            continue loop;
          }
        }
      }
    }
  }

  return answer;
};

console.log(solution([100, 180, 360, 100, 270]));
