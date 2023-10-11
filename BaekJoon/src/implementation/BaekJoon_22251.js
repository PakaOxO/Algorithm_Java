/**
 * BaekJoon_22251, 빌런 호석
 *  - 문제 분류: 구현, 완전 탐색
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/22251.txt").toString().split("\n");
  const on = [
    [true, true, true, true, true, true, false],
    [false, true, true, false, false, false, false],
    [true, true, false, true, true, false, true],
    [true, true, true, true, false, false, true],
    [false, true, true, false, false, true, true],
    [true, false, true, true, false, true, true],
    [true, false, true, true, true, true, true],
    [true, true, true, false, false, false, false],
    [true, true, true, true, true, true, true],
    [true, true, true, true, false, true, true],
  ];
  const COUNT = 7;
  const [N, K, P, X] = input[0].split(" ").map((item) => +item);
  let strX = "" + X;
  const arrX = [];
  const set = new Set();

  /* 메인 로젝 */
  strX = strX.padStart(K, "0");
  for (let i = 0; i < K; i++) {
    arrX.push(+strX.charAt(i));
  }
  dfs(0, P, 0);

  /* 정답 반환 */
  return set.size;

  /**
   * 위치(pos)의 숫자(A)를 다른 숫자(B)로 전환하는데 필요한 반전 개수
   */
  function convert(from, to) {
    let count = 0;
    for (let i = 0; i < COUNT; i++) {
      if (on[from][i] !== on[to][i]) count++;
    }
    return count;
  }

  /**
   * 특정 위치(pos)를 반전시키기 위해 남은 횟수(res)
   */
  function dfs(start, res, v) {
    if (start === K && v > 0) {
      const num = +arrX.join("");

      if (num > 0 && num <= N && num !== X) {
        set.add(num);
      }
    }

    for (let i = start; i < K; i++) {
      dfs(i + 1, res, v);

      const num = arrX[i];
      for (let j = 0; j < 10; j++) {
        if (j == num) continue;

        const count = convert(num, j);
        if (count > res) continue;

        arrX[i] = j;
        dfs(i + 1, res - count, v + 1);
        arrX[i] = num;
      }
    }
  }
};

console.log(solution());
