function solution(s) {
  const arr = s.split(" ").map((itm) => itm * 1); // 입력을 숫자 배열로 변환
  let min = arr[0],
    max = arr[0];
  
  // 최대값, 최소값 도출
  for (let i = 1; i < arr.length; i++) {
    if (arr[i] < min) min = arr[i];
    if (arr[i] > max) max = arr[i];
  }
  return `${min} ${max}`;
}

console.log(solution("1 2 4 3"));
console.log(solution("-1 -2 -4 -3 5"));
