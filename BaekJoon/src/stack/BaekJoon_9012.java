package stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

// 괄호
public class BaekJoon_9012 {
	static Stack<Character> stack;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int i=0; i<T; i++) {
			String input = br.readLine();
			stack = new Stack<>();
			boolean isRight = true;
			for (int j=0; j<input.length(); j++) {
				char c = input.charAt(j);
				if (c == ')') {
					if (stack.isEmpty()) {
						isRight = false;
						break;
					}
					stack.pop();
				} else {
					stack.push(input.charAt(j));
				}
			}
			if (!isRight || stack.size() > 0) sb.append("NO\n");
			else sb.append("YES\n");
		}
		System.out.println(sb);
		br.close();
	}

}
