function solution(t, p) {
  let answer = 0;
  const len = p.length;
  const end = t.length;

  let right = len;
  let str = t.slice(0, len);
  const arr = t.split("");
  while (right <= end) {
    if (str * 1 <= p * 1) {
      answer++;
    }

    str = str.substring(1);
    str += arr[right++];
  }
  return answer;
}
