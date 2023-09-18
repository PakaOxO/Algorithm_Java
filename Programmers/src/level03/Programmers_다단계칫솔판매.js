/**
 * Programmers_다단계 칫솔 판매
 *  - 문제 분류 : 자료 구조, 트리, 연결 리스트
 */
const solution = (enroll, referral, seller, amount) => {
  /**
   * 노드 클래스 정의
   */
  class Node {
    constructor(parent, name) {
      this.parent = parent;
      this.name = name;
      this.money = 0;
    }
  }

  /* 변수 초기화 */
  const map = new Map();
  const N = enroll.length;
  const M = seller.length;
  const nodes = Array.from({ length: N }, () => null);
  const answer = [];

  /* 메인 로직 */
  makeTree(enroll, referral);
  sell(seller, amount);
  for (let i = 0; i < N; i++) {
    answer.push(nodes[i].money);
  }

  return answer;

  /**
   * enroll과 referral을 입력 받아 조직 트리 생성
   */
  function makeTree(enroll, referral) {
    map.set("center", new Node(null));

    for (let i = 0; i < N; i++) {
      const name = enroll[i];
      const parentName = referral[i] === "-" ? "center" : referral[i];
      const parent = map.get(parentName);

      map.set(name, new Node(parent, name));
      nodes[i] = map.get(name);
    }
  }

  /**
   * seller가 물건을 판매했을 때 수익 분배
   */
  function sell(seller, amount) {
    for (let i = 0; i < M; i++) {
      const s = seller[i];
      const a = amount[i] * 100;

      distribution(map.get(s), a);
    }
  }

  /**
   * 자신(me)의 추천인에게 수익(amount) 분배
   */
  function distribution(me, amount) {
    let parent = me.parent;
    while (parent !== null && amount > 0) {
      const percent10 = Math.floor(amount / 10);
      amount -= percent10;
      me.money += amount;

      amount = percent10;
      me = parent;
      parent = me.parent;
    }

    me.money += amount;
  }
};

console.log(
  solution(
    ["john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"],
    ["-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"],
    ["young", "john", "tod", "emily", "mary"],
    [12, 4, 2, 5, 10]
  )
);

console.log(
  solution(
    ["john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"],
    ["-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"],
    ["sam", "emily", "jaimie", "edward"],
    [2, 3, 5, 4]
  )
);

