/**
 * Programmers_행렬 테두리 회전하기
 *  1. 문제 분류 : 배열, 구현
 *  2. 접근 방법
 *    - 테두리를 회전시키는 로직을 먼저 구현
 *    - 회전시키는 원소들 중 가장 작은 값을 array에 저장
 */
const solution = (rows, columns, queries) => {
  /* 변수 선언부 */
  const answer = [];
  const arr = [];

  /* 메인 로직 */
  initArr(rows, columns);
  for (let i = 0; i < queries.length; i++) {
    const [r1, c1, r2, c2] = queries[i];
    const min = rotate(r1, c1, r2, c2);
    answer.push(min);
  }

  return answer;

  /* 메서드 */
  // 행렬 초기화
  function initArr(R, C) {
    let cnt = 1;
    for (let i = 0; i < R; i++) {
      arr.push([]);
      for (let j = 0; j < C; j++) {
        arr[i].push(cnt++);
      }
    }
  }

  // 행렬 범위 회전
  function rotate(r1, c1, r2, c2) {
    [r1--, c1--, r2--, c2--];
    let [r, c] = [r1, c1];
    let prev = arr[r1 + 1][c1];
    let flag = 0;
    let min = prev;

    while (flag < 4) {
      prev = swap(r, c, prev);
      if (flag === 0) {
        c++;
        if (c === c2) flag++;
      } else if (flag === 1) {
        r++;
        if (r === r2) flag++;
      } else if (flag === 2) {
        c--;
        if (c === c1) flag++;
      } else {
        r--;
        if (r === r1) flag++;
      }
      min = Math.min(prev, min);
    }
    return min;
  }

  function swap(r, c, prev) {
    const curr = arr[r][c];
    arr[r][c] = prev;
    return curr;
  }
};

console.log(
  solution(6, 6, [
    [2, 2, 5, 4],
    [3, 3, 6, 6],
    [5, 1, 6, 3],
  ])
);
console.log(
  solution(3, 3, [
    [1, 1, 2, 2],
    [1, 2, 2, 3],
    [2, 1, 3, 2],
    [2, 2, 3, 3],
  ])
);
console.log(solution(100, 97, [[1, 1, 100, 97]]));
