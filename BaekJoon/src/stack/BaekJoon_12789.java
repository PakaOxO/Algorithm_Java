package stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// 도키도키 간식드리미
public class BaekJoon_12789 {
	static int[] input;
	static Stack<Integer> stack;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		input = new int[N];
		stack = new Stack<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		boolean flag = true;
		int next = 1;
		int idx = 0;
		while (idx < N) {
			if (input[idx] == next) {
				idx++;
				next++;
				continue;
			}
			if (stack.size() > 0 && stack.peek() == next) {
				stack.pop();
				next++;
				continue;
			}
			if (idx + 1 < N && input[idx] < input[idx+1]) {
				flag = false;
				break;
			}
			if (idx + 1 < N && input[idx] > input[idx+1]) {
				stack.add(input[idx++]);
			}
		}
		if (flag) System.out.println("Nice");
		else System.out.println("Sad");
		br.close();
	}

}
