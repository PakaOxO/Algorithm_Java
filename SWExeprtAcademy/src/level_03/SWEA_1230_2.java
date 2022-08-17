package level_03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// 암호문 3 (LinkedList 사용)
public class SWEA_1230_2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		SinglyLinkedList sll = new SinglyLinkedList();
		int T = 10;
		StringBuilder sb = new StringBuilder();
		for (int i=1; i<=T; i++) {
			sb.append("#" + i + " ");
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			for (int j=0; j<N; j++) {
				sll.add(Integer.parseInt(st.nextToken()));
			}
			int K = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine().trim());
			for (int j=0; j<K; j++) {
				String op = st.nextToken();
				if (op.equals("A")) {
					int cnt = Integer.parseInt(st.nextToken());
					for (int k=0; k<cnt; k++) {
						sll.add(Integer.parseInt(st.nextToken()));
					}
				} else if (op.equals("I")) {
					int idx = Integer.parseInt(st.nextToken());
					int cnt = Integer.parseInt(st.nextToken());
					for (int k=0; k<cnt; k++) {
						sll.insert(idx++, Integer.parseInt(st.nextToken()));
					}
				} else if (op.equals("D")) {
					int idx = Integer.parseInt(st.nextToken());
					int cnt = Integer.parseInt(st.nextToken());
					sll.delete(idx, cnt);
				}
			}
			Node node = sll.head;
			for (int j=0; j<10; j++) {
				sb.append(node.data);
				if (j != 9) sb.append(" ");
				node = node.next;
			}
			sb.append("\n");
		}
		System.out.println(sb.toString().trim());
		br.close();
	}

}

class Node {
	Node next;
	int data;
	
	Node(int data) {
		this.data = data;
	}
}

class SinglyLinkedList {
	Node head;
	Node tail;
	private int size;
	
	SinglyLinkedList() {
		this.size = 0;
	}
	
	
	void add(int data) {
		Node node = new Node(data);
		if (size == 0) {
			this.head = node;
			this.tail = head;
			size++;
			return;
		}
		tail.next = node;
		this.tail = node;
		size++;
	}
	
	void insert(int idx, int data) {
		if (idx < 0 || idx >= size) return;
		if (idx == 0) {
			Node node = new Node(data);
			node.next = head;
			head = node;
			size++;
			return;
		}
		Node prev = head;
		for (int i=0; i<idx-1; i++) {
			prev = prev.next;
		}
		Node node = new Node(data);
		node.next = prev.next;
		prev.next = node;
		size++;
	}
	
	void delete(int idx, int cnt) {
		if (idx < 0 || idx >= size - cnt) return;
		if (idx == 0) {
			for (int i=0; i<cnt; i++) {
				head = head.next;
			}
			size -= cnt;
			return;
		}
		Node prev = head;
		for (int i=0; i<idx-1; i++) {
			prev = prev.next;
		}
		Node next = prev;
		for (int i=0; i<=cnt; i++) {
			next = next.next;
		}
		prev.next = next;
		size -= cnt;
		return;
	}
	
	int size() {
		return size;
	}
	
	void print() {
		Node curr = head;
		while (curr != null) {
			System.out.println(curr.data);
			curr = curr.next;
		}
		System.out.println("========");
	}
}
