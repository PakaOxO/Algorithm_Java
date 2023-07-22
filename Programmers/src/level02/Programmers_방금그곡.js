/**
 * Programmers_방금 그 곡
 *  1. 문제 분류 : 문자열, 구현, 투포인터
 *  2. 접근 방법
 *    - 투포인터로 풀는게 정석일거 같지만 match 함수와 정규표현식을 사용해 풀어보자
 *    - match 함수의 대상은 각 노래를 재생 길이만큼 재생한 음
 *    - 만약 이미 저장된 정답이 있다면, 해당 재생 길이를 기준으로 큰 노래를 정답에 저장
 */
const solution = (m, musicinfos) => {
  /* 변수 선언부 */
  let answer = "(None)";
  let maxLength = 0;
  const musicCounts = musicinfos.length;
  // 문자열 검색시 방해가 될 #붙은 음정들 치환
  const filter = new Map([
    ["C#", "c"],
    ["D#", "d"],
    ["F#", "f"],
    ["G#", "g"],
    ["A#", "a"],
  ]);

  /* 메인 로직부 */
  const filteredM = filterMelody(m);
  for (let i = 0; i < musicCounts; i++) {
    const [start, end, title, melody] = musicinfos[i].split(",");
    const filteredMelody = filterMelody(melody);
    const time = getTime(start, end);

    const fullMelody = getFullMelody(time, filteredMelody);
    if (filteredM.length > time) continue;
    if (fullMelody.match(filteredM) && time > maxLength) {
      answer = title;
      maxLength = time;
    }
  }

  return answer;

  /* 메서드 */
  function filterMelody(melody) {
    let filteredMelody = melody;
    filter.forEach((val, key) => {
      filteredMelody = filteredMelody.replaceAll(key, val);
    });
    return filteredMelody;
  }

  function getTime(start, end) {
    const [sH, sM] = start.split(":").map((item) => +item);
    const [eH, eM] = end.split(":").map((item) => +item);

    let time = eM - sM;
    if (time < 0) {
      time += 60;
      time += (eH - sH - 1) * 60;
    } else {
      time += (eH - sH) * 60;
    }

    return time;
  }

  function getFullMelody(time, melody) {
    let fullMelody = "";
    while (fullMelody.length < time) {
      if (melody.length > time - fullMelody.length) {
        fullMelody += melody.slice(0, time - fullMelody.length);
      } else {
        fullMelody += melody;
      }
    }
    return fullMelody;
  }
};

// console.log(
//   solution("ABCDEFG", ["12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"])
// );
// console.log(
//   solution("CC#BCC#BCC#BCC#B", [
//     "03:00,03:30,FOO,CC#B",
//     "04:00,04:08,BAR,CC#BCC#BCC#B",
//   ])
// );
// console.log(
//   solution("ABC", ["12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"])
// );
// console.log(solution("ABC", ["12:00,12:06,HELLO,ABC#ABC#ABC"]));
// console.log(solution("ABC", ["12:00,12:10,HELLO,ABC#ABC#ABC"]));
console.log(solution("ABC", ["12:04,13:00,HELLO,ABC#ABC#ABC"]));
// console.log(solution("C#C", ["12:00,12:06,HELLO,C#C#CC#"]));
