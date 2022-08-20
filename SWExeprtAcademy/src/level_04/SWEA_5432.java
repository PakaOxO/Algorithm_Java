package level_04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA_5432 {
	static Stack<Character> stack;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc=1; tc<=T; tc++) {
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
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.print(sb);
		br.close();
	}

}
