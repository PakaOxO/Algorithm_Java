/**
 * Programmers_과제 진행하기
 *    1. 문제 분류 : 구현, 자료구조, 스택, 큐
 *    2. 접근 방법
 *      - 시간을 0초부터 점차 증가시키면서... 문제의 설명대로,
 *      - 작업의 분류를 아직 시작하지 않은 작업(convertedPlans), 현재 작업(workingPlan), 저장된 작업(savedPlans)로 나눔
 *        -> plans에서 작업할 시간이 된 작업이 있으면 해당 작업 시작(workingPlan)
 *          -> 이전에 작업하던 내용이 있으면, 스택(savedPlans)에 저장
 *        -> plans에서 꺼낼 작업이 없으면, 현재 작업(workingPlan) 진행
 *          -> 현재 작업(workingPlan)이 없었으면
 *            ->저장된 작업(savedPlans)이 있는지 체크해 꺼내 현재 작업(workingPlan)으로 넣기
 *            -> 저장된 작업(savedPlans)도 없으면 바로 다음 plans에서 실행할 작업이 있는 시간대로 타임워프
 */
const solution = (plans) => {
  /* 변수 초기화 */
  const convertedPlans = [];
  const savedPlans = []; // 스택 역할, 중단된 과제 저장
  const answer = [];

  /* 메인 로직 */
  plans.forEach((p) => {
    convertedPlans.push([p[0], timeToSeconds(p[1]), +p[2] * 60]);
  });
  convertedPlans.sort((a, b) => a[1] - b[1]);

  let time = 0;
  let workingPlan = null;
  while (convertedPlans.length > 0 || savedPlans.length > 0) {
    if (workingPlan && workingPlan[1] + workingPlan[2] === time) {
      answer.push(workingPlan[0]);
      workingPlan = null;
    }

    const p = convertedPlans[0];
    if (p && p[1] === time) {
      if (workingPlan) {
        savedPlans.push([workingPlan[0], time, workingPlan[2] - (time - workingPlan[1])]);
        workingPlan = convertedPlans.shift();
      } else {
        workingPlan = convertedPlans.shift();
      }
    }

    if (!workingPlan) {
      if (savedPlans.length > 0) {
        const s = savedPlans.pop();
        workingPlan = [s[0], time, s[2]];
      } else if (convertedPlans.length > 0) {
        time = convertedPlans[0][1] - 1;
      }
    }

    time++;
  }
  if (workingPlan) {
    answer.push(workingPlan[0]);
  }

  return answer;

  /* 시작 시간을 초로 변환 */
  function timeToSeconds(time) {
    const [h, m] = time.split(":").map((item) => +item);
    return h * 3600 + m * 60;
  }
};

console.log(
  solution([
    ["korean", "11:40", "30"],
    ["english", "12:10", "20"],
    ["math", "12:30", "40"],
  ])
);
console.log(
  solution([
    ["science", "12:40", "50"],
    ["music", "12:20", "40"],
    ["history", "14:00", "30"],
    ["computer", "12:30", "100"],
  ])
);
console.log(
  solution([
    ["aaa", "12:00", "20"],
    ["bbb", "12:10", "30"],
    ["ccc", "12:40", "10"],
  ])
);

