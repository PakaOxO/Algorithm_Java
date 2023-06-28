/*
  BaekJoon_6198, 옥상 정원 꾸미기
    1. 문제 분류 : 다이나믹 프로그래밍
    2. 접근 방법
      - 가장 긴 감소하는 부분 수열과 같은 원리인듯
*/
const solution = () => {
  /* 변수 초기화 */
  const INF = 1000000001;
  let N = 0;
  let heights = [];
  let dp = null;
  let answer = 0;

  /* 초기 입력 */
  const fs = require("fs");
  const input = fs.readFileSync("./dev/stdin/6198.txt").toString().split("\n");

  N = +input[0];
  dp = new Array(N + 1).fill(0);
  dp[N] = N;

  for (let i = 0; i < N; i++) {
    heights.push(+input[i + 1]);
  }
  // 맨 마지막 빌딩 뒤에 엄청 큰 빌딩이 있다고 가정
  heights.push(INF);

  for (let i = N - 1; i >= 0; i--) {
    // 바로 뒤 빌딩부터
    for (let j = i + 1; j <= N; j++) {
      // 나보다 같거나 큰 빌딩이 있다면 내 dp값을 해당 빌딩 위치로
      if (heights[j] >= heights[i]) {
        dp[i] = j;
        break;
      } else {
        // 없으면 나보다 작은 빌딩에 dp로 저장된 위치로 이동
        j = dp[j] - 1;
      }
    }
    // 내 위치와 dp(나보다 같거나 큰 빌딩 위치)값의 차이가 벤치마킹할 수 있는 빌딩의 수
    answer += dp[i] - i - 1;
  }

  return answer;
};

console.log(solution());
