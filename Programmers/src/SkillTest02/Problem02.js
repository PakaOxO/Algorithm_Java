/**
*   Programmers_스킬 체크 테스트 Level 2, 2 문항(더 맵게)
        1. 문제 분류 : 자료구조(힙)
        2. 접근 방법
            - 최소 힙을 구현
            - 스코빌 지수를 최소 힙에 넣은 뒤, 앞에서 두 개씩 꺼내며 섞음
            - 맨 앞의 스코빌 지수가 K이상이 될 때까지 반복
*/
function solution(scoville, K) {
  /* 최소 힙 구현 */
  class Heap {
    constructor() {
      this.arr = [null];
      this.size = 0;
    }

    peek() {
      return this.arr[1];
    }

    poll() {
      if (this.size === 0) return null;
      const result = this.arr[1];
      this.swap(1, this.size);
      this.size--;
      this.arr.pop();

      let pointer = 1;
      while (true) {
        let [left, right] = [pointer * 2, pointer * 2 + 1];
        if (left > this.size) break;

        if (right <= this.size) {
          let next = null;
          if (this.arr[left] < this.arr[right]) {
            next = left;
          } else {
            next = right;
          }

          if (this.arr[next] >= this.arr[pointer]) break;
          this.swap(pointer, next);
          pointer = next;
        } else {
          if (this.arr[left] >= this.arr[pointer]) break;
          this.swap(pointer, left);
          pointer = left;
        }
      }

      return result;
    }

    offer(x) {
      this.size++;
      this.arr.push(x);
      let pointer = this.size;
      let parent = Math.floor(pointer / 2);

      while (parent > 0) {
        if (this.arr[parent] < this.arr[pointer]) break;
        this.swap(parent, pointer);
        pointer = parent;
        parent = Math.floor(pointer / 2);
      }
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
  let answer = 0;
  const N = scoville.length;
  const pq = new Heap();

  /* 메인 로직 */
  for (let i = 0; i < N; i++) {
    pq.offer(scoville[i]);
  }

  while (pq.getSize() > 1 && pq.peek() < K) {
    const [a, b] = [pq.poll(), pq.poll()];
    pq.offer(a + b * 2);
    answer++;
  }

  if (pq.peek() < K) answer = -1;
  return answer;
}

