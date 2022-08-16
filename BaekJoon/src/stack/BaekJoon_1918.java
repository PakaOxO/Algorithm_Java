package stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

//후위 표기식
public class BaekJoon_1918 {
	static Stack<Character> stack;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String input = br.readLine();
		stack = new Stack<>();
		for (int i=0; i<input.length(); i++) {
			char c = input.charAt(i);
			if (c != '+' && c!= '-' && c!= '*' && c!='/' && c!= '(' && c!=')') {
				sb.append(c);
				continue;
			} else {
				if (stack.size() < 1) stack.push(c);
				else {
					int weightC = 0;
					if (c == '+' || c == '-') weightC = 1;
					else if (c == '*' || c == '/') weightC = 2;
					else weightC = 3;
					
					char operator;
					while (stack.size() > 0) {
						operator = stack.pop();
						if (c == ')') {
							if (operator == '(') break;
							sb.append(operator);
							continue;
						}
						int weightO = 0;
						if (operator == '+' || operator == '-') weightO = 1;
						else if (operator == '*' || operator == '/') weightO = 2;
						else weightO = 0;
						if (weightC > weightO) {
							stack.push(operator);
							stack.push(c);
							break;
						} else {
							sb.append(operator);
							if (stack.size() == 0) {
								stack.push(c);
								break;
							}
							continue;
						}
					}
				}
			}
		}
		while (stack.size() > 0) {
			sb.append(stack.pop());
		}
		System.out.println(sb);
		br.close();
	}

}
