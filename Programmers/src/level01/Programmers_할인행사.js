function solution(want, number, discount) {
  let answer = 0;

  const wantMap = new Map();
  for (let i = 0; i < want.length; i++) {
    wantMap.set(want[i], number[i]);
  }

  const dcMap = new Map();
  let left = 0;
  let right = 0;
  while (right < discount.length) {
    while (right - left < 10 && right < discount.length) {
      const item = discount[right++];
      if (dcMap.has(item)) {
        dcMap.set(item, dcMap.get(item) + 1);
      } else {
        dcMap.set(item, 1);
      }
    }

    let flag = true;
    const wantList = wantMap.keys();
    for (const key of wantList) {
      if (!dcMap.has(key) || wantMap.get(key) > dcMap.get(key)) {
        flag = false;
        break;
      }
    }

    if (flag) answer++;
    dcMap.set(discount[left], dcMap.get(discount[left]) - 1);
    left++;
  }
  return answer;
}

console.log(
  solution(
    ["banana", "apple", "rice", "pork", "pot"],
    [3, 2, 2, 2, 1],
    [
      "chicken",
      "apple",
      "apple",
      "banana",
      "rice",
      "apple",
      "pork",
      "banana",
      "pork",
      "rice",
      "pot",
      "banana",
      "apple",
      "banana",
    ]
  )
);
console.log(
  solution(
    ["apple"],
    [10],
    [
      "banana",
      "banana",
      "banana",
      "banana",
      "banana",
      "banana",
      "banana",
      "banana",
      "banana",
      "banana",
    ]
  )
);
