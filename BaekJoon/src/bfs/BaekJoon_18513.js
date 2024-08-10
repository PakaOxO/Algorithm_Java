/**
 * BaekJoon_18513, 샘터
 *  - 문제 분류: 너비 우선 탐색, 집합
 */
const solution = () => {
  /* 변수 관리 */
  const input = require('fs').readFileSync('./dev/stdin/18513.txt').toString().trim().split('\n');
  const [N, K] = input[0].split(' ').map(Number);
  const set = new Set();
  let count = 0;
  const arr = input[1].split(' ').map((val) => {
    const num = +val;
    set.add(num);
    return [num, num, num];
  });
  const arr2 = [];
  let answer = 0;

  /* 메인 로직 */
  while (count < K) {
    while (count < K && arr.length > 0) {
      const pos = arr.pop();
      const sum = check(pos);
      if (sum === 0) continue;

      answer += sum;
      arr2.push(pos);
    }

    while (count < K && arr2.length > 0) {
      const pos = arr2.pop();
      const sum = check(pos);
      if (sum === 0) continue;

      answer += sum;
      arr.push(pos);
    }
  }

  /* 정답 반환 */
  return answer;

  // check
  function check(pos) {
    let sum = 0;

    if (count < K && !set.has(pos[0] - 1)) {
      pos[0]--;
      set.add(pos[0]);
      sum += pos[1] - pos[0];
      count++;
    }

    if (count < K && !set.has(pos[2] + 1)) {
      pos[2]++;
      set.add(pos[2]);
      sum += pos[2] - pos[1];
      count++;
    }

    return sum;
  }
};

console.log(solution());

