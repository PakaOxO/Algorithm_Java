package level_04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

// 괄호 짝짓기
public class SWEA_1218 {
	static Stack<Character> stack;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = 10;
		for (int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			String str = br.readLine();
			stack = new Stack<>();
			boolean isValid = true;
			for (int i=0; i<N; i++) {
				char c = str.charAt(i);
				if (stack.size() == 0) {
					if (c == '>' || c == ')' || c == '}' || c == ']') {
						isValid = false;
						break;
					}
					stack.push(c);
					continue;
				}
				
				if (c == '>' && stack.peek() == '<') stack.pop();
				else if (c == ')' && stack.peek() == '(') stack.pop();
				else if (c == '}' && stack.peek() == '{') stack.pop();
				else if (c == ']' && stack.peek() == '[') stack.pop();
				else stack.push(c);
			}
			if (stack.size() > 0) isValid = false;
			sb.append("#").append(tc).append(" ");
			if (isValid) sb.append(1);
			else sb.append(0);
			sb.append("\n");
		}
		System.out.print(sb);
		br.close();
	}

}
