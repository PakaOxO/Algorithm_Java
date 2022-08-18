package stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

// 스택 수열
public class BaekJoon_1874 {
	static Stack<Integer> stack;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		int num = 1;
		int cnt = 0;
		while (cnt < N) {
			int input = Integer.parseInt(br.readLine());
			cnt++;
			if (input >= num) {
				while (num <= input) {
					stack.push(num++);
					sb.append("+\n");
				}
				stack.pop();
				sb.append("-\n");
				continue;
			}
			if (stack.size() == 0) {
				sb = new StringBuilder();
				sb.append("NO");
				break;
			}
			if (stack.peek() > input) {
				sb = new StringBuilder();
				sb.append("NO");
				break;
			}
			if (stack.peek() == input) {
				stack.pop();
				sb.append("-\n");
				continue;
			}
		}
		System.out.println(sb);
		br.close();
	}

}
