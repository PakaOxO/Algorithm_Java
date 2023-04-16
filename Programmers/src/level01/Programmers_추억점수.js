function solution(name, yearning, photo) {
  const score = new Map();
  const len = name.length;
  // Map 자료형에 이름-추억점수 key-value Set으로 데이터 저장
  for (let i = 0; i < len; i++) {
    score.set(name[i], yearning[i]);
  }

  let answer = [];
  for (const p of photo) {
    let total = 0;
    for (const n of p) {
      if (score.has(n)) {
        // Map에 이름이 있으면 추억점수 누계에 합산
        total += score.get(n);
      }
    }
    answer.push(total);
  }
  return answer;
}

console.log(
  solution(
    ["may", "kein", "kain", "radi"],
    [5, 10, 1, 3],
    [
      ["may", "kein", "kain", "radi"],
      ["may", "kein", "brin", "deny"],
      ["kon", "kain", "may", "coni"],
    ]
  )
);
console.log(
  solution(
    ["kali", "mari", "don"],
    [11, 1, 55],
    [
      ["kali", "mari", "don"],
      ["pony", "tom", "teddy"],
      ["con", "mona", "don"],
    ]
  )
);
console.log(
  solution(
    ["may", "kein", "kain", "radi"],
    [5, 10, 1, 3],
    [["may"], ["kein", "deny", "may"], ["kon", "coni"]]
  )
);
