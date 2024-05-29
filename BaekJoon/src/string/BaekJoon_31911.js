/**
 * BaekJoon_31911, ChatGPT 만들기
 *  - 문제 분류: 문자열, 해시, 자료구조
 */
const solution = () => {
  /* 변수 관리 */
  const input = require('fs').readFileSync('./dev/stdin/31911.txt').toString().trim().split('\n');
  let [N, K, M] = input[0].split(' ');
  N = +N;
  M = +M;
  K = BigInt(K);
  const practice = input.slice(1);
  const INDEX_LIMIT = 29;
  const map = Array.from({ length: INDEX_LIMIT }, () => new Map());
  const next = Array.from({ length: INDEX_LIMIT }, () => null);
  const v = Array.from({ length: INDEX_LIMIT }, () => -1);
  const word = [];
  const answer = [];

  /* 메인 로직 */
  for (let str of practice) {
    str = str.trim();
    const len = str.length;
    for (let i = 1; i < len; i++) {
      const prev = str.charAt(i - 1);
      const char = str.charAt(i);

      const pIndex = getIndex(prev);
      const count = map[pIndex].get(char);
      map[pIndex].set(char, count ? count + 1 : 1);
    }
  }

  for (let i = 0; i < INDEX_LIMIT; i++) {
    let nextChar = '';
    let max = 0;
    for (const [key, val] of map[i]) {
      if (val < max) continue;
      if (val === max) {
        nextChar = getIndex(key) < getIndex(nextChar) ? key : nextChar;
      } else {
        nextChar = key;
      }
      max = val;
    }
    if (nextChar) next[i] = nextChar;
  }

  let char = '[';
  const repeat = [0, 0];
  for (let i = 0; i < K + BigInt(M - 1); i++) {
    const cIndex = getIndex(char);
    if (v[cIndex] >= 0) {
      repeat[0] = BigInt(v[cIndex]);
      repeat[1] = BigInt(i);
      break;
    }
    word.push(char);
    v[cIndex] = i;
    if (char === ']') break;
    char = next[cIndex];
  }

  let start = BigInt(K) - BigInt(1);
  if (start >= word.length) {
    if (repeat[0] !== repeat[1]) {
      start -= repeat[0];
      start %= repeat[1] - repeat[0];
      start = ((BigInt(K) - BigInt(1) - repeat[0]) % (repeat[1] - repeat[0])) + repeat[0];
    }
  }

  let pointer = start;
  while (answer.length < M) {
    if (pointer >= word.length) {
      if (repeat[0] !== repeat[1]) {
        pointer = repeat[0];
      } else {
        answer.push('.');
      }
      continue;
    }

    answer.push(word[pointer++]);
  }

  /* 정답 반환 */
  return answer.join('');

  // 인덱스로 변환
  function getIndex(char) {
    if (char === '-') return 0;
    if (char === '[') return 1;
    if (char === ']') return 2;
    if (char === '') return INDEX_LIMIT;
    return char.charCodeAt(0) - 94;
  }
};

console.log(solution());

