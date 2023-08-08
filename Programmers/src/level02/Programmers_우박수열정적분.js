/**
 * Programmers_우박수열 정적분
 *    1. 문제 분류 : 수학, 구현
 *    2. 접근 방법
 *      - 문제에 주어진 대로 우박수열을 구해 배열에 넣음
 *      - 각 단위 길이(1)에 대해 정적분한 결과는
 *        -> 양측 꼭지점에 대해 높이가 낮은 부분으로 만들어지는 사각형의 넓이와 그 사각형 위 두 꼭지점으로 그려지는 삼각형 넓이의 합
 *      - 각 range(from ~ to)에 대해 to가 from보다 작으면 정적분 값은 -1 아니면 위의 방법으로 넓이를 구해 넓이 배열에서 구간 넓이들을 누적합
 */
const solution = (k, ranges) => {
  /* 변수 초기화 */
  let answer = [];
  const sum = [0];
  const points = [k];
  let pointer = 0;

  /* 메인 로직 */
  while (k !== 1) {
    pointer++;
    if (k % 2 === 0) {
      k /= 2;
    } else {
      k = k * 3 + 1;
    }
    points.push(k);
  }

  for (let i = 0; i < pointer; i++) {
    const [h1, h2] = [points[i], points[i + 1]];
    if (h1 <= h2) {
      sum.push(h1 + (h2 - h1) / 2);
    } else {
      sum.push(h2 + (h1 - h2) / 2);
    }
  }

  ranges.forEach((range) => {
    let [from, to] = range;
    to += pointer;
    if (to < from) answer.push((-1).toFixed(1));
    else {
      let acc = 0;
      for (let i = from + 1; i <= to; i++) {
        acc += sum[i];
      }
      answer.push(acc.toFixed(1));
    }
  });

  /* 정답 반환 */
  return answer;
};

console.log(
  solution(5, [
    [0, 0],
    [0, -1],
    [2, -3],
    [3, -3],
  ])
);

