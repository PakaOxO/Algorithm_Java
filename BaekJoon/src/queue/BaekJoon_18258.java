package queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 큐 2
public class BaekJoon_18258 {
	static StringTokenizer st;
	
	static class RQueue {
		int head, tail;
		int last;
		Queue<Integer> q;
		
		RQueue() {
			this.head = 0;
			this.tail = 0;
			this.q = new LinkedList<>();
		}
		
		void push(int val) {
			q.add(val);
			last = val;
		}
		
		int pop() {
			if (isEmpty()) return -1;
			return q.poll();
		}
		
		int front() {
			if (isEmpty()) return -1;
			return q.peek();
		}
		
		int back() {
			if (isEmpty()) return -1;
			return last;
		}
		
		int size() {
			return q.size();
		}
		
		
		boolean isEmpty() {
			return q.isEmpty();
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Integer.parseInt(br.readLine());
		RQueue queue = new RQueue();
		StringBuilder sb = new StringBuilder();
		for (long i=0; i<N; i++) {
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
