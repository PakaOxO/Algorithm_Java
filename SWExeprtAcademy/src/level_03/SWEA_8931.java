package level_03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 제로
public class SWEA_8931 {
	/* 배열로 스택 구현 */
	static class Stack {
		private int[] stack;
		private int top;
		
		Stack(int size) {
			stack = new int[size];
			top = -1;
		}
		
		void push(int val) {
			if (top + 1 >= stack.length) return;
			stack[++top] = val;
		}
		
		int pop() {
			if (top < 0) return -1; 
			int val = stack[top--];
			return val;
		}
		
		int size() {
			return top + 1;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i=1; i<=T; i++) {
			int K = Integer.parseInt(br.readLine());
			Stack stack = new Stack(K);
			for (int j=0; j<K; j++) {
				int input = Integer.parseInt(br.readLine());
				if (input != 0) stack.push(input);
				else stack.pop();
			}
			
			int sum = 0;
			while (stack.size() > 0) {
				sum += stack.pop();
			}
			sb.append("#" + i + " " + sum);
			if (i < T) sb.append("\n");
		}
		System.out.println(sb);
		br.close();
	}

}
