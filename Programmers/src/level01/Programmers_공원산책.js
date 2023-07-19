/**
 * Programmers_공원 산책
 *    1. 문제 분류 : 구현
 *    2. 접근 방법
 *      - 전체 맵을 저장할 배열을 반복문을 돌면서 만듦.
 *      - 맵을 만드는 과정에서 시작 위치를 저장
 *      - 이동 방향(E, W, S, N)에 따라 이동할 방향 단위 좌표를 저장한 해시 맵을 지정
 */
const solution = (park, routes) => {
  /* 변수 선언부 */
  let answer = [0, 0];
  const unitPath = {
    N: [-1, 0],
    S: [1, 0],
    E: [0, 1],
    W: [0, -1],
  };
  const h = park.length;
  const w = park[0].length;
  const map = Array.from({ length: h }, () => []);

  /* 메인 로직부 */
  // 맵 저장
  for (let i = 0; i < h; i++) {
    for (let j = 0; j < w; j++) {
      const char = park[i].charAt(j);
      if (char === "S") {
        answer = [i, j];
      }
      map[i].push(char);
    }
  }

  // 경로 이동
  for (let i = 0; i < routes.length; i++) {
    const [dir, size] = routes[i].split(" ");
    let flag = false;
    let next = [...answer];
    for (let j = 0; j < size; j++) {
      next[0] += unitPath[dir][0];
      next[1] += unitPath[dir][1];
      if (
        next[0] < 0 ||
        next[1] < 0 ||
        next[0] >= h ||
        next[1] >= w ||
        map[next[0]][next[1]] === "X"
      ) {
        flag = true;
        break;
      }
    }

    if (flag) continue;
    answer = next;
  }
  return answer;
};

console.log(solution(["SOO", "OOO", "OOO"], ["E 2", "S 2", "W 1"]));
console.log(solution(["SOO", "OXX", "OOO"], ["E 2", "S 2", "W 1"]));
console.log(solution(["OSO", "OOO", "OXO", "OOO"], ["E 2", "S 3", "W 1"]));
