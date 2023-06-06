const solution = (sequence, k) => {
  const len = sequence.length;
  const answer = [0, len - 1];
  let pointer = 0;
  let sum = 0;

  for (let i = 0; i < len; i++) {
    sum += sequence[i];

    while (sum > k && pointer <= i) {
      sum -= sequence[pointer++];
    }

    if (sum === k) {
      if (i - pointer < answer[1] - answer[0]) {
        [answer[0], answer[1]] = [pointer, i];
      }
    }
  }
  return answer;
};

console.log(solution([1, 2, 3, 4, 5], 7));
console.log(solution([1, 1, 1, 2, 3, 4, 5], 5));
console.log(solution([2, 2, 2, 2, 2], 6));
