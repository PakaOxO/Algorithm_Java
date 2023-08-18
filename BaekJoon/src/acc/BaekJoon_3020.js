/**
 * BaekJoon_3020, 개똥벌레
 *    1. 문제 분류 : 누적 합
 *    2. 접근 방법 **못품
 *      - 석순과, 종유석 높이를 입력 받으면서 각각의 높이가 끝나는 지점에 +1
 *        -> 석순은 높이가 높은 쪽부터 내려가면서 누적합 -> 해당 높이에서 만나는 장애물(석순)의 개수
 *        -> 종유석은 높(H - h + 1)가 낮은 쪽부터 올라가면서 누적 합 -> 마찬가지로 해당 높이에서 만나는 장애물(종유석)의 개수
 *      - 높이 1부터 최대 H까지 마주치는 석순과 종유석의 개수의 합을 체크하면서 최소 값 및 구간 개수 탐색
 */
const solution = () => {
  /* 변수 초기화 */
  const input = require("fs").readFileSync("./dev/stdin/3020.txt").toString().trim().split("\n");
  const [N, H] = input[0].split(" ").map((item) => +item);
  let answer = [N, 0];
  const acc = Array.from({ length: H + 1 }, () => [0, 0]);

  /* 메인 로직 */
  for (let i = 1; i <= N; i++) {
    const h = +input[i];
    if (i % 2 > 0) {
      acc[h][0]++;
    } else {
      acc[H - h + 1][1]++;
    }
  }

  for (let i = 1; i <= H; i++) {
    acc[H - i][0] += acc[H - (i - 1)][0];
    acc[i][1] += acc[i - 1][1];
  }

  for (let i = 1; i <= H; i++) {
    if (acc[i][0] + acc[i][1] <= answer[0]) {
      if (acc[i][0] + acc[i][1] === answer[0]) {
        answer[1]++;
      } else {
        answer[1] = 1;
      }
      answer[0] = acc[i][0] + acc[i][1];
    }
  }

  return answer.join(" ");
};

console.log(solution());

