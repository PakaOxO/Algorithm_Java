package queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BaekJoon_10845, 큐
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 큐의 동작방식을 이해하기 위한 문제
 * 	2. 직접 FIFO 구조의 자료구조(Queue) 클래스를 구현
 * 		2.1 큐 안에 들어있는 요소의 개수를 나타낼 size 멤버변수 선언
 * 		2.2 큐의 처음, 마지막 요소의 위치(index)를 확인할 head, tail 멤버변수 선언
 * 		2.3 큐의 동작 방식에 따른 메서드 구현
 * 
 *  3. 입력으로 주어지는 명령들을 수행하여 결과를 문자열에 저장
 *  
 */
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
