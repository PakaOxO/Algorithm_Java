package list;

public class Test {

	public static void main(String[] args) {
		DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
		
		dll.addAtFirst(0);
		dll.addAtFirst(1);
		dll.addAtFirst(2);
		dll.printList();
		
		dll.addAtLast(3);
		dll.addAtLast(4);
		dll.printList();
		
		dll.add(5, 2);
		dll.printList();
		
		System.out.println(dll.getData(0));
		System.out.println(dll.getData(4));
		System.out.println(dll.getData(6));
		System.out.println(dll.getData(-1));
		System.out.println(dll.getData(1));
		
		dll.removeHead();
		dll.printList();
		
		dll.removeTail();
		dll.printList();
		
		dll.remove(0);
		dll.printList();
		
		dll.remove(2);
		dll.printList();
		
		dll.remove(0);
		dll.printList();
		
//		SinglyLinkedList<Integer> sll = new SinglyLinkedList<>();
//		sll.addAtFirst(0);
//		sll.addAtFirst(1);
//		sll.addAtFirst(2);
//		sll.addAtFirst(3);
//		sll.printList();
//		
//		sll.addAtLast(4);
//		sll.printList();
//		
//		sll.add(11, 2);
//		sll.printList();
//		
//		sll.removeTail();
//		sll.printList();
//		
//		sll.remove(2);
//		sll.printList();
	}

}
