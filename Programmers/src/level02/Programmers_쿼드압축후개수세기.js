/*
  Programmers_쿼드_압축_후_개수_세기
    1. 문제 분류 : 재귀
    2. 문제 접근
      - 압축(compress)할 수 있는지 여부를 판단해(check)
        - 압축이 가능하면 압축 후 어떤 숫자로 압축했는지 리턴
        - 압축이 불가능하면 영역을 4등분해서  각 영역별로 다시 compress를 돌려 재귀 호출
*/
const solution = (arr) => {
  const answer = [0, 0];

  compress(0, 0, arr.length, arr.length);
  return answer;

  /* 메서드 */
  function check(x1, y1, x2, y2, target) {
    for (let i = x1; i < x2; i++) {
      for (let j = y1; j < y2; j++) {
        if (arr[i][j] !== target) return false;
      }
    }
    return true;
  }

  function compress(x1, y1, x2, y2) {
    const target = arr[x1][y1];
    if (x1 === x2 && y1 === y2) {
      answer[target]++;
      return;
    }

    const flag = check(x1, y1, x2, y2, target);
    if (flag) {
      answer[target]++;
    } else {
      divide(x1, y1, x2, y2);
    }
  }

  function divide(x1, y1, x2, y2) {
    const half = (x2 - x1) / 2;
    compress(x1, y1, x1 + half, y1 + half);
    compress(x1, y1 + half, x1 + half, y2);
    compress(x1 + half, y1, x2, y1 + half);
    compress(x1 + half, y1 + half, x2, y2);
  }
};

console.log(
  solution([
    [1, 1, 0, 0],
    [1, 0, 0, 0],
    [1, 0, 0, 1],
    [1, 1, 1, 1],
  ])
);
console.log(
  solution([
    [1, 1, 1, 1, 1, 1, 1, 1],
    [0, 1, 1, 1, 1, 1, 1, 1],
    [0, 0, 0, 0, 1, 1, 1, 1],
    [0, 1, 0, 0, 1, 1, 1, 1],
    [0, 0, 0, 0, 0, 0, 1, 1],
    [0, 0, 0, 0, 0, 0, 0, 1],
    [0, 0, 0, 0, 1, 0, 0, 1],
    [0, 0, 0, 0, 1, 1, 1, 1],
  ])
);
