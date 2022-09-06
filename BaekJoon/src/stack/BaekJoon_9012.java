package stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * BaekJoon_9012, 괄호
 * @author kevin-Arpe
 *
 * Sketch Idea
 * 	1. 스택을 사용하여 괄호의 유효성을 체크하는 문제
 * 	2. ')'를 입력받았을 때,
 * 		2.1 스택 상단에 '('가 있으면 pop
 * 		2.2 없으면 유효하지 않은 괄호
 *  3. 과정이 종료된 후 스택에 남은 괄호가 있을 때에는 괄호 쌍이 맞지 않으므로 유효하지 않음
 *  
 */
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
