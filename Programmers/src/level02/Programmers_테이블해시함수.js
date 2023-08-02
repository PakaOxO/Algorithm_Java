/**
 * Programmers_테이블 해시 함수
 *    1. 문제 분류 : 정렬, 구현
 *    2. 접근 방법
 *      - 문제에 설명된 대로 주어진 테이블을 정렬
 *      - row_begin부터 row_end까지 행의 요소 % i의 합에 대해 누적 XOR 연산
 */
const solution = (data, col, row_begin, row_end) => {
  /* 변수 선언부 */
  const [_, C] = [data.length, data[0].length];
  col--;
  row_begin--;
  row_end--;
  let answer = 0;

  /* 메인 로직 */
  data.sort((a, b) => {
    if (a[col] === b[col]) return b[0] - a[0];
    return a[col] - b[col];
  });

  for (let i = row_begin; i <= row_end; i++) {
    let sum = 0;
    for (let j = 0; j < C; j++) {
      sum += data[i][j] % (i + 1);
    }
    if (i === row_begin) {
      answer = sum;
    } else {
      answer ^= sum;
    }
  }

  return answer;
};

console.log(
  solution(
    [
      [2, 2, 6],
      [1, 5, 10],
      [4, 2, 9],
      [3, 8, 3],
    ],
    2,
    2,
    3
  )
);

