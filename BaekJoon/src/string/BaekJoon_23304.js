const solution = () => {
  /* 초기 입력 */
  const fs = require("fs");
  const input = fs.readFileSync("./dev/stdin/23304.txt").toString().trim();

  /* 메서드 */
  const isAkaraka = (str) => {
    const len = str.length;
    const len2 = Math.floor(len / 2);
    if (len > 1) {
      let [p1, p2] = [0, len - 1];
      const parts = str.substr(0, len2);
      if (!isAkaraka(parts)) {
        return false;
      }

      while (p1 < p2) {
        if (input[p1] !== input[p2]) {
          return false;
        }

        // 접두사, 접미사 체크
        p1++;
        p2--;
      }
    }
    return true;
  };

  return isAkaraka(input) ? "AKARAKA" : "IPSELENTI";
};

console.log(solution());
