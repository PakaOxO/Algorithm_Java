const solution = (routes) => {
  const N = routes.length;
  routes.sort((a, b) => a[1] - b[1]);

  let pos = -30001;
  let answer = 0;
  for (let i = 0; i < N; i++) {
    if (pos >= routes[i][0] && pos <= routes[i][1]) continue;
    pos = routes[i][1];
    answer++;
  }

  return answer;
};

console.log(
  solution([
    [-20, -15],
    [-14, -5],
    [-18, -13],
    [-5, -3],
  ])
);
// console.log(
//   solution([
//     [-20, -17],
//     [-18, -17],
//     [-17, -13],
//     [-17, 1],
//   ])
// );
