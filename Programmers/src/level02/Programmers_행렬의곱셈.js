function solution(arr1, arr2) {
  const [l, r, c] = [arr1.length, arr1[0].length, arr2[0].length];

  const answer = [];
  for (let i = 0; i < l; i++) {
    answer.push(new Array(c).fill(0));
  }

  for (let i = 0; i < l; i++) {
    for (let j = 0; j < r; j++) {
      for (let k = 0; k < c; k++) {
        answer[i][k] += arr1[i][j] * arr2[j][k];
      }
    }
  }
  return answer;
}

// console.log(
//   solution(
//     [
//       [1, 4],
//       [3, 2],
//       [4, 1],
//     ],
//     [
//       [3, 3],
//       [3, 3],
//     ]
//   )
// );

// console.log(
//   solution(
//     [
//       [2, 3, 2],
//       [4, 2, 4],
//       [3, 1, 4],
//     ],
//     [
//       [5, 4, 3],
//       [2, 4, 1],
//       [3, 1, 1],
//     ]
//   )
// );

console.log(
  solution(
    [
      [1, 2],
      [3, 4],
    ],
    [
      [5, 6, 7],
      [8, 9, 10],
    ]
  )
);
