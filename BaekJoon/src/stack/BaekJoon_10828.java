package stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 스택
/**
 * BaekJoon_10828, 스택
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. LIFO 구조로 직접 Stack을 구현하여 문제 풀이
 * 	2. Stack은 최대 입력 사이즈를 고려하여 배열로 구현
 * 		2.1 마지막에 추가된 위치를 가리키는 top 멤버변수 사용
 * 		2.2 현재 스택에 차있는 데이터의 개수를 나타내는 size 멤버변수 사용
 *	3. 스택의 기본 동작에 해당하는 메서드들을 호출하며 문제 수행
 *
 */
public class BaekJoon_10828 {
	static StringTokenizer st;
	
	static class Stack {
		int size;
		int top;
		int[] s;
		
		Stack(int size) {
			this.size = size;
			this.top = -1;
			this.s = new int[size];
		}
		
		void push(int val) {
			this.top++;
			s[top] = val;
		}
		
		int pop() {
			if (isEmpty()) return -1;
			int val = s[top];
			this.top--;
			return val;
		}
		
		int top() {
			if (isEmpty()) return -1;
			return s[top];
		}
		
		boolean isEmpty() {
			return top == -1;
		}
		
		boolean isFull() {
			return top == size;
		}
		
		int size() {
			return top + 1;
		}
		
		int empty() {
			if (isEmpty()) return 1;
			else return 0;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack s = new Stack(N);
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String op = st.nextToken();
			if (op.equals("push")) {
				s.push(Integer.parseInt(st.nextToken()));
			} else if (op.equals("pop")) {
				sb.append(s.pop()).append("\n");
			} else if (op.equals("size")) {
				sb.append(s.size()).append("\n");
			} else if (op.equals("top")) {
				sb.append(s.top()).append("\n");
			} else if (op.equals("empty")) {
				sb.append(s.empty()).append("\n");
			}
		}
		System.out.println(sb.toString().trim());
		br.close();
	}

}
