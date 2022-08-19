package level_03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 암호 생성기 (큐 구현)
public class SWEA_1225_3 {
	static class Node {
		Node next;
		int data;
		
		Node(int data) {
			this.data = data;
		}
	}
	
	static class LinkedQueue {
		Node front;
		Node rear;
		int size;
		
		LinkedQueue() {
			this.size = 0;
		}
		
		boolean isEmpty() {
			return this.size == 0;
		}
		
		void enque(int data) {
			Node node = new Node(data);
			if (isEmpty()) {
				front = node;
				rear = node;
				size++;
				return;
			}
			rear.next = node;
			rear = node;
			size++;
		}
		
		int deque() {
			if (isEmpty()) return -1;
			int data = front.data;
			front = front.next;
			size--;
			return data;
		}
		
		String getData() {
			StringBuilder sb = new StringBuilder();
			Node node = front;
			while (node != null) {
				sb.append(node.data);
				if (node.next != null) sb.append(" ");
				node = node.next;
			}
			return sb.toString();
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str;
		while ( (str = br.readLine()) != null ) {
			int tc = Integer.parseInt(str);
			LinkedQueue lq = new LinkedQueue();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i=0; i<8; i++) {
				lq.enque(Integer.parseInt(st.nextToken()));
			}
			int reducer = 1;
			while (true) {
				int data = lq.deque();
				data = (data - reducer < 0) ? 0 : data - reducer;
				lq.enque(data);
				reducer = (reducer + 1 > 5) ? 1 : reducer + 1;
				if (data == 0) break;
			}
			sb.append("#").append(tc).append(" ").append(lq.getData()).append("\n");
		}
		System.out.print(sb);
		br.close();
	}

}
