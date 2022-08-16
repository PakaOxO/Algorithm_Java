package queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 카드 2
public class BaekJoon_2164 {
	
	static class Queue {
		int head, tail;
		int size;
		int cnt;
		int[] q;
		
		Queue(int size) {
			this.head = 0;
			this.tail = 0;
			this.q = new int[size + 1];
			this.size = size + 1;
			this.cnt = 0;
		}
		
		void enque(int val) {
			if (isFulled()) return;
			tail = (tail + 1) % size;
			q[tail] = val;
			this.cnt++;
		}
		
		int deque() {
			if (isEmpty()) return -1;
			head = (head + 1) % size;
			this.cnt--;
			return q[head];
		}
		
		boolean isFulled() {
			return head == (tail + 1) % size;
		}
		
		boolean isEmpty() {
			return head == tail;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue q = new Queue(N);
		for (int i=1; i<=N; i++) {
			q.enque(i);
		}
		
		while (q.cnt > 1) {
			q.deque();
			q.enque(q.deque());
		}
		System.out.println(q.deque());
		br.close();
	}

}
