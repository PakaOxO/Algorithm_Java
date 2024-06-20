/**
 * BaekJoon_1063, 킹
 *  - 문제 분류: 구현
 */
const solution = () => {
  /* 변수 관리 */
  const getNumberPos = (str) => [str.charCodeAt(0) - 65 + 1, +str.charAt(1)];
  const getBoardPos = (arr) => String.fromCharCode(arr[0] + 65 - 1) + arr[1];
  const drc = {
    R: [1, 0],
    L: [-1, 0],
    B: [0, -1],
    T: [0, 1],
    RT: [1, 1],
    LT: [-1, 1],
    RB: [1, -1],
    LB: [-1, -1],
  };
  const input = require('fs').readFileSync('./dev/stdin/1063.txt').toString().trim().split('\n');
  const [king, stone, N] = input[0].split(' ');
  const kpos = getNumberPos(king);
  const spos = getNumberPos(stone);

  /* 메인 로직 */
  for (let i = 1; i <= N; i++) {
    const [dr, dc] = drc[input[i]];
    const [knr, knc] = [kpos[0] + dr, kpos[1] + dc];
    const [snr, snc] = [spos[0] + dr, spos[1] + dc];
    if (knr <= 0 || knc <= 0 || knr > 8 || knc > 8) continue;

    if (knr === spos[0] && knc === spos[1]) {
      if (snr <= 0 || snc <= 0 || snr > 8 || snc > 8) continue;
      [kpos[0], kpos[1]] = [knr, knc];
      [spos[0], spos[1]] = [snr, snc];
    } else {
      [kpos[0], kpos[1]] = [knr, knc];
    }
  }

  /* 정답 반환 */
  return `${getBoardPos(kpos)}\n${getBoardPos(spos)}`;
};

console.log(solution());

