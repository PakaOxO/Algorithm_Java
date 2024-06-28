/**
 * BaekJoon_3649, 로봇 프로젝트
 *  - 문제 분류: 정렬
 */
const lib = require('readline');
const rl = lib.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let x, n;
let l = [];
let answer = '';

rl.on('line', (input) => solution(input)).on('close', () => {
  console.log(answer.trim());
  process.exit();
});

function solution(input) {
  if (input === '') rl.close();
  if (!x) x = +input * 10000000;
  else if (!n) n = +input;
  else l.push(+input);

  if (l.length === n) {
    l.sort((a, b) => a - b);

    let query = 'danger\n';

    for (let i = 0; i < n; i++) {
      const right = binarySearch(i + 1, x - l[i]);
      if (l[i] + l[right] === x) {
        query = `yes ${l[i]} ${l[right]}\n`;
        break;
      }
    }
    answer += query;
    x = n = null;
    l = [];
  }
}

// 이분 탐색
function binarySearch(left, target) {
  let right = l.length - 1;
  while (left < right) {
    const mid = Math.floor((left + right) / 2);
    if (l[mid] === target) return mid;

    if (l[mid] < target) left = mid + 1;
    else right = mid - 1;
  }
  return left;
}

