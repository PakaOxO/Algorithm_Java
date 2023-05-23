function solution(msg) {
  const dictionary = new Dictionary();
  const len = msg.length;
  const answer = [];
  for (let i = 0; i < len; i++) {
    let str = msg[i];
    for (let j = i + 1; j < len; j++) {
      // 다음 문자까지 포함한 문자열이 이미 있으면 그 다음 문자열 조합 탐색
      if (dictionary.find(str + msg[j]) > 0) {
        str += msg[j];
        continue;
      }
      // 없었으면 새로 사전에 등록
      dictionary.add(str + msg[j]);
      break;
    }
    answer.push(dictionary.find(str));
    i += str.length - 1;
  }
  return answer;
}

/* 사전 관리를 위한 클래스 생성 */
class Dictionary {
  constructor() {
    // 사전 문자열과 색인번호를 Map 자료구조로 관리
    this.dict = new Map();
    // A~Z는 사전에 등록되어 있다 가정, 색인번호 27부터 시작
    this.pointer = 27;
  }

  find(str) {
    if (str.length < 1) return -1;
    if (str.length === 1) return str.charCodeAt() - 64;
    if (!this.dict.has(str)) return -1;
    return this.dict.get(str);
  }

  add(str) {
    this.dict.set(str, this.pointer++);
  }
}

console.log(solution("KAKAO"));
console.log(solution("TOBEORNOTTOBEORTOBEORNOT"));
console.log(solution("ABABABABABABABAB"));
