package stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

// 괄호 끼워넣기
public class BaekJoon_11899 {
	static Stack<Character> stack;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		stack = new Stack<>();
		String str = br.readLine();
		for (int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			if (stack.size() == 0) {
				stack.push(c);
				continue;
			}
			if (c == ')' && stack.peek() == '(') {
				stack.pop();
				continue;
			}
			stack.push(c);
		}
		System.out.println(stack.size());
		br.close();
	}

}
