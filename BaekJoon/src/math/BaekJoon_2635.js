/**
 * BaekJoon_2635, 수 이어가기
 *  - 문제 분류: 수학, 완전탐색
 */
const solution = () => {
  /* 변수 관리 */
  const N = +require("fs").readFileSync("./dev/stdin/2635.txt").toString().trim();
  let answer = null;

  /* 메인 로직 */
  const half = Math.floor(N / 2);
  let max = 0;
  for (let i = half + 1; i <= N; i++) {
    let a = N;
    let b = i;

    let count = 2;
    const arr = [a, b];
    while (true) {
      if (a - b < 0) break;
      const temp = b;
      b = a - b;
      a = temp;
      count++;
      arr.push(b);
    }

    if (count > max) {
      answer = arr;
      max = count;
    }
  }

  /* 정답 반환 */
  return `${answer.length}\n${answer.join(" ")}`;
};

console.log(solution());

