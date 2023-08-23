/**
 * BaekJoon_19539, 사과 나무
 *    1. 문제 분류 : 그리디, 자료구조(힙)
 *    2. 접근 방법
 *      - 최대한 길이 1인 나무를 제거한다는 아이디어로 접근
 *      - 길이 1인 나무가 있으면 최소 힙(최소값 2 이상)에서 하나 꺼내 -2 줄여줌
 *        -> 길이 1인 나무가 없을 때까지 반복
 *      - 길이 1인 나무가 없으면 최소 힙에서 하나 꺼내 3으로 나눈 몫을 남김
 *        -> 몫이 1이면 길이가 1인 나무의 개수에 +1
 *        -> 몫이 2이면 길이가 1인 나무의 개수에 +2
 */
const solution = () => {
  /* 최소 힙 구현 */
  class Heap {
    constructor() {
      this.arr = [null];
      this.size = 0;
    }

    offer(val) {
      this.arr.push(val);
      this.size++;

      let pointer = this.size;
      let parent = ~~(pointer / 2);
      while (parent > 0) {
        if (this.arr[pointer] < this.arr[parent]) {
          this.swap(pointer, parent);
          parent = ~~(pointer / 2);
        } else {
          break;
        }
      }
    }

    poll() {
      if (this.size < 1) return null;
      const min = this.arr[1];
      this.swap(1, this.size);
      this.arr.pop();
      this.size--;

      if (this.size > 0) {
        let pointer = 1;
        while (true) {
          let flag = false;
          let [left, right] = [pointer * 2, pointer * 2 + 1];
          if (this.arr[left] && this.arr[right]) {
            if (this.arr[left] <= this.arr[right]) {
              if (this.arr[pointer] > this.arr[left]) {
                this.swap(pointer, left);
                pointer = left;
                flag = true;
              }
            } else {
              if (this.arr[pointer] > this.arr[right]) {
                this.swap(pointer, right);
                pointer = right;
                flag = true;
              }
            }
          } else if (this.arr[left] && this.arr[pointer] > this.arr[left]) {
            this.swap(pointer, left);
            pointer = left;
            flag = true;
          } else if (this.arr[right] && this.arr[pointer] > this.arr[right]) {
            this.swap(pointer, right);
            pointer = right;
            flag = true;
          }

          if (!flag) break;
        }
      }

      return min;
    }

    peek() {
      if (this.size === 0) return null;
      return this.arr[1];
    }

    swap(i, j) {
      const temp = this.arr[i];
      this.arr[i] = this.arr[j];
      this.arr[j] = temp;
    }

    getSize() {
      return this.size;
    }
  }

  /* 변수 초기화 */
  const input = require("fs").readFileSync("./dev/stdin/19539.txt").toString().trim().split("\n");
  const arr = input[1].split(" ").map((item) => +item);
  const heap = new Heap();
  let count1 = 0;
  arr.forEach((tree) => {
    if (tree === 1) {
      count1++;
    } else {
      if (tree > 0) {
        heap.offer(tree);
      }
    }
  });

  /* 메인 로직 */
  const flag = watering();

  /* 정답 반환 */
  return flag ? "YES" : "NO";

  /* 매일 물 주기 */
  function watering() {
    while (count1 > 0 || heap.getSize() > 0) {
      while (count1 > 0) {
        const min = heap.poll();
        if (min === null) return false;
        if (min - 2 > 0) {
          if (min - 2 === 1) {
            count1++;
          } else {
            heap.offer(min - 2);
          }
        }
        count1--;
      }

      const min = heap.poll();
      if (min) {
        const res = min % 3;
        if (res === 1) {
          count1++;
        } else if (res === 2) {
          count1 += 2;
        } else {
          heap.offer(res);
        }
      }
    }

    return true;
  }
};

console.log(solution());

