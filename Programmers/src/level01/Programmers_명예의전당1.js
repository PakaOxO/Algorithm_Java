function solution(k, score) {
  const day = score.length;
  const answer = new Array(day);

  const pq = new PriorityQueue();
  for (let i = 0; i < day; i++) {
    pq.offer(score[i]);
    if (pq.size > k) {
      pq.poll();
    }
    answer[i] = pq.peek();
  }
  return answer;
}

class PriorityQueue {
  constructor() {
    this.heap = [null];
    this.size = 0;
  }

  offer(val) {
    this.heap.push(val);

    let currIdx = ++this.size;
    while (true) {
      if (currIdx <= 1) break;
      const parentIdx = currIdx % 2 === 0 ? currIdx / 2 : (currIdx - 1) / 2;
      if (this.heap[currIdx] >= this.heap[parentIdx]) break;

      this.swap(currIdx, parentIdx);
      currIdx = parentIdx;
    }
  }

  poll() {
    if (this.size < 1) {
      return null;
    }

    if (this.size === 1) {
      this.size--;
      return this.heap.pop();
    }

    this.swap(1, this.size);
    const min = this.heap.pop();
    this.size--;

    let currIdx = 1;
    while (true) {
      const left = currIdx * 2;
      const right = currIdx * 2 + 1;
      if (this.size >= right) {
        if (this.heap[left] < this.heap[right]) {
          if (this.heap[currIdx] > this.heap[left]) {
            this.swap(currIdx, left);
            currIdx = left;
          } else {
            break;
          }
        } else {
          if (this.heap[currIdx] > this.heap[right]) {
            this.swap(currIdx, right);
            currIdx = right;
          } else {
            break;
          }
        }
      } else if (this.size >= left) {
        if (this.heap[currIdx] > this.heap[left]) {
          this.swap(currIdx, left);
          currIdx = left;
        } else {
          break;
        }
      } else {
        break;
      }
    }
    return min;
  }

  peek() {
    if (this.size < 1) return null;
    return this.heap[1];
  }

  swap(i, j) {
    const currVal = this.heap[i];
    this.heap[i] = this.heap[j];
    this.heap[j] = currVal;
  }
}
