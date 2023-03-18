function solution(numbers, hand) {
  const keypad = [
    [3, 1],
    [0, 0],
    [0, 1],
    [0, 2],
    [1, 0],
    [1, 1],
    [1, 2],
    [2, 0],
    [2, 1],
    [2, 2],
    [3, 0],
    [3, 2],
  ];

  const getDist = (idx1, idx2) => {
    return (
      Math.abs(keypad[idx1][0] - keypad[idx2][0]) +
      Math.abs(keypad[idx1][1] - keypad[idx2][1])
    );
  };

  const nextIsLeft = (number) => {
    left = number;
    answer += "L";
  };

  const nextIsRight = (number) => {
    right = number;
    answer += "R";
  };

  let left = 10;
  let right = 11;
  let answer = "";

  for (const number of numbers) {
    if ([1, 4, 7].includes(number)) {
      nextIsLeft(number);
    } else if ([3, 6, 9].includes(number)) {
      nextIsRight(number);
    } else {
      const lDist = getDist(left, number);
      const rDist = getDist(right, number);
      if (lDist < rDist) {
        nextIsLeft(number);
      } else if (lDist > rDist) {
        nextIsRight(number);
      } else {
        if (hand === "left") {
          nextIsLeft(number);
        } else {
          nextIsRight(number);
        }
      }
    }
  }

  return answer;
}

console.log(solution([1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5], "right"));
console.log(solution([7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2], "left"));
console.log(solution([1, 2, 3, 4, 5, 6, 7, 8, 9, 0], "right"));
