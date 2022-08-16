package queue;

import java.util.Arrays;

public class 원형큐 {
	
	static class Queue {
		int size;
		int head;
		int tail;
		int cnt;
		int[] q;
		
		Queue(int size) {
			this.q = new int[size + 1];
			this.size = size + 1;
			this.head = 0;
			this.tail = 0;
			this.cnt = 0;
		}
		
		void enque(int val) {
			if (isFull()) return;
			tail = (tail + 1) % size;
			q[tail] = val;
		}
		
		int deque() {
			if (isEmpty()) return -1;
			head = (head + 1) % size;
			return q[head];
		}
		
		boolean isFull() {
			return head == (tail + 1) % size;
		}
		
		boolean isEmpty() {
			return head == tail;
		}
	}

	public static void main(String[] args) {
		Queue rQ = new Queue(10);
		for (int i=1; i<=10; i++) {
			rQ.enque(i);
		}
		
		for (int i=0; i<4; i++) {
			rQ.deque();
		}
		
		for (int i=1; i<=2; i++) {
			rQ.enque(i);
		}
		System.out.println(Arrays.toString(rQ.q));
		System.out.println(rQ.head);
	}

}
