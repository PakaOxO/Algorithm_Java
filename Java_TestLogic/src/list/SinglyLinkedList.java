package list;

class Node<E> {
	public E data;
	public Node<E> next;
	
	public Node(E data) {
		this.data = data;
	}
}

class SLL<E> {
	private Node<E> head;
	private int size;
	
	SLL() {
		this.size = 0;
	}
	
	/* 비어있는지 확인 */
	boolean isEmpty() {
		return size == 0;
	}
	
	/* 조회 */
	/* 전체 리스트 print */
	void printSLL() {
		if (isEmpty()) {
			System.out.println("비어있습니다.");
			return;
		}
		StringBuilder sb = new StringBuilder();
		Node<E> curr = head;
		while (curr != null) {
			sb.append(curr.data);
			curr = curr.next;
			if (curr != null) sb.append(" ");
		}
		System.out.println(sb);
	}
	
	/* 처음 노드 읽어오기 */
	E getFirstData() {
		if (isEmpty()) return null;
		return head.data;
	}
	
	/* 마지막 노드 읽어오기 */
	E getLastData() {
		if (isEmpty()) return null;
		Node<E> curr = head;
		for (int i=0; i<size-1; i++) {
			curr = curr.next;
		}
		return curr.data;
	}
	
	/* 중간 노드 읽어오기 */
	E getData(int idx) {
		if (isEmpty() || idx < 0 || idx >= size) return null;
		if (size == 1) return head.data;
		Node<E> curr = head;
		for (int i=0; i<idx; i++) {
			curr = curr.next;
		}
		return curr.data;
	}
	
	/* 추가 */
	/* 맨 앞에 추가 */
	void addAtFirst(E data) {
		Node<E> node = new Node<>(data);
		if (isEmpty()) {
			head = node;
		} else {
			node.next = head;
			head = node;
		}
		size++;
	}
	
	/* 맨 뒤에 추가 */
	void addAtLast(E data) {
		Node<E> node = new Node<>(data);
		if (isEmpty()) {
			head = node;
		} else {
			Node<E> curr = head;
			for (int i=0; i<size-1; i++) {
				curr = curr.next;
			}
			curr.next = node;
		}
		size++;
	}
	
	/* 중간에 추가 */
	void add(int idx, E data) {
		if (idx < 0 || idx > size) return;
		
		if (idx == 0) {
			addAtFirst(data);
			return;
		}
		if (idx == size) {
			addAtLast(data);
			return;
		}
		
		Node<E> curr = head;
		for (int i=0; i<idx-1; i++) {
			curr = curr.next;
		}
		Node<E> node = new Node<>(data);
		node.next = curr.next;
		curr.next = node;
		size++;
	}
	
	/* 삭제 */
	/* 맨 앞 삭제 */
	E remove() {
		E data = head.data;
		head = head.next;
		size--;
		return data;
	}
	
	/* 중간 요소 삭제 */
	E remove(int idx) {
		if (idx < 0 || idx >= size) return null;
		if (idx == 0) {
			return remove();
		}
		Node<E> prev = head;
		for (int i=0; i<idx-1; i++) {
			prev = prev.next;
		}
		E data = prev.next.data;
		prev.next = prev.next.next;
		size--;
		return data;
	}
}

public class SinglyLinkedList {

	public static void main(String[] args) {
		SLL<String> sll = new SLL<>();
		sll.printSLL();
		sll.addAtFirst("홍길동");
		sll.printSLL();
		sll.addAtFirst("이순신");
		sll.printSLL();
		sll.addAtLast("강감찬");
		sll.printSLL();
		System.out.println(sll.getFirstData());
		System.out.println(sll.getLastData());
		System.out.println(sll.getData(1));
		sll.printSLL();
		sll.add(0, "이성계");
		sll.add(2, "세종대왕");
		sll.printSLL();
		sll.remove();
		sll.printSLL();
		sll.remove(3);
		sll.printSLL();
	}

}
