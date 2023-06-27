/*
  Programmers_기지국_설치
    1. 문제 분류 : 포인터
    2. 접근 방법
       - 체크해야할 건 3가지, 현재 위치가
          - 현재 포인터가 위치한 기지국 범위 왼쪽 -> 새로 기지국을 설치한 뒤 새로 설치된 기지국 커버 범위 이후로 현재 위치를 이동
          - 현재 포인터가 위치한 기지국 범위 오른쪽 -> 포인터를 한칸 이동해 다음 기지국을 가리킴
          - 현재 포인터가 위치한 기지국 범위 이내 -> 위치를 기지국 커버 범위 종료지점으로 이동
*/
const solution = (n, stations, w) => {
  /* 초기 변수 */
  let answer = 0;
  let [pointer, max] = [0, stations.length];

  for (let i = 1; i <= n; i++) {
    if (i < stations[pointer] - w) {
      answer++;
      i += w * 2;
    } else if (i > stations[pointer] + w) {
      if (pointer < max - 1) {
        pointer++;
        i--;
      } else {
        answer++;
        i += w * 2;
      }
    } else {
      if (pointer < max - 1) {
        i = stations[pointer++] + w;
      }
    }
  }

  return answer;
};

console.log(solution(11, [4, 11], 1));
console.log(solution(16, [9], 2));
