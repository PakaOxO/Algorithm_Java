package stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * BaekJoon_1874, 스택 수열
 * @author kevin-Arpe
 *
 * Sketch Idea
 * 	1. 스택의 동작 방식을 그대로 사용하여 푸는 문제
 * 		1.1 1부터 시작(num)하여 N까지 증가하는데 입력으로 주어진 숫자를 pop 해야하므로
 * 		1.2 입력받은 숫자보다 num이 작으면 같아질 때까지 push(+), 같아지면 pop(-)
 * 	2. 수열을 만들 수 없는 경우에는 예외처리
 * 		2.1 pop 해야할 숫자보다 stack 안에 들어있는 숫자가 크다면 해당 수열은 만들 수 없으므로 예외처리
 * 		2.2 pop을 해야하는데 stack에 담긴게 없다면 예외처리
 * 		
 */
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
