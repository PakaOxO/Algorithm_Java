function solution(clothes) {
  const comb = (map) => {
    const size = map instanceof Map ? map.size : 0;
    const arr = [];
    map.forEach((val, _) => {
      // 부위별 아이템 개수를 배열로
      arr.push(val);
    });

    let result = 0;
    // 모든 조합의 합
    const dfs = (m, depth, comb) => {
      if ((comb & (1 << depth)) > 0) return;
      for (let i = depth; i < size; i++) {
        const calc = m * arr[i];
        result += calc;
        dfs(calc, i + 1, comb | (1 << i));
      }
    };
    dfs(1, 0, 0);
    return result;
  };

  const map = new Map();
  // 각 부위별 개수 계산
  clothes.forEach((item) => {
    if (map.has(item[1])) {
      map.set(item[1], map.get(item[1]) + 1);
    } else {
      map.set(item[1], 1);
    }
  });

  return comb(map);
}

console.log(
  solution([
    ["yellow_hat", "headgear"],
    ["blue_sunglasses", "eyewear"],
    ["green_turban", "headgear"],
  ])
);
console.log(
  solution([
    ["crow_mask", "face"],
    ["blue_sunglasses", "face"],
    ["smoky_makeup", "face"],
  ])
);
