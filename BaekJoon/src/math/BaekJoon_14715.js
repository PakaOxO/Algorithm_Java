/**
 * BaekJoon_14715, 전생했더니 슬라임 연구자였던 건에 대하여(Easy)
 *    1. 문제 분류 : 수학
 *    2. 접근 방법
 *      - 약수의 개수를 찾아야 함
 *      - 현재 수(K부터 시작)에 대해 2부터 제곱근까지 순회하면서 나누어떨어지는 수를 찾음
 *        -> 약수를 찾으면 나눈 뒤, 남은 수에 대해 위 과정을 반복
 */
const solution = () => {
  /* 변수 초기화 */
  let K = +require("fs").readFileSync("./dev/stdin/14715.txt").toString().trim();
  let count = 1;

  /* 메인 로직 */
  countDivider(K);

  return Math.ceil(Math.log2(count));

  /* 약수의 개수 */
  function countDivider(x) {
    const sqrt = ~~Math.sqrt(x, 2);
    for (let i = 2; i <= sqrt; i++) {
      if (x % i === 0) {
        countDivider(x / i);
        count++;
        break;
      }
    }
  }
};

console.log(solution());
