/**
 * Programmers_기둥과 보 설치
 *  - 문제 분류: 구현
 */
const solution = (n, build_frame) => {
  /* 변수 초기화 */
  const v = Array.from({ length: n + 1 }, () => Array.from({ length: n + 1 }, () => [false, false]));
  const answer = [];

  /* 메인 로직 */
  for (let i = 0; i < build_frame.length; i++) {
    const [x, y, type, isDel] = build_frame[i];

    if (isDel === 1) {
      if (buildCheck(x, y, type)) {
        v[x][y][type] = true;
        answer.push([x, y, type]);
      }
    } else {
      remove(x, y, type);
    }
  }

  answer.sort((a, b) => {
    if (a[0] === b[0]) {
      if (a[1] === b[1]) return a[2] - b[2];
      return a[1] - b[1];
    }
    return a[0] - b[0];
  });

  /* 정답 반환 */
  return answer;

  /**
   * 기둥 또는 보 설치
   */
  function buildCheck(x, y, type) {
    if (type === 0) {
      if (y === 0) {
        return true;
      } else if (y - 1 >= 0 && v[x][y - 1][0]) {
        return true;
      } else if (x - 1 >= 0 && v[x - 1][y][1]) {
        return true;
      } else if (v[x][y][1]) {
        return true;
      }
    } else {
      if (y - 1 >= 0 && v[x][y - 1][0]) {
        return true;
      } else if (x - 1 >= 0 && v[x - 1][y][1] && x + 1 <= n && v[x + 1][y][1]) {
        return true;
      } else if (x + 1 <= n && y - 1 >= 0 && v[x + 1][y - 1][0]) {
        return true;
      }
    }
    return false;
  }

  /**
   * 기둥 또는 보 제거
   */
  function remove(x, y, type) {
    const m = answer.length;
    let temp;
    let flag = true;
    v[x][y][type] = false;

    for (let i = 0; i < m; i++) {
      const [x2, y2, type2] = answer.shift();
      if (x2 === x && y2 === y && type2 === type) {
        temp = [x2, y2, type2];
        continue;
      }

      answer.push([x2, y2, type2]);
      if (!buildCheck(x2, y2, type2)) {
        flag = false;
      }
    }

    if (!flag) {
      v[x][y][type] = true;
      answer.push(temp);
    }
  }
};

// console.log(
//   solution(5, [
//     [1, 0, 0, 1],
//     [1, 1, 1, 1],
//     [2, 1, 0, 1],
//     [2, 2, 1, 1],
//     [5, 0, 0, 1],
//     [5, 1, 0, 1],
//     [4, 2, 1, 1],
//     [3, 2, 1, 1],
//   ])
// );
console.log(
  solution(5, [
    [0, 0, 0, 1],
    [2, 0, 0, 1],
    [4, 0, 0, 1],
    [0, 1, 1, 1],
    [1, 1, 1, 1],
    [2, 1, 1, 1],
    [3, 1, 1, 1],
    [2, 0, 0, 0],
    [1, 1, 1, 0],
    [2, 2, 0, 1],
  ])
);
