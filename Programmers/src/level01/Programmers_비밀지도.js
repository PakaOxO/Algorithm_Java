function solution(n, arr1, arr2) {
  const answer = [];
  for (let i = 0; i < n; i++) {
    const bit = arr1[i] | arr2[i];
    let str = "";
    for (let j = 0; j < n; j++) {
      if ((bit & (1 << j)) > 0) str = "#" + str;
      else str = " " + str;
    }
    answer.push(str);
  }
  return answer;
}

console.log(solution(5, [9, 20, 28, 18, 11], [30, 1, 21, 17, 28]));
console.log(solution(6, [46, 33, 33, 22, 31, 50], [27, 56, 19, 14, 14, 10]));
["######", "###  #", "##  ##", "#### #", "######", "### # "][
  ("######", "### #", "## ##", " #### ", " #####", "### # ")
];
