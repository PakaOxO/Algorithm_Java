function solution(numbers, hand) {
  // 숫자별 키패드 위치 저장, (10: "*", 11: "#")
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

  // 두 번호(idx)간 거리를 리턴하는 함수
  const getDist = (idx1, idx2) => {
    return (
      Math.abs(keypad[idx1][0] - keypad[idx2][0]) +
      Math.abs(keypad[idx1][1] - keypad[idx2][1])
    );
  };

  // 왼손이 다른 키패드로 이동했을 때
  const nextIsLeft = (number) => {
    left = number;
    answer += "L";
  };

  // 오른손이 다른 키패드로 이동했을 때
  const nextIsRight = (number) => {
    right = number;
    answer += "R";
  };

  // 초기 손의 위치
  let left = 10,
    right = 11;
  let answer = "";

  // 모든 입력 번호
  for (const number of numbers) {
    if ([1, 4, 7].includes(number)) {
      // 다음 번호가 1, 4, 7 중 하나일 경우
      nextIsLeft(number);
    } else if ([3, 6, 9].includes(number)) {
      // 다음 번호가 3, 6, 9 중 하나일 경우
      nextIsRight(number);
    } else {
      // 현재 손(왼/오)의 위치에서 다음 키패드의 거리 비교
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
