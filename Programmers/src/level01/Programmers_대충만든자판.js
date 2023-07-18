/**
 * Programmers_대충만든자판
 *  1. 문제 분류 : 해시, 맵
 *  2. 접근 방법
 *    - 모든 키를 한번씩 순회하면서 알파벳에 접근하기 위해 필요한 최소로 누르는 횟수를 각 알파벳 인덱스 배열에 저장
 */
const solution = (keymap, targets) => {
  /* 변수 선언부 */
  const len = targets.length;
  const answer = Array.from({ length: len }, () => -1);
  const cnt = Array.from({ length: 26 }, () => 101);

  /* 메인 로직부 */
  for (let i = 0; i < keymap.length; i++) {
    for (let j = 0; j < keymap[i].length; j++) {
      const idx = keymap[i].charCodeAt(j) - 65;
      cnt[idx] = Math.min(j + 1, cnt[idx]);
    }
  }

  loop: for (let i = 0; i < targets.length; i++) {
    let total = 0;
    for (let j = 0; j < targets[i].length; j++) {
      const idx = targets[i].charCodeAt(j) - 65;
      if (cnt[idx] > 100) continue loop;
      total += cnt[idx];
    }
    answer[i] = total;
  }

  return answer;
};

console.log(solution(["ABACD", "BCEFD"], ["ABCD", "AABB"]));
console.log(solution(["AA"], ["B"]));
console.log(solution(["AGZ", "BSSS"], ["ASA", "BGZ"]));
