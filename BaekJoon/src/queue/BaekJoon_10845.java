package queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_10845 {
	static StringTokenizer st;
	
	static class Queue {
		int head, tail;
		int size, qSize;
		int[] q;
		
		Queue(int qSize) {
			this.qSize = qSize + 1;
			this.size = 0;
			this.head = 0;
			this.tail = 0;
			this.q = new int[this.qSize];
		}
		
		void push(int val) {
			if (isFull()) return;
			tail = (tail + 1) % qSize;
			q[tail] = val;
			this.size++;
		}
		
		int pop() {
			if (isEmpty()) return -1;
			head = (head + 1) % qSize;
			this.size--;
			return q[head];
		}
		
		int front() {
			if (isEmpty()) return -1;
			return q[(head + 1) % qSize];
		}
		
		int back() {
			if (isEmpty()) return -1;
			return q[tail];
		}
		
		int size() {
			return this.size;
		}
		
		boolean isFull() {
			return head == (tail + 1) % qSize;
		}
		
		boolean isEmpty() {
			return head == tail;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue queue = new Queue(10000);
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String op = st.nextToken();
			if (op.equals("push")) {
				int input = Integer.parseInt(st.nextToken());
				queue.push(input);
			} else if (op.equals("pop")) {
				sb.append(queue.pop() + "\n");
			} else if (op.equals("front")) {
				sb.append(queue.front() + "\n");
			} else if (op.equals("back")) {
				sb.append(queue.back() + "\n");
			} else if (op.equals("size")) {
				sb.append(queue.size() + "\n");
			} else if (op.equals("empty")) {
				if (queue.isEmpty()) {
					sb.append(1 + "\n");
				} else {
					sb.append(0 + "\n");
				}
			}
		}
		System.out.println(sb.toString().trim());
		br.close();
	}

}
