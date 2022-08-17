package stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

// 제로
public class BaekJoon_10773 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		for (int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			if (stack.size() == 0) {
				stack.push(num);
				continue;
			}
			if (num == 0) {
				stack.pop();
				continue;
			} stack.push(num);
		}
		int sum = 0;
		while (stack.size() > 0) {
			sum += stack.pop();
		}
		System.out.println(sum);
		br.close();
	}

}
