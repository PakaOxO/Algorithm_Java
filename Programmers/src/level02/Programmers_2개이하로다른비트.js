const solution = (numbers) => {
  const answer = [];
  const len = numbers.length;

  for (let i = 0; i < len; i++) {
    const num = numbers[i];

    let binary = num.toString(2);

    let left = binary.length - 1;
    let right = left;

    while (left >= 0) {
      if (binary.charAt(left) === "0") break;
      left--;
    }

    let str = left >= 0 ? binary.slice(0, left) : "";
    str += "1";
    for (let i = left + 1; i < right + 1; i++) {
      if (i === left + 1) {
        str += "0";
      } else {
        str += "1";
      }
    }
    answer.push(parseInt(str, 2));
  }

  return answer;
};

console.log(solution([2, 7, 9]));
