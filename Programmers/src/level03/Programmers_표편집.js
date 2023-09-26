/**
 * Programmers_표 편집
 *  - 문제 분류: 구현, 자료구조(스택, 연결 리스트)
 */
const solution = (n, k, cmd) => {
  /**
   * 행 데이터 클래스
   */
  class Row {
    constructor(idx) {
      this.idx = idx;
      this.prev = null;
      this.next = null;
    }
  }

  /**
   * 연결리스트 클래스
   */
  class LinkedList {
    constructor(n, k) {
      this.delStack = [];
      this.isDeleted = Array.from({ length: n }, () => false);

      let [prev, curr] = [null, null];
      for (let i = 0; i < n; i++) {
        curr = new Row(i);
        if (prev !== null) {
          prev.next = curr;
        }
        curr.prev = prev;

        if (i === 0) {
          this.head = curr;
        } else if (i === n - 1) {
          this.tail = curr;
        }

        if (i === k) {
          this.curr = curr;
        }
        prev = curr;
      }

      this.head.prev = this.tail;
      this.tail.next = this.head;
    }

    moveUp(x) {
      while (x > 0) {
        this.curr = this.curr.prev;
        x--;
      }
    }

    moveDown(x) {
      while (x > 0) {
        this.curr = this.curr.next;
        x--;
      }
    }

    del() {
      const target = this.curr;
      this.delStack.push(target);
      this.isDeleted[target.idx] = true;

      target.prev.next = target.next;
      target.next.prev = target.prev;

      if (target === this.tail) {
        this.curr = this.curr.prev;
        this.tail = this.curr;
      } else if (target === this.head) {
        this.curr = this.curr.next;
        this.head = this.curr;
      } else {
        this.curr = this.curr.next;
      }
    }

    delCancel() {
      const target = this.delStack.pop();
      let prev = target.prev;
      let next = target.next;

      while (this.isDeleted[prev.idx]) {
        prev = prev.prev;
      }

      while (this.isDeleted[next.idx]) {
        next = next.next;
      }

      prev.next = target;
      next.prev = target;
      this.isDeleted[target.idx] = false;

      if (prev.idx > target.idx) {
        this.head = target;
      }

      if (next.idx < target.idx) {
        this.tail = target;
      }
    }
  }

  /* 변수 초기화 */
  const list = new LinkedList(n, k);
  let answer = "";

  /* 메인 로직 */
  for (let i = 0; i < cmd.length; i++) {
    const [type, x] = cmd[i].split(" ");
    if (type === "U") {
      list.moveUp(+x);
    } else if (type === "D") {
      list.moveDown(+x);
    } else if (type === "C") {
      list.del();
    } else if (type === "Z") {
      list.delCancel();
    }
  }

  for (let i = 0; i < n; i++) {
    answer += list.isDeleted[i] ? "X" : "O";
  }

  /* 정답 반환 */
  return answer;
};

console.log(solution(8, 2, ["D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"]));
console.log(solution(8, 2, ["D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C"]));

