const solution = (routes) => {
  let size = 0;
  routes.forEach((r) => {
    size = Math.max(size, Math.abs(r[0]), Math.abs(r[1]));
  });

  const acc = new Array(size * 2 + 2).fill(0);

  routes.forEach((r) => {
    acc[r[0] + size]++;
    acc[r[1] + size + 1]--;
  });

  for (let i = 1; i < size * 2 + 2; i++) {
    acc[i] += acc[i - 1];
  }
  console.log(acc);
  let answer = 0;

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
