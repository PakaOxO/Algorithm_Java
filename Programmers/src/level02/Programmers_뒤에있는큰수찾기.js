function solution(numbers) {
  const len = numbers.length;
  const dp = Array.from(Array(len), () => new Array(2));
  const answer = new Array(len);

  const find = (curr, target) => {
    if (target >= len) {
      return -1;
    }

    if (numbers[curr] < numbers[target]) {
      return numbers[target];
    } else {
      find(target, dp[target]);
    }
  };

  let pointer = len - 1;
  while (pointer >= 0) {
    dp[pointer] = find(pointer, pointer + 1);
  }
  return answer;
}

console.log(solution([2, 3, 3, 5]));
console.log(solution([9, 1, 5, 3, 6, 2]));
