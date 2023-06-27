/*
  Programmers_소수찾기
    1. 문제 분류 : 조합론, 수학
    2. 접근 방법
      - 모든 조합을 탐색해 나올 수 있는 모든 숫자를 구함
      - 각 숫자에 대해 소수인지 판별 후, 처음 탐색된 소수일 경우 카운트 증가
*/

const solution = (numbers) => {
  /* 변수 초기화 */
  let answer = 0;
  const INF = 1000000;
  const arr = numbers.split("").map((item) => +item);
  const size = arr.length;
  const visited = new Array(size).fill(false);
  const isPrime = new Array(INF).fill(true);
  const check = new Array(INF).fill(false);

  /* 메인 로직 */
  checkPrimeNumber();
  perm(0, 0);
  return answer;

  function checkPrimeNumber() {
    isPrime[0] = isPrime[1] = false;
    for (let i = 2; i * i < INF; i++) {
      if (!isPrime[i]) continue;
      isPrime[i] = true;
      for (let j = i * i; j < INF; j += i) {
        isPrime[j] = false;
      }
    }
  }

  function perm(depth, num) {
    if (depth > 0 && !check[num]) {
      if (isPrime[num]) {
        answer++;
      }
      check[num] = true;
    }
    if (depth === size) return;

    for (let i = 0; i < size; i++) {
      if (visited[i]) continue;
      visited[i] = true;
      perm(depth + 1, num * 10 + arr[i]);
      visited[i] = false;
    }
  }
};

console.log(solution("17"));
console.log(solution("011"));
