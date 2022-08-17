package stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BaekJoon_3986 {
	static class Stack {
		char[] stack;
		int top;
		
		Stack(int size) {
			this.top = -1;
			this.stack = new char[size];
		}
		
		void push(char data) {
			this.stack[++this.top] = data;
		}
		
		void pop() {
			if (size() == 0) return;
			this.top--;
		}
		
		char peek() {
			return stack[top];
		}
		
		int size() {
			return this.top + 1;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		for (int i=0; i<N; i++) {
			String str = br.readLine();
			Stack stack = new Stack(str.length());
			for (int j=0; j<str.length(); j++) {
				char c = str.charAt(j);
				if (stack.size() == 0) {
					stack.push(c);
					continue;
				}
				if (stack.peek() == c) {
					stack.pop();
					continue;
				}
				stack.push(c);
			}
			if (stack.size() == 0) answer++;
		}
		System.out.println(answer);
		br.close();
	}

}
