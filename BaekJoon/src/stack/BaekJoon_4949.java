package stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

// 균형잡힌 세상
public class BaekJoon_4949 {
	static Stack<Character> stack;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str;
		while ( !(str = br.readLine()).equals(".") ) {
			String yn = "yes";
			stack = new Stack<>();
			for (int i=0; i<str.length(); i++) {
				char c = str.charAt(i);
				if (c != '(' && c != ')' && c != '[' && c != ']') continue;
				if (stack.size() == 0) {
					if (c == ')' || c == ']') {
						yn = "no";
						break;
					}
					stack.push(c);
					continue;
				}
				char top = stack.peek();
				if (top == '(' && c == ')') stack.pop();
				else if (top == '[' && c == ']') stack.pop();
				else stack.push(c);
			}
			if (stack.size() > 0) yn = "no";
			sb.append(yn).append("\n");
		}
		System.out.println(sb.toString().trim());
		br.close();
	}

}
