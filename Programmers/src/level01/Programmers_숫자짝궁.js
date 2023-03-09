function solution(X, Y) {
  const cntX = new Array(10).fill(0);
  const cntY = new Array(10).fill(0);

  const lenX = X.length;
  const lenY = Y.length;
  const lenMax = Math.max(lenX, lenY);

  for (let i = 0; i < lenMax; i++) {
    if (i < lenX) {
      cntX[X.charAt(i) * 1]++;
    }
    if (i < lenY) {
      cntY[Y.charAt(i) * 1]++;
    }
  }

  let answer = "";
  for (let i = 9; i >= 0; i--) {
    const minCnt = Math.min(cntX[i], cntY[i]);
    if (minCnt > 0) {
      answer += (i + "").repeat(minCnt);
    }
  }
  if (answer.length === 0) return "-1";
  else if (answer * 1 === 0) return "0";
  return answer;
}

console.log(solution("100", "2345"));
console.log(solution("100", "203045"));
console.log(solution("100", "123450"));
console.log(solution("12321", "42531"));
console.log(solution("5525", "1255"));
