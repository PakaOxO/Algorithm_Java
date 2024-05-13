const { get } = require("http");

/**
 * plaformName_probName
 *  - 문제 분류: type
 */
const solution = () => {
  // mbti index
  function getMBTIIndex(mbti) {
    let idx = 0;
    for (let i = 0; i < 4; i++) {
      const c = mbti.charAt(i);
      idx += (c === "E" || c === "S" || c === "T" || c === "J" ? 1 : 0) * Math.pow(2, i);
    }
    return idx;
  }

  // mbti distance
  function getMBTIDist(a, b) {
    let dist = 0;
    for (let i = 0; i < 4; i++) {
      if ((a & (1 << i)) !== (b & (1 << i))) dist++;
    }
    return dist;
  }

  /* 변수 관리 */
  const input = require("fs").readFileSync("./dev/stdin/20529.txt").toString().trim().split("\n");
  const T = +input[0];
  let pointer = 1;
  const mbti = Array.from({ length: 16 }, () => 0);
  const answer = [];

  /* 메인 로직 */
  for (let tc = 0; tc < T; tc++) {
    const N = +input[pointer++];
    const arr = input[pointer++].split(" ");
    let max = 0;
    mbti.fill(0);

    for (let i = 0; i < N; i++) {
      const idx = getMBTIIndex(arr[i]);
      mbti[idx]++;
      if (mbti[idx] > max) max = mbti[idx];
      if (max > 2) break;
    }

    if (max > 2) {
      answer.push(0);
    } else {
      // bruteforce
      let min = 12;
      for (let i = 0; i < 16; i++) {
        if (mbti[i] === 0) continue;
        mbti[i]--;
        for (let j = i; j < 16; j++) {
          if (mbti[j] === 0) continue;
          mbti[j]--;
          for (let k = j; k < 16; k++) {
            if (mbti[k] === 0) continue;
            const ab = getMBTIDist(i, j);
            const bc = getMBTIDist(j, k);
            const ca = getMBTIDist(k, i);
            if (ab + bc + ca < min) {
              min = ab + bc + ca;
            }
          }
          mbti[j]++;
        }
        mbti[i]++;
      }
      answer.push(min);
    }
  }

  /* 정답 반환 */
  return answer.join("\n");
};

console.log(solution());

