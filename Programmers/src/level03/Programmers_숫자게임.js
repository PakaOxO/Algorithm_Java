const solution = (A, B) => {
  A.sort((a, b) => a - b);
  B.sort((a, b) => a - b);

  let answer = 0;
  const N = A.length;
  const visited = [];

  for (let i = N - 1; i >= 0; i--) {
    if (B[i] > A[i]) {
      answer++;
    } else {
      if (visited.length > 0 && visited[0] > A[i]) {
        visited.shift();
        answer++;
      }
      visited.push(B[i]); // 일단은 다 넣어서 나중에 배열에 안쓰는 B의 수는 무조건 A에 지는 위치로 배정되는 꼴
    }
  }

  return answer;
};

console.log(solution([5, 1, 3, 7], [2, 2, 6, 8]));
console.log(solution([2, 2, 2, 2], [1, 1, 1, 1]));
console.log(solution([1, 2, 5, 7], [2, 2, 2, 5]));
