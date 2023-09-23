/**
 * BaekJoon_20056, 마법사 상어와 파이어볼
 *  - 문제 분류 : 구현
 */
const solution = () => {
  /* 파이어볼 클래스, 위치(r, c), 질량(m), 속력(s), 방향(d) 정보 */
  class FireBall {
    constructor(r, c, m, s, d) {
      this.r = r;
      this.c = c;
      this.m = m;
      this.s = s;
      this.d = d;
    }
  }

  /* 변수 초기화 */
  const input = require("fs").readFileSync("./dev/stdin/20056.txt").toString().split("\n");
  let [N, M, K] = input[0].split(" ").map((item) => +item);
  const q = [];
  const drc = [
    [-1, 0],
    [-1, 1],
    [0, 1],
    [1, 1],
    [1, 0],
    [1, -1],
    [0, -1],
    [-1, -1],
  ];
  const map = Array.from({ length: N }, () => Array.from({ length: N }, () => []));

  for (let i = 1; i <= M; i++) {
    const [r, c, m, s, d] = input[i].split(" ").map((item) => +item);
    const fireball = new FireBall(r - 1, c - 1, m, s, d);
    q.push(fireball);
  }

  /* 메인 로직 */
  while (K > 0) {
    move();
    spread();
    K--;
  }

  /* 정답 반환 */
  return getTotalMass();

  /**
   * 파이어볼 이동
   */
  function move() {
    const len = q.length;
    for (let i = 0; i < len; i++) {
      const fireball = q.shift();
      let [nr, nc] = [fireball.r + drc[fireball.d][0] * fireball.s, fireball.c + drc[fireball.d][1] * fireball.s];
      while (nr < 0) nr += N;
      while (nc < 0) nc += N;
      while (nr >= N) nr -= N;
      while (nc >= N) nc -= N;
      map[nr][nc].push(new FireBall(nr, nc, fireball.m, fireball.s, fireball.d));
    }
  }

  /**
   * 파이어볼 합친 뒤 나누기
   */
  function spread() {
    for (let i = 0; i < N; i++) {
      for (let j = 0; j < N; j++) {
        if (map[i][j].length === 0) continue;
        if (map[i][j].length === 1) {
          q.push(map[i][j].pop());
        } else {
          let mass = 0;
          let count = 0;
          let speed = 0;
          const directions = [];
          while (map[i][j].length > 0) {
            const fireball = map[i][j].pop();
            mass += fireball.m;
            count++;
            speed += fireball.s;
            directions.push(fireball.d);
          }

          mass = Math.floor(mass / 5);
          if (mass === 0) continue;
          if (check(directions)) {
            q.push(new FireBall(i, j, mass, Math.floor(speed / count), 0));
            q.push(new FireBall(i, j, mass, Math.floor(speed / count), 2));
            q.push(new FireBall(i, j, mass, Math.floor(speed / count), 4));
            q.push(new FireBall(i, j, mass, Math.floor(speed / count), 6));
          } else {
            q.push(new FireBall(i, j, mass, Math.floor(speed / count), 1));
            q.push(new FireBall(i, j, mass, Math.floor(speed / count), 3));
            q.push(new FireBall(i, j, mass, Math.floor(speed / count), 5));
            q.push(new FireBall(i, j, mass, Math.floor(speed / count), 7));
          }
        }
      }
    }
  }

  /**
   * 속도들을 받아 다음 속도 반환
   */
  function check(directions) {
    let isOdd = false;
    let isEven = false;
    for (let i = 0; i < directions.length; i++) {
      const f = directions[i] % 2 === 0;
      if (f) {
        if (isOdd) return false;
        isEven = true;
      } else {
        if (isEven) return false;
        isOdd = true;
      }
    }
    return true;
  }

  /**
   * 남은 파이어볼의 총 질량
   */
  function getTotalMass() {
    let mass = 0;
    while (q.length > 0) {
      const fireball = q.pop();
      mass += fireball.m;
    }
    return mass;
  }
};

console.log(solution());
