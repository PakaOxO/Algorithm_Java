/**
 * Softeer_업무 처리
 *      1. 문제 분류 : 트리, 구현
 *      2. 접근 방법
 *          - 우선 배열을 활용해 이진 트리를 구현
 *          - 각 업무에 대해 말단 직원들에 해당 업무를 부여
 *          - 말단 직원부터 상사로 이동하면서 업무를 처리하도록
 *              -> 상사로 이동하려면 부모의 정보를 가지고 있어야겠군
 *              -> 배열로 트리를 구현한다면 자신의 인덱스를 2로 나눈 몫이 상사
 *          - 트리를 만들었다면 문제에서 주어진대로 구현
 */
const solution = () => {
  const rl = require("readline").createInterface({
    input: process.stdin,
    ouput: process.stdout,
  });

  /* 변수 초기화 */
  const input = [];
  const member = [null];
  let memberCount = 0;
  const works = [null];
  let [H, K, R] = [0, 0, 0];
  let answer = 0;

  rl.on("line", (i) => {
    input.push(i.trim());
  });

  rl.on("close", () => {
    /* 메인 로직 */
    [H, K, R] = input[0].split(" ").map((item) => +item);

    // 트리 구조로 직원 추가
    for (let i = 0; i <= H; i++) {
      for (let j = 0; j < Math.pow(2, i); j++) {
        member.push(Math.pow(2, i) + j);
        memberCount++;
        works.push([[], []]); // 각각 왼쪽 부하직원, 오른쪽 부하직원에게 받은 업무
      }
    }

    // 말단 직원에 업무 배정
    for (let i = 0; i < Math.pow(2, H); i++) {
      works[Math.pow(2, H) + i][0] = [...input[i + 1].split(" ").map((item) => +item)];
    }

    // 상사 직원부터 쌓여있는 일이 있다면 해당 일을 처리
    for (let day = 0; day < R; day++) {
      for (let m = 1; m <= memberCount; m++) {
        doWork(m, day);
      }
    }
    /* 정답 출력 */
    console.log(answer);
    process.exit();
  });

  /* 작업 처리 */
  function doWork(mIdx, day) {
    const isLeaf = mIdx >= Math.pow(2, H);
    const parent = ~~(mIdx / 2);

    if (isLeaf) {
      if (works[mIdx][0].length === 0) return;
      works[parent][mIdx % 2].push(works[mIdx][0].shift());
    } else {
      if (works[mIdx][day % 2].length === 0) return;
      const w = works[mIdx][day % 2].shift();
      if (parent === 0) {
        answer += w;
      } else {
        works[parent][mIdx % 2].push(w);
      }
    }
  }
};

solution();

