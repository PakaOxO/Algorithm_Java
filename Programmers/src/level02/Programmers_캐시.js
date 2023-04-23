class Node {
  constructor(val) {
    this.prev;
    this.next;
    this.val = val;
  }
}

class DoublyLinkedList {
  constructor(cacheSize) {
    this.size = 0;
    this.head = new Node("HEAD");
    this.tail = new Node("TAIL");
    this.cacheSize = cacheSize;

    this.head.next = this.tail;
    this.tail.prev = this.head;
  }

  add(city) {
    if (this.size < this.cacheSize) {
      if (this.has(city)) {
        let target = this.head;
        while (true) {
          if (target.val === city) break;
          target = target.next;
        }
        target.next.prev = target.prev;
        target.prev.next = target.next;

        target.prev = this.head;
        target.next = this.head.next;

        target.next.prev = target;
        this.head.next = target;

        return 1;
      } else {
        const newNode = new Node(city);

        newNode.next = this.head.next;
        newNode.prev = this.head;

        newNode.next.prev = newNode;
        this.head.next = newNode;

        this.size++;
      }
    } else {
      if (this.has(city)) {
        let target = this.head;
        while (true) {
          if (target.val === city) break;
          target = target.next;
        }
        target.next.prev = target.prev;
        target.prev.next = target.next;

        target.prev = this.head;
        target.next = this.head.next;

        target.next.prev = target;
        this.head.next = target;

        return 1;
      } else {
        const newNode = new Node(city);
        newNode.prev = this.head;
        newNode.next = this.head.next;

        newNode.next.prev = newNode;
        this.head.next = newNode;

        this.tail.prev = this.tail.prev.prev;
        this.tail.prev.next = this.tail;
      }
    }
    return 5;
  }

  has(city) {
    let node = this.head;
    while (node.next) {
      if (node.val === city) return true;
      node = node.next;
    }
    return false;
  }

  print() {
    let node = this.head;
    const arr = [];
    while (node) {
      arr.push(node.val);
      node = node.next;
    }

    console.log(arr);
  }
}

function solution(cacheSize, cities) {
  let answer = 0;
  const dll = new DoublyLinkedList(cacheSize);
  cities.forEach((item) => {
    answer += dll.add(item.toLowerCase());
  });
  return answer;
}

console.log(
  solution(3, [
    "Jeju",
    "Pangyo",
    "Seoul",
    "NewYork",
    "LA",
    "Jeju",
    "Pangyo",
    "Seoul",
    "NewYork",
    "LA",
  ])
);
console.log(
  solution(3, [
    "Jeju",
    "Pangyo",
    "Seoul",
    "Jeju",
    "Pangyo",
    "Seoul",
    "Jeju",
    "Pangyo",
    "Seoul",
  ])
);
console.log(
  solution(2, [
    "Jeju",
    "Pangyo",
    "Seoul",
    "NewYork",
    "LA",
    "SanFrancisco",
    "Seoul",
    "Rome",
    "Paris",
    "Jeju",
    "NewYork",
    "Rome",
  ])
);
console.log(
  solution(5, [
    "Jeju",
    "Pangyo",
    "Seoul",
    "NewYork",
    "LA",
    "SanFrancisco",
    "Seoul",
    "Rome",
    "Paris",
    "Jeju",
    "NewYork",
    "Rome",
  ])
);
console.log(solution(2, ["Jeju", "Pangyo", "NewYork", "newyork"]));
console.log(solution(0, ["Jeju", "Pangyo", "Seoul", "NewYork", "LA"]));

console.log(solution(5, ["leo", "leo", "leo"]));
