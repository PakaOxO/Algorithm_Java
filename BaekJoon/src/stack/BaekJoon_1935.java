package stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

// 후위 표기식 2
public class BaekJoon_1935 {
	
	static int[] nums;
	static Stack<Double> stack;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String input = br.readLine();
		nums = new int[N];
		for (int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		stack = new Stack<>();
		for (int i=0; i<input.length(); i++) {
			char c = input.charAt(i);
			if (c != '+' && c!= '-' && c!= '*' && c!='/') {
				stack.push((double)nums[(int)(c - 'A')]);
				continue;
			}
			
			if (c == '+') {
				double num1 = stack.pop();
				double num2 = stack.pop();
				stack.push(num1 + num2);
			} else if (c == '-') {
				double num2 = stack.pop();
				double num1 = stack.pop();
				stack.push(num1 - num2);
			} else if (c == '*') {
				double num1 = stack.pop();
				double num2 = stack.pop();
				stack.push(num1 * num2);
			} else {
				double num2 = stack.pop();
				double num1 = stack.pop();
				stack.push(num1 / num2);
			}
		}
		System.out.printf("%.2f", stack.pop());
		br.close();
	}

}
