/**
 * BaekJoon_1914, 하노이 탑
 *  - 문제 분류: 분할 정복
 */
const solution = () => {
  /* 변수 관리 */
  const N = +require('fs').readFileSync('./dev/stdin/1914.txt').toString().trim();
  let stage = '';
  let count = BigInt(0);

  /* 메인 로직 */
  if (N <= 20) {
    count += hanoi(1, 2, 3, N);
  } else {
    count += getCount(N);
  }

  /* 정답 반환 */
  return String(count) + (N > 20 ? '' : `\n${stage.trim()}`);

  // hanoi
  function hanoi(s, m, e, x) {
    if (x === 1) {
      return move(s, e);
    }

    return hanoi(s, e, m, x - 1) + move(s, e, 1) + hanoi(m, s, e, x - 1);
  }

  // move
  function move(s, e) {
    stage += `${s} ${e}\n`;
    return BigInt(1);
  }

  // getCount
  function getCount(x) {
    if (x === 1) return BigInt(1);
    return getCount(x - 1) * BigInt(2) + BigInt(1);
  }
};

console.log(solution());

