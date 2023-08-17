/**
 * BaekJoon_단어 맞추기
 *    1. 문제 분류 : 문자열, 순열
 *    2. 접근 방법
 *      - 순열을 만드는데 주어진 단어랑 맞지 않은 순서면 pass
 */
const solution = () => {
  /* 변수 초기화, 입력값 초기화 */
  const input = require("fs").readFileSync("./dev/stdin/9081.txt").toString().trim().split("\n");
  const N = +input[0];
  let str = null;
  const count = Array.from({ length: 26 }, () => 0);
  let [curr, next, set] = [null, null, null];
  const answer = [];

  /* 메인 로직 */
  for (let i = 1; i <= N; i++) {
    str = input[i].trim();
    countLetter(str);
    [curr, next] = [null, null];
    set = new Set();
    permutation(str, "", 0);

    if (next) {
      answer.push(next);
    } else {
      answer.push(curr);
    }
  }

  return answer.join("\n");

  /* 순열 */
  function permutation(target, perm, depth) {
    if (depth === target.length) {
      if (!curr) {
        curr = perm;
        set.add(curr);
      } else {
        if (set.has(perm)) return;
        next = perm;
      }
      return;
    }

    for (let i = 0; i < 26; i++) {
      if (count[i] === 0) continue;
      if (next) break;
      const char = String.fromCharCode(i + 65);
      if (!curr && char !== target.charAt(depth)) continue;
      count[i]--;
      permutation(target, perm + String.fromCharCode(i + 65), depth + 1);
      count[i]++;
    }
  }

  /* 알파벳 카운트 */
  function countLetter(str) {
    count.fill(0);
    for (let i = 0; i < str.length; i++) {
      count[str.charCodeAt(i) - 65]++;
    }
  }
};

console.log(solution());
