/**
 * Softeer_플레이페어 암호
 *    1. 문제 분류 : 문자열, 구현
 *    2. 접근 방법
 *      - 문제에서 주어진 대로 구현...
 */
const solution = () => {
  const rl = require("readline").createInterface({
    input: process.stdin,
    output: process.stdout,
  });

  /* 변수 초기화 */
  const lines = [];
  let [str, key] = [null, null];
  const v = Array.from({ length: 26 }, () => false);
  let table = null;
  let splitedMsg = null;
  let answer = null;

  rl.on("line", (input) => {
    lines.push(input);
  });

  rl.on("close", () => {
    [str, key] = lines.map((s) => s.trim());

    table = setTable(key);
    splitedMsg = splitMsg(str);
    answer = encoding(splitedMsg);

    console.log(answer);

    process.exit();
  });

  /* 주어진 키로 테이블 생성 */
  function setTable(key) {
    if (key === null) return null;

    let [count, pointer] = [0, 0];
    const newTable = Array.from({ length: 5 }, () => []);
    while (count < 25) {
      if (pointer >= key.length) {
        for (let i = 0; i < 26 && count < 25; i++) {
          if (i !== 9 && !v[i]) {
            newTable[~~(count++ / 5)].push(String.fromCharCode(i + 65));
          }
        }
        break;
      }
      const char = key.charAt(pointer);
      const charIdx = key.charCodeAt(pointer) - 65;
      if (!v[charIdx]) {
        v[charIdx] = true;
        newTable[~~(count++ / 5)].push(char);
      }
      pointer++;
    }

    return newTable;
  }

  /* 메시지 분리 */
  function splitMsg(msg) {
    const arr = [];
    for (let i = 0; i < msg.length; i++) {
      if (i + 1 >= msg.length) {
        arr.push(msg.charAt(i) + "X");
      } else {
        const [s1, s2] = [msg.charAt(i), msg.charAt(i + 1)];
        if (s1 === s2) {
          if (s1 === "X") {
            arr.push(s1 + "Q");
          } else {
            arr.push(s1 + "X");
          }
        } else {
          arr.push(s1 + s2);
          i++;
        }
      }
    }
    return arr;
  }

  /* 암호화 */
  function encoding(arr) {
    let str = "";
    for (let i = 0; i < arr.length; i++) {
      const [char1, char2] = [arr[i].charAt(0), arr[i].charAt(1)];
      const [[r1, c1], [r2, c2]] = findAtTable(char1, char2);

      if (r1 === r2) {
        str += table[r1][(c1 + 1) % 5] + table[r2][(c2 + 1) % 5];
      } else if (c1 === c2) {
        str += table[(r1 + 1) % 5][c1] + table[(r2 + 1) % 5][c2];
      } else {
        str += table[r1][c2] + table[r2][c1];
      }
    }
    return str;
  }

  /* 테이블에서 두 문자 위치 찾기 */
  function findAtTable(c1, c2) {
    const [pos1, pos2] = [
      [0, 0],
      [0, 0],
    ];

    for (let i = 0; i < 25; i++) {
      const [r, c] = [~~(i / 5), i % 5];
      if (c1 === table[r][c]) {
        [pos1[0], pos1[1]] = [r, c];
      }
      if (c2 === table[r][c]) {
        [pos2[0], pos2[1]] = [r, c];
      }
    }

    return [pos1, pos2];
  }
};

solution();

