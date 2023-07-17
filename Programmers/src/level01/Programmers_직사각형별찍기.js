/**
 * Programmers_직사각형 별찍기
 *  1. 문제 분류 : 문자열, 반복문
 *  2. 접근 방법
 *    - 한줄을 그린 뒤 개행문자를 기준으로 반복해서 추가
 */
process.stdin.setEncoding("utf8");
process.stdin.on("data", (data) => {
  /* 초기 입력 */
  const n = data.split(" ");
  const a = Number(n[0]),
    b = Number(n[1]);

  /* 메인 로직부 */
  const answer = ("*".repeat(a) + "\n").repeat(b);
  console.log(answer);
});
