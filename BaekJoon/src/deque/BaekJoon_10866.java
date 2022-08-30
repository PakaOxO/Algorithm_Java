package deque;

import java.io.*;
import java.util.*;

class Node {
	int data;
	Node prev;
	Node next;
	
	Node(int data) {
		this.data = data;
	}
}

class Deque {
	private int size;
	private Node head;
	private Node tail;
	
	Deque() {
		this.size = 0;
	}
	
	int isEmpty() {
		if (this.size == 0) return 1;
		else return 0;
	}
	
	int size() {
		return this.size;
	}
	
	int front() {
		if (isEmpty() == 1) return -1;
		return this.head.data;
	}
	
	int back() {
		if (isEmpty() == 1) return -1;
		return this.tail.data;
	}
	
	void pushFront(int data) {
		Node node = new Node(data);
		if (isEmpty() == 1) {
			this.head = node;
			this.tail = node;
			this.size++;
			return;
		}
		node.next = this.head;
		this.head.prev = node;
		this.head = node;
		this.size++;
	}
	
	void pushBack(int data) {
		Node node = new Node(data);
		if (isEmpty() == 1) {
			this.head = node;
			this.tail = node;
			this.size++;
			return;
		}
		node.prev = this.tail;
		this.tail.next = node;
		this.tail = node;
		this.size++;
	}
	
	int popFront() {
		if (isEmpty() == 1) return -1;
		int val = this.head.data;
		if (size() == 1) {
			this.head = null;
			this.tail = null;
			this.size--;
			return val;
		}
		this.head = this.head.next;
		this.head.prev = null;
		this.size--;
		return val;
	}
	
	int popBack() {
		if (isEmpty() == 1) return -1;
		int val = this.tail.data;
		if (size() == 1) {
			this.head = null;
			this.tail = null;
			this.size--;
			return val;
		}
		this.tail.prev.next = null;
		this.tail = this.tail.prev;
		this.size--;
		return val;
	}
}

// 덱
public class BaekJoon_10866 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		Deque d = new Deque();
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String order = st.nextToken();
			if (order.equals("size")) {
				sb.append(d.size()).append("\n");
			} else if (order.equals("empty")) {
				sb.append(d.isEmpty()).append("\n");
			} else if (order.equals("front")) {
				sb.append(d.front()).append("\n");
			} else if (order.equals("back")) {
				sb.append(d.back()).append("\n");
			} else if (order.equals("push_front")) {
				int data = Integer.parseInt(st.nextToken());
				d.pushFront(data);
			} else if (order.equals("push_back")) {
				int data = Integer.parseInt(st.nextToken());
				d.pushBack(data);
			} else if (order.equals("pop_front")) {
				sb.append(d.popFront()).append("\n");
			} else if(order.equals("pop_back")) {
				sb.append(d.popBack()).append("\n");
			}
		}
		System.out.print(sb);
		br.close();
	}

}
