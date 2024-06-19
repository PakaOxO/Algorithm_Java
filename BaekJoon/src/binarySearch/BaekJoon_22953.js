/**
 * BaekJoon_22953, 도도의 음식 준비
 *  - 문제 분류: 이분 탐색
 */
const solution = () => {
  /* 변수 관리 */
  const input = require('fs').readFileSync('./dev/stdin/22953.txt').toString().trim().split('\n');
  const [N, K, C] = input[0].split(' ').map(Number);
  const time = input[1].split(' ').map(Number);

  time.sort((a, b) => b - a);

  /* 메인 로직 */
  let [left, right] = [1, K * time[N - 1]];
  const comb = [];
  getList(
    0,
    time.reduce((curr, acc) => curr + acc, 0)
  );

  while (left <= right) {
    const mid = Math.floor((left + right) / 2);
    if (check(mid) >= K) {
      right = mid - 1;
    } else {
      left = mid + 1;
    }
  }

  /* 정답 반환 */
  return left;

  // check
  function check(t) {
    let count = 0;

    for (const l of comb) {
      let c = 0;
      for (let i = 0; i < N; i++) {
        c += Math.floor(t / l[i]);
      }
      count = Math.max(count, c);
      if (count >= K) return count;
    }

    return count;
  }

  function getList(depth, sum) {
    if (depth === C || sum === N) {
      comb.push([...time]);
      return;
    }

    for (let i = 0; i < N; i++) {
      if (time[i] === 1) continue;
      time[i]--;
      getList(depth + 1, sum - 1);
      time[i]++;
    }
  }
};

console.log(solution());

