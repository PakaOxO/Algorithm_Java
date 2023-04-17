function solution(players, callings) {
  const rank = new Map();
  // player의 등수를 Map에 저장
  players.forEach((p, idx) => {
    rank.set(p, idx);
  });
  const answer = players.slice(); // 정답을 리턴할 복사배열 생성

  // p의 사람과 앞의 등수의 사람을 스왑
  const swap = (p) => {
    const i = rank.get(p);
    const j = i - 1;

    const p2 = answer[j];
    answer[j] = p;
    answer[i] = p2;

    rank.set(p, j);
    rank.set(p2, i);
  };

  for (const c of callings) {
    swap(c);
  }

  return answer;
}

console.log(
  solution(
    ["mumu", "soe", "poe", "kai", "mine"],
    ["kai", "kai", "mine", "mine"],
    ["mumu", "kai", "mine", "soe", "poe"]
  )
);
