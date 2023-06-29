const { count } = require("console");

/*
  BaekJoon_2697, 비슷한 단어
    1. 문제 분류 : 문자열, 구현
    2. 접근 방법
      - 문자 비교 구현이 조금 어려웠음
      - 문자 길이가 같을 땐 1개의 글자가 교체된 것이므로,
        - 글자 개수의 차이가 0이면서 변경된 글자가 2개 이거나,
        - 글자 개수의 차이가 0이면서 변경된 글자가 0개이어야 함
*/
const solution = () => {
  /* 변수 초기화 */
  let answer = 0;
  let N = 0;
  let basicCnt = null;
  let basicWord = "";

  /* 초기 입력 */
  const fs = require("fs");
  const input = fs.readFileSync("./dev/stdin/2607.txt").toString().split("\n");

  N = +input[0];
  basicWord = input[1].trim();
  basicCnt = countAlphabets(basicWord);

  for (let i = 2; i <= N; i++) {
    const target = input[i].trim();
    const targetCnt = countAlphabets(target);
    if (check(basicWord, target, basicCnt, targetCnt)) {
      answer++;
    }
  }

  return answer;

  function countAlphabets(str) {
    const cnt = new Array(26).fill(0);
    for (let i = 0; i < str.length; i++) {
      const idx = str.charCodeAt(i) - 65;
      cnt[idx]++;
    }
    return cnt;
  }

  function check(basic, target, bArr, tArr) {
    // 앞에서 부터 빠진게 있는지, 추가된게 있는지, 바뀐게 있는지
    const [bLen, tLen] = [basic.length, target.length];
    let sum = 0;
    if (bLen <= tLen) {
      if (bLen === tLen) {
        let cnt = 0;
        for (let i = 0; i < 26; i++) {
          if (bArr[i] === tArr[i]) continue;
          const diff = bArr[i] - tArr[i];
          if (diff < -1 || diff > 1) return false;
          if (diff !== 0) {
            cnt++;
          }
          sum += diff;
        }
        if (sum !== 0 || cnt > 2) return false;
      } else {
        for (let i = 0; i < 26; i++) {
          const diff = tArr[i] - bArr[i];
          if (diff < 0 || diff > 1) return false;
          sum += diff;
        }
        if (sum !== 1) return false;
      }
    } else {
      for (let i = 0; i < 26; i++) {
        const diff = bArr[i] - tArr[i];
        if (diff < 0 || diff > 1) return false;
        sum += diff;
      }
      if (sum !== 1) return false;
    }
    return true;
  }
};

console.log(solution());
