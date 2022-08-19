package stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

// 천재 수학자 성필
public class BaekJoon_15815 {
	static Stack<Integer> stack;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		stack = new Stack<>();
		String str = br.readLine();
		for (int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			if (c >= '0' && c <= '9') {
				stack.push(Character.getNumericValue(c));
				continue;
			}
			if (c == '*') {
				stack.push(stack.pop() * stack.pop());
				continue;
			}
			if (c == '/') {
				int a = stack.pop();
				int b = stack.pop();
				stack.push(b / a);
				continue;
			}
			if (c == '+') {
				stack.push(stack.pop()+stack.pop());
				continue;
			}
			if (c == '-') {
				int a = stack.pop();
				int b = stack.pop();
				stack.push(b - a);
				continue;
			}
		}
		System.out.println(stack.pop());
		br.close();
	}

}
