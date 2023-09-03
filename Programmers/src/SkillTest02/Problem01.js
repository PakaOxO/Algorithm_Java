/**
*   Programmers_스킬 체크 테스트 Level 2, 1 문항(구명보트)
        1. 문제 분류 : 투 포인터, 정렬, 그리디
        2. 접근 방법
            - 사람들을 무게 순으로 정렬해서 왼쪽 끝, 오른쪽 끝에서 시작하는 두개의 포인터로 두 사람의 몸무게 합을 계산(투 포인터)
            - 둘다 태울 수 있으면 포인터 두개의 위치 이동
            - 둘다 태울 수 없으면 무거운 사람만 태운 뒤 right 포인터 이동
*/
function solution(people, limit) {
  /* 변수 초기화 */
  let answer = 0;
  let [left, right] = [0, people.length - 1];

  /* 메인 로직 */
  people.sort((a, b) => a - b);

  while (left < right) {
    const sum = people[left] + people[right];
    // 무거운 사람과 가벼운 사람 무게 합이 limit보다 크면 무거운 사람을 보트에 태움
    if (sum > limit) {
      answer++;
      right--;
    } else {
      // limit 이내면 둘다 보트에 태움
      answer++;
      left++;
      right--;
    }
  }
  // 타지 못한 사람이 1명 남으면 혼자 보트에 태움
  if (left === right) answer++;
  return answer;
}

