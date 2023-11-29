/**
 * Programmers_선입선출 프로그래밍
 *  - 문제 분류: 자료구조(우선 순위 큐) 인줄 알았지만... 이분 탐색(Parametric search 문제)
 */
const solution = (n, cores) => {
  /* 변수 관리 */
  const coreCount = cores.length;
  const max = Math.max(...cores);
  const limit = n * max;
  let [left, right] = [0, limit + 1];
  let answer = 0;

  /* 메인 로직 */
  while (left <= right) {
    const mid = Math.floor((left + right) / 2);
    const count = check(mid);
    if (count >= n - coreCount) {
      right = mid - 1;
      answer = findLastCore(mid);
    } else {
      left = mid + 1;
    }
  }

  /* 정답 반환 */
  return answer;

  // 해당 시간(time)에 완료할 수 있는 작업의 수
  function check(time) {
    let count = 0;
    for (let i=0; i<coreCount; i++) {
      count += Math.floor(time / cores[i]);
    }

    return count;
  }

  // 마지막 작업 코어 찾기
  function findLastCore(time) {
    let res = n - coreCount;
    const res0 = [];

    for (let i=0; i<coreCount; i++) {
      res -= Math.floor((time - 1) / cores[i]);
      if (time % cores[i] === 0) res0.push(i + 1);
    }

    return res < 1 ? null : res0[res - 1];
  }
}

// const solution = (n, cores) => {
//   class Core {
//     constructor(coreNumber, coreTime) {
//       this.coreNumber = coreNumber;
//       this.coreTime = coreTime;
//       this.start = 0;
//     }

//     getProcessEnd() {
//       return this.start + this.coreTime;
//     }

//     processStart(time) {
//       this.start = time;
//     }
//   }

//   // 들어간 시간 + 들어간 코어의 소요 시간의 합이 작은 최소 힙
//   class PriorityQueue {
//     constructor() {
//       this.arr = [null];
//       this.size = 0;
//     }

//     offer(process) {
//       this.arr.push(process);
//       this.size++;

//       let pointer = this.size;
//       let parent = Math.floor(pointer / 2);
//       while (parent > 0) {
//         const flag = this.compare(parent, pointer);
//         if (!flag) break;
//         this.swap(parent, pointer);
//         pointer = parent;
//         parent = Math.floor(pointer / 2);
//       }
//     }

//     poll() {
//       if (this.size === 0) return null;
//       this.swap(1, this.size);
//       const result = this.arr.pop();
//       this.size--;

//       let pointer = 1;
//       while (pointer < this.size) {
//         const [left, right] = [pointer * 2, pointer * 2 + 1];
//         if (left > this.size) break;

//         let next = null;
//         if (right <= this.size) {
//           const flag = this.compare(left, right);
//           next = !flag ? left : right;
//         } else {
//           next = left;
//         }

//         if (!this.compare(pointer, next)) break;
//         this.swap(pointer, next);
//         pointer = next;
//       }

//       return result;
//     }

//     peek() {
//       if (this.size === 0) return null;
//       return this.arr[1];
//     }

//     swap(i, j) {
//       const temp = this.arr[i];
//       this.arr[i] = this.arr[j];
//       this.arr[j] = temp;
//     }

//     compare(i, j) {
//       const [coreI, coreJ] = [this.arr[i], this.arr[j]];
//       if (coreI.getProcessEnd() === coreJ.getProcessEnd()) {
//         return coreI.coreNumber > coreJ.coreNumber;
//       }
//       return coreI.getProcessEnd() > coreJ.getProcessEnd();
//     }
//   }

//   /* 변수 관리 */
//   const processQueue = new PriorityQueue();
//   const coreQueue = new PriorityQueue();
//   const coreCount = cores.length;
//   let answer = 0;

//   /* 메인 로직 */
//   for (let i=0; i<coreCount; i++) {
//     coreQueue.offer(new Core(i + 1, cores[i]));
//   }

//   let time = 0;
//   let pointer = 0;
//   while (pointer < n) {
//     const endTime = processQueue.size === 0 ? null : processQueue.peek().getProcessEnd();
//     while (processQueue.size > 0 && processQueue.peek().getProcessEnd() === endTime) {
//       const core = processQueue.poll();
//       time = core.getProcessEnd();
//       // console.log("시간 ", time, "에 ", core.coreNumber, "에서 작업 끝", core.getProcessEnd())
//       core.processStart(0);
//       coreQueue.offer(core);
//     }
    
//     while (pointer < n && coreQueue.size > 0) {
//       const core = coreQueue.poll();
//       core.processStart(time);
//       // console.log("시간 ", time, "에 ", core.coreNumber, "에서 작업 시작")
//       processQueue.offer(core);
//       pointer++;
//       answer = core.coreNumber;
//     }
//   }

//   /* 정답 반환 */
//   return answer;
// }

console.log(solution(6,	[1,2,3]));
// console.log(solution(10,	[1,2,3,4,5,6]));

// 0 : 0 1 / 0 2 / 0 3, 3개 들어감
// 1 : 0 2 / 0 3 / 1 1, 4개 들어감
// 2 : 0 3 / 2 1 / 2 2, 6개 들어감