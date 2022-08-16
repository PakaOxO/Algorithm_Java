package queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 카드 1
public class BaekJoon_2161 {
	
	static class Queue {
		int head;
		int tail;
		int size;
		int itemCnt;
		int[] arr;
		
		Queue(int size) {
			this.head = 0;
			this.tail = 0;
			this.itemCnt = 0;
			this.size = size + 1;
			arr = new int[size + 1];
		}
		
		boolean isFull() {
			return head == (tail + 1) % size;
		}
		
		boolean isEmpty() {
			return head == tail;
		}
		
		int getSize() {
			return this.itemCnt;
		}
		
		void enque(int val) {
			if (isFull()) return;
			this.tail = (tail + 1) % size;
			this.itemCnt++;
			arr[tail] = val;
		}
		
		int deque() {
			if (isEmpty()) return -1;
			this.head = (head + 1) % size;
			this.itemCnt--;
			return arr[this.head];
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue rQ = new Queue(N);
		for (int i=1; i<=N; i++) {
			rQ.enque(i);
		}
		StringBuilder sb = new StringBuilder();
		while (rQ.getSize() > 1) {
			sb.append(rQ.deque() + " ");
			rQ.enque(rQ.deque());
		}
		sb.append(rQ.deque());
		System.out.println(sb);
		br.close();
	}

}
