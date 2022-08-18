package stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

// 단어 뒤집기 2
public class BaekJoon_17413 {
	static Stack<Character> stack = new Stack<>();
	
	static String stackPop() {
		StringBuilder sb = new StringBuilder();
		while (stack.size() > 0) {
			sb.append(stack.pop());
		}
		return sb.toString();
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int len = str.length();
		int idx = 0;
		StringBuilder sb = new StringBuilder();
		while (idx < len) {
			char c = str.charAt(idx++);
			if (c == '<') {
				if (stack.size() > 0) sb.append(stackPop());
				while (c != '>') {
					sb.append(c);
					c = str.charAt(idx++);
				}
				sb.append(c);
				continue;
			}
			
			if (c == ' ') {
				if (stack.size() > 0) sb.append(stackPop());
				sb.append(c);
			} else {
				stack.push(c);
			}
		}
		if (stack.size() > 0) sb.append(stackPop());
		System.out.println(sb);
		br.close();
	}

}
