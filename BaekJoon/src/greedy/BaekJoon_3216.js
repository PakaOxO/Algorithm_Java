const solution = () => {
  const fs = require("fs");
  const input = fs.readFileSync("./dev/stdin/3216.txt").toString().split("\n");

  const N = +input[0];
  const musics = [];
  for (let i = 0; i < N; i++) {
    musics.push(input[i + 1].split(" ").map((item) => +item));
  }

  let answer = 0;
  let pointer = 0;
  for (let i = 0; i < N; i++) {
    if (pointer === i) {
      answer += musics[pointer][1];
      musics[pointer][1] = 0;
      pointer++;
    }

    while (musics[i][0] > 0) {
      if (pointer === N) {
        musics[i][0] = 0;
        break;
      }

      const diff = musics[i][0] - musics[pointer][1];
      if (diff > 0) {
        musics[i][0] -= musics[pointer][1];
        musics[pointer++][1] = 0;
      } else {
        musics[pointer][1] -= musics[i][0];
        musics[i][0] = 0;
      }
    }
  }
  return answer;
};

console.log(solution());
