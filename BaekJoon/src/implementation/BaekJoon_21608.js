/**
 * BaekJoon_21608, 상어 초등학교
 *  - 문제 분류: 구현
 *  - 시간 복잡도
 *    -> N: 3~20
 *    -> N^2: 최대 400
 *    -> 자리 찾기: (자리 수) * (4방 탐색) * (학생 수) = 400 * 4 * 400 = 640,000 / not bad
 */
const solution = () => {
  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/21608.txt").toString().trim().split("\n");
  const N = +input[0];
  const stdCount = N*N;
  const favorites = Array.from({ length: stdCount + 1 }, () => Array.from({ length: stdCount + 1 }, () => false));
  const seats = Array.from({ length: N }, () => Array.from({ length: N }, () => 0));
  const drc = [[0, 1], [0, -1], [1, 0], [-1, 0]];
  let answer = 0; // 만족도 총합

  /* 메인 로직 */
  for (let i=1; i<=stdCount; i++) {
    const [me, ...res] = input[i].split(" ").map(Number);
    for (let j=0; j<res.length; j++) {
      favorites[me][res[j]] = true;
    }

    // 1,2,3 조건을 만족하는 자리 찾기
    const [r, c] = findSeat(me);
    seats[r][c] = me;
  }

  // 만들어진 자리로 점수 도출
  answer = getScore();

  /* 정답 반환 */
  return answer;

  /* ******메서드 파트****** */
  // 조건에 맞는 자리 찾기
  function findSeat(me) {
    const seatList = [];
    for(let i=0; i<N; i++) {
      for (let j=0; j<N; j++) {
        if (seats[i][j] > 0) continue;
        let count = 0;
        let vacancies = 0;
        for (let k=0; k<drc.length; k++) {
          const [nr, nc] = [i + drc[k][0], j + drc[k][1]];
          if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
          const nearStudent = seats[nr][nc];
          if (nearStudent === 0) {
            vacancies++;
          } else if (favorites[me][nearStudent]) {
            count++;
          }
        }
        seatList.push([i, j, count, vacancies]);
      }
    }
    seatList.sort((a, b) => {
      if (a[2] === b[2]) {
        return b[3] - a[3];
      }
      return b[2] - a[2];
    });

    return [seatList[0][0], seatList[0][1]];
  }

  // 점수 도출
  function getScore() {
    let score = 0;
    for (let i=0; i<N; i++) {
      for (let j=0; j<N; j++) {
        const me = seats[i][j];
        let count = 0;
        for (let k=0; k<drc.length; k++) {
          const [nr, nc] = [i + drc[k][0], j + drc[k][1]];
          if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
          const nearStudent = seats[nr][nc];
          if (favorites[me][nearStudent]) count++;
        }

        if (count === 0) continue;
        score += Math.pow(10, count - 1);
      }
    }
    return score;
  }
}

console.log(solution());