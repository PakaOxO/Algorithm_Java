/**
 * BaekJoon_22251, 빌런 호석
 *  - 문제 분류: 구현, 완전 탐색
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/22251.txt").toString().split("\n");
  const [N, K, P, X] = input[0].split(" ").map((item) => +item);
  const SIZE = 10;
  const bit = [
    "1111110",
    "0110000",
    "1101101",
    "1111001",
    "0110011",
    "1011011",
    "1011111",
    "1110000",
    "1111111",
    "1111011",
  ];
  const costs = Array.from({ length: SIZE }, () => Array.from({ length: SIZE }, () => 0));
  let answer = 0;

  /* 메인 로직 */
  for (let i = 0; i < SIZE; i++) {
    for (let j = i + 1; j < SIZE; j++) {
      const binary = (parseInt(bit[i], 2) ^ parseInt(bit[j], 2)).toString(2);
      const cost = binary.match(/1/g)?.length || 0;
      costs[i][j] = cost;
      costs[j][i] = cost;
    }
  }

  for (let i = 1; i <= N; i++) {
    let cost = 0;
    let [a, b] = [X, i];
    for (let j = 0; j < K; j++) {
      cost += costs[a % 10][b % 10];
      a = Math.floor(a / 10);
      b = Math.floor(b / 10);
    }

    if (cost > 0 && cost <= P) {
      answer++;
    }
  }

  /* 정답 반환 */
  return answer;
};

console.log(solution());

