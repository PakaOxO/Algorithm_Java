/**
 * Softeer_성적 평가
 *      1. 문제 분류 : 누적합
 *      2. 접근 방법
 *          - 각 대회에서의 등수는 내가 맞은 점수보다 높은 점수에 있는 사람 수 + 1
 *          - 받은 점수 - 1부터 0까지 사람 수를 누적 증가
 *          - 계산이 완료된 누적합으로부터 내가 받은 점수 위에 있는 사람 수 + 1이 내 등수
 */
const solution = () => {
  const rl = require("readline").createInterface({
    input: process.stdin,
    output: process.stdout,
  });

  /* 변수 초기화 */
  const input = [];
  let N = 0;
  const ranks = [null, null, null, null];
  const scores = Array.from({ length: 4 }, () => []);
  const acc = Array.from({ length: 4 }, () => Array.from({ length: 3001 }, () => 0));
  let answer = Array.from({ length: 4 }, () => []);

  rl.on("line", (i) => {
    input.push(i.trim());
  });

  rl.on("close", () => {
    /* 메인 로직 */
    N = +input[0];
    for (let i = 0; i < 4; i++) {
      ranks[i] = Array.from({ length: N }, () => 0);
    }

    // 1 ~ 3경기 점수
    for (let i = 1; i <= 3; i++) {
      scores[i - 1] = [...input[i].split(" ").map((item) => +item)];
    }

    // 세 경기의 점수 합
    for (let i = 0; i < N; i++) {
      scores[3].push(scores[0][i] + scores[1][i] + scores[2][i]);
    }

    // 점수 누적합 배열에 각 사람이 각각의 대회에서 맞은 점수 위치 - 1에 +1
    for (let i = 0; i < N; i++) {
      for (let j = 0; j < 4; j++) {
        if (scores[j][i] - 1 < 0) continue;
        acc[j][scores[j][i] - 1]++;
      }
    }

    // 각 대회를 순회하며 누적합 계산
    for (let i = 0; i < 4; i++) {
      for (let j = i === 3 ? 2999 : 999; j >= 0; j--) {
        acc[i][j] += acc[i][j + 1];
      }
    }

    // 각 대회의 각 사람이 받은 점수에 대해 해당 점수보다 높은 점수의 사람 수 + 1를 answer에 저장
    for (let i = 0; i < 4; i++) {
      for (let j = 0; j < N; j++) {
        answer[i].push(acc[i][scores[i][j]] + 1);
      }
      answer[i] = answer[i].join(" ");
    }

    // 정답 출력
    console.log(answer.join("\n"));
    process.exit();
  });
};

solution();

