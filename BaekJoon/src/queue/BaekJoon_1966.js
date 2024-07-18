/**
 * BaekJoon_1966, 프린터 큐
 *  - 문제 분류: 큐, 구현
 */
const solution = () => {
  /* 변수 관리 */
  const input = require('fs').readFileSync('./dev/stdin/1966.txt').toString().trim().split('\n');
  const T = +input[0];
  let pointer = 1;
  const answer = [];

  /* 메인 로직 */
  for (let t = 0; t < T; t++) {
    const [N, M] = input[pointer++].split(' ').map(Number);
    const q = input[pointer++].split(' ').map(Number);
    let pos = M;

    const count = Array.from({ length: 10 }, () => 0);
    let a = 0;
    q.forEach((val) => count[val]++);

    while (q.length > 0) {
      const val = q[0];
      let flag = true;

      for (let i = val + 1; i < 10; i++) {
        if (count[i] === 0) continue;
        flag = false;
        break;
      }

      if (flag) {
        const v = q.shift();
        count[v]--;
        a++;

        if (pos === 0) {
          break;
        } else {
          pos--;
        }
      } else {
        q.push(q.shift());
        if (pos === 0) {
          pos = q.length - 1;
        } else {
          pos--;
        }
      }
    }

    answer.push(a);
  }

  /* 정답 반환 */
  return answer.join('\n');
};

console.log(solution());

