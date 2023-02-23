function countingSort(arr) {
  const count_acc = new Array(10).fill(0);
  const sortedArr = new Array(arr.length);

  // 개수 카운트
  for (const num of arr) {
    count_acc[num]++;
  }

  // 카운트 누적 배열 생성
  let prev = count_acc[0];
  for (let i = 1; i < count_acc.length; i++) {
    count_acc[i] += prev;
    prev = count_acc[i];
  }

  // 카운팅 정렬 실행
  for (const num of arr) {
    sortedArr[--count_acc[num]] = num;
  }

  return sortedArr;
}

// 그리디하게 최대값만으로 이루어진 사과들 먼저 선별해 상자에 담는다.
// 점수의 최대값이 크지 않으니까 카운팅 정렬한 뒤에 큰 숫자부터 탐색하기
function solution(k, m, score) {
  var answer = 0;
  const sortedArr = countingSort(score);
  for (let i = sortedArr.length - m; i >= 0; i -= m) {
    answer += sortedArr[i] * m;
  }
  return answer;
}
