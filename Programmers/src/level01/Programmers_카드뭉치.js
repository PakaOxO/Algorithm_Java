function solution(cards1, cards2, goal) {
  let pointer1 = 0,
    pointer2 = 0;

  for (const word of goal) {
    if (cards1[pointer1] === word) {
      pointer1++;
      continue;
    } else if (cards2[pointer2] === word) {
      pointer2++;
      continue;
    } else {
      return "No";
    }
  }
  return "Yes";
}

console.log(
  solution(
    ["i", "drink", "water"],
    ["want", "to"],
    ["i", "want", "to", "drink", "water"]
  )
);
console.log(
  solution(
    ["i", "water", "drink"],
    ["want", "to"],
    ["i", "want", "to", "drink", "water"]
  )
);
