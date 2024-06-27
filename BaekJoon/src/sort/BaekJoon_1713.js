/**
 * BaekJoon_1713, 후보 추천하기
 *  - 문제 분류: 정렬, 구현
 */
const solution = () => {
  /* 변수 관리 */
  const input = require('fs').readFileSync('./dev/stdin/1713.txt').toString().trim().split('\n');
  const N = +input[0];
  const M = +input[1];
  const arr = input[2].split(' ').map(Number);
  const pictures = Array.from({ length: N }, () => null);
  const count = Array.from({ length: 101 }, () => 0);
  const answer = [];

  /* 메인 로직 */
  for (let i = 0; i < M; i++) {
    const target = arr[i];
    let pointer = -1;
    let min = Infinity;
    let flag = true;
    count[target]++;

    for (let j = 0; j < N; j++) {
      if (pictures[j] === null || pictures[j][0] === target) {
        pointer = j;
        flag = false;
        break;
      }

      const c = count[pictures[j][0]];
      const d = pictures[j][1];

      if (c < min) {
        min = c;
        pointer = j;
      } else if (c === min && d < pictures[pointer][1]) {
        pointer = j;
      }
    }

    if (flag) count[pictures[pointer][0]] = 0;
    if (flag || pictures[pointer] === null) pictures[pointer] = [target, i];
  }

  pictures.forEach((item) => {
    if (item) answer.push(item[0]);
  });
  answer.sort((a, b) => a - b);

  /* 정답 반환 */
  return answer.join(' ');
};

console.log(solution());

