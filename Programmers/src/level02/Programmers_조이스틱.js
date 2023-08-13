/**
 * Programmers_조이스틱
 *    1. 문제 분류 : 그리디, 구현
 *    2. 접근 방법(**풀이 실패)
 *      - 결국 알파벳 변환 횟수는 고정임 -> 최소 이동거리를 구해야하는 문제
 *      - 내 위치 기준 우측에 'A'의 묶음(1개 이상)이 발견되면
 *        -> 오른쪽으로 되돌아가는 길이(내 인덱스 * 2) + 우측 끝에서 A의 묶음이 끝날 때까지 길이
 *        -> 왼쪽으로 갔다 되돌아가는 길이(우측 A의 묶음 길이를 제외한 나머지 길이) + 내 위치에서 A의 묶음을 만날때까지 길이
 *
 */
const solution = (name) => {
  /* 변수 초기화 */
  const len = name.length;
  let answer = 0;
  let move = len - 1; // 최대 이동 거리는 결국 오른쪽으로 쭉 이동하는 것

  /* 메인 로직 */
  for (let i = 0; i < len; i++) {
    // 만약 바꿔야하는 알파벳이 있다면 최소의 조작으로 변환
    answer += Math.min(name.charCodeAt(i) - "A".charCodeAt(0), "Z".charCodeAt(0) - name.charCodeAt(i) + 1);

    // 현재 내 위치 기준 우측 'A'의 개수 카운트
    let j = i + 1;
    let aCount = 0;
    while (j < len && name.charAt(j) === "A") {
      aCount++;
      j++;
    }

    move = Math.min(move, i * 2 + len - i - 1 - aCount);
    move = Math.min(move, (len - (i + 1 + aCount)) * 2 + i);
  }

  /* 정답 반환 */
  return answer + move;
};

console.log(solution("JAZ"));
console.log(solution("JEROEN"));
console.log(solution("JAN"));
console.log(solution("AABAA"));
console.log(solution("AABABBBBB"));
// console.log(solution("BBBBBBBBBBBBBBBBBBBB"));
