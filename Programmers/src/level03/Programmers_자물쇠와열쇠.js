/**
 * Programmers_자물쇠와 열쇠
 *    - 문제 분류 : 구현, 완전 탐색
 */
const solution = (key, lock) => {
  /* 변수 초기화 */
  const [N, M] = [lock.length, key.length];
  let [minR, maxR, minC, maxC] = [N, 0, N, 0];
  let [sizeR, sizeC] = [0, 0];
  const rotatedKey = Array.from({ length: 4 }, () =>
    Array.from({ length: M }, () => Array.from({ length: M }, () => -1))
  );
  let answer = false;

  /* 메인 로직 */
  for (let i = 0; i < N; i++) {
    for (let j = 0; j < N; j++) {
      if (lock[i][j] === 1) continue;
      minR = Math.min(minR, i);
      maxR = Math.max(maxR, i);
      minC = Math.min(minC, j);
      maxC = Math.max(maxC, j);
    }
  }
  [sizeR, sizeC] = [maxR - minR, maxC - minC];

  // 열쇠 회전(0, 90, 180, 280deg)
  rotateKey(0);

  /* 정답 반환 */
  return answer;

  /**
   * 열쇠를 rotateCount만큼 90도 회전
   */
  function rotateKey(rotateCount) {
    if (rotateCount === 4) return;
    if (rotateCount === 0) {
      for (let i = 0; i < M; i++) {
        for (let j = 0; j < M; j++) {
          rotatedKey[rotateCount][i][j] = key[i][j];
        }
      }
    } else {
      for (let j = 0; j < M; j++) {
        for (let i = M - 1; i >= 0; i--) {
          rotatedKey[rotateCount][j][M - i - 1] = rotatedKey[rotateCount - 1][i][j];
        }
      }
    }

    const flag = check(rotateCount);
    if (flag) {
      answer = true;
      return;
    }
    rotateKey(rotateCount + 1);
  }

  /**
   * rotateCount만큼 회전한 열쇠와 자물쇠 비교
   */
  function check(rotateCount) {
    for (let i = 0; i < M - sizeR; i++) {
      loop: for (let j = 0; j < M - sizeC; j++) {
        for (let r = 0; r <= sizeR; r++) {
          for (let c = 0; c <= sizeC; c++) {
            if (lock[minR + r][minC + c] === rotatedKey[rotateCount][i + r][j + c]) {
              continue loop;
            }
          }
        }
        return true;
      }
    }
    return false;
  }
};

console.log(
  solution(
    [
      [0, 0, 0],
      [1, 0, 0],
      [0, 1, 1],
    ],
    [
      [1, 1, 1],
      [1, 1, 0],
      [1, 0, 1],
    ]
  )
);

