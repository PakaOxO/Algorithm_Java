function solution(s) {
  let answer = 0;

  let lCnt = 1;
  let rCnt = 0;
  let lPointer = 0;
  let rPointer = 1;
  while (rPointer < s.length) {
    if (s.charAt(lPointer) !== s.charAt(rPointer)) {
      rCnt++;
    } else {
      lCnt++;
    }

    if (rCnt === lCnt) {
      lPointer = rPointer + 1;
      rPointer = lPointer + 1;
      lCnt = 1;
      rCnt = 0;
      answer++;
    } else {
      rPointer++;
    }
  }
  if (lPointer !== s.length && rPointer >= s.length) answer++;
  return answer;
}

console.log(solution("banana"));
console.log(solution("abracadabra"));
console.log(solution("aaabbaccccabba"));
console.log(solution("a"));
