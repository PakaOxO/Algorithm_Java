function solution(n, t, m, p) {
  let answer = "";
  loop: for (let i = 0, num = 0, cnt = 0; cnt < t; num++) {
    // js 진법 변환 메서드..
    const str = num.toString(n);
    for (let j = 0; j < str.length; j++) {
      if (i + 1 === p) {
        answer +=
          str[j] >= "a" && str[j] <= "f" ? str[j].toUpperCase() : str[j]; // a~f는 대문자로
        cnt++;
        if (cnt === t) break loop;
      }
      i = (i + 1) % m;
    }
  }
  return answer;
}

console.log(solution(2, 4, 2, 1));
console.log(solution(16, 16, 2, 1));
console.log(solution(16, 16, 2, 2));
