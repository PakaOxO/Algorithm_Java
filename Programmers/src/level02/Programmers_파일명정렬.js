const solution = (files) => {
  const len = files.length;

  const arr = [];

  files.forEach((file, IDX) => {
    let [p1, p2] = [-1, -1];
    for (let i = 0; i < len; i++) {
      if (p1 >= 0 && p2 >= 0) break;

      if (p1 < 0 && file[i] >= "0" && file[i] <= "9") {
        p1 = i;
        p2 = p1;
        while (p2 + 1 < len && file[p2 + 1] >= "0" && file[p2 + 1] <= "9") {
          p2++;
        }
      }
    }

    const HEAD = file.substring(0, p1);
    const NUMBER = file.substring(p1, p2 + 1);
    const TAIL = file.substring(p2 + 1);

    arr.push({
      HEAD,
      NUMBER,
      TAIL,
      IDX,
    });
  });

  arr.sort((f1, f2) => {
    const [h1, h2] = [f1.HEAD.toUpperCase(), f2.HEAD.toUpperCase()];
    if (h1 !== h2) {
      if (h1 < h2) return -1;
      return 1;
    }

    const [n1, n2] = [+f1.NUMBER, +f2.NUMBER];
    if (n1 !== n2) {
      console.log(n1, n2);
      return n1 - n2;
    }

    return f1.IDX - f2.IDX;
  });

  return arr.map((file) => file.HEAD + file.NUMBER + file.TAIL);
};

// console.log(
//   solution([
//     "img12.png",
//     "img10.png",
//     "img02.png",
//     "img1.png",
//     "IMG01.GIF",
//     "img2.JPG",
//   ])
// );
console.log(
  solution([
    "F-5 Freedom Fighter",
    "B-50 Superfortress",
    "A-10 Thunderbolt II",
    "F-14 Tomcat",
  ])
);
