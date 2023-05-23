
/*
  Sketch Idea
    1. Union-Find 알고리즘으로 그룹의 개수를 도출
*/

function solution(n, computers) {
  const p = new Array(n);

  const makeSet = () => {
    for (let i = 0; i < n; i++) p[i] = i;
  };

  const find = (node) => {
    if (p[node] === node) return node;
    p[node] = find(p[node]);
    return p[node];
  };

  const union = (i, j) => {
    const [pi, pj] = [find(i), find(j)];
    if (pi === pj) return;
    if (pi < pj) {
      p[pj] = i;
    } else {
      p[pi] = j;
    }
  };

  makeSet();
  for (let i = 0; i < n; i++) {
    for (let j = 0; j < n; j++) {
      if (!computers[i][j]) continue;
      union(i, j);
    }
  }

  const set = new Set();
  for (let i = 0; i < n; i++) {
    set.add(find(i));
  }
  return set.size;
}

console.log(
  solution(3, [
    [1, 1, 0],
    [1, 1, 0],
    [0, 0, 1],
  ])
);
console.log(
  solution(3, [
    [1, 1, 0],
    [1, 1, 1],
    [0, 1, 1],
  ])
);
console.log(
  solution(7, [
    [1, 0, 0, 0, 0, 0, 1],
    [0, 1, 1, 0, 1, 0, 0],
    [0, 1, 1, 1, 0, 0, 0],
    [0, 0, 1, 1, 0, 0, 0],
    [0, 1, 0, 0, 1, 1, 0],
    [0, 0, 0, 0, 1, 1, 1],
    [1, 0, 0, 0, 0, 1, 1],
  ])
);
