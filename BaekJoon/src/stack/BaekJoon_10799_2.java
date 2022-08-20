package stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BaekJoon_10799_2 {
	static Stack<Character> stack;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		stack = new Stack<>();
		int answer = 0;
		for (int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			
			if (c == '(' && str.charAt(i + 1) != ')') {
				stack.push(c);
				answer++;
				continue;
			}
			if (c == '(' && str.charAt(i + 1) == ')') {
				answer += stack.size();
				i++;
				continue;
			}
				
			if (c == ')' && str.charAt(i - 1) != '(') {
				stack.pop();
				continue;
			}
		}
		System.out.println(answer);
		br.close();
	}

}
