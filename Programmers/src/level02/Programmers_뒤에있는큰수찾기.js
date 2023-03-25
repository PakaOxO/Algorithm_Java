function solution(numbers) {
  const len = numbers.length;
  const dp = new Array(len);
  const answer = new Array(len);

  const find = (val, next) => {
    // 다음 원소가 범위 밖이면 내가 제일 큼
    if (next >= len) {
      return [-1, len];
    }

    if (val < numbers[next]) {
      // 다음 원소보다 내가 작으면 다음 원소가 뒷 큰수
      return [numbers[next], next];
    } else {
      // 내가 다음 원소보다 같거나 크면 다음 원소로 넘어가서 뒷 큰수를 찾음
      return find(val, dp[next]);
    }
  };
  // 맨 뒤 원소부터 시작
  let pointer = len - 1;
  while (pointer >= 0) {
    [answer[pointer], dp[pointer]] = find(numbers[pointer], pointer + 1);
    pointer--;
  }
  return answer;
}

console.log(solution([2, 3, 3, 5]));
console.log(solution([9, 1, 5, 3, 6, 2]));
