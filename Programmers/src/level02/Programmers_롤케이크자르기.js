const solution = (topping) => {
  const len = topping.length;
  const t1 = new Array(10001).fill(0);
  const t2 = new Array(10001).fill(0);
  let [c1, c2] = [0, 0];
  let answer = 0;

  for (let i = 0; i < len; i++) {
    if (t2[topping[i]] < 1) {
      c2++;
    }
    t2[topping[i]]++;
  }

  for (let i = 0; i < len; i++) {
    if (t1[topping[i]] < 1) {
      c1++;
    }

    t1[topping[i]]++;
    t2[topping[i]]--;

    if (t2[topping[i]] < 1) {
      c2--;
    }

    if (c1 === c2) {
      answer++;
    }
  }
  return answer;
};

console.log(solution([1, 2, 1, 3, 1, 4, 1, 2]));
console.log(solution([1, 2, 3, 1, 4]));
