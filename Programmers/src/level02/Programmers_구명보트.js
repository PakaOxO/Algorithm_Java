function solution(people, limit) {
  let answer = 0;

  people.sort((a, b) => a - b); // 무게 순서대로 정렬, 내부 정렬 기준을 정의하지 않으면 js는 숫자도 문자처럼 정렬된다.
  let left = 0;
  let right = people.length - 1;
  while (left < right) {
    if (people[left] + people[right] <= limit) {
      left++;
    }
    right--;
    answer++;
  }

  if (left === right) answer++;
  return answer;
}

// console.log(solution([70, 50, 80, 50], 100));
// console.log(solution([70, 80, 50], 100));
// console.log(solution([40, 30, 10], 40));
console.log(solution([40, 100, 90, 90], 130));
