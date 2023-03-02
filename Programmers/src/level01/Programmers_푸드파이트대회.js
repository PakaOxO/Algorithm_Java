function solution(food) {
  let left = "";
  let right = "";
  const len = food.length;
  for (let i = 1; i < len; i++) {
    const share = food[i] % 2 === 0 ? food[i] / 2 : (food[i] - 1) / 2;
    const str = (i + "").repeat(share);
    left += str;
    right = str + right;
  }
  return left + "0" + right;
}

console.log(solution([1, 3, 4, 6]));
console.log(solution([1, 7, 1, 2]));
