package stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

// 원숭이 매달기
public class BaekJoon_2716 {
	static Stack<Character> stack;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc=1; tc<=T; tc++) {
			String str = br.readLine();
			int N = str.length();
			stack = new Stack<>();
			
			int max = 0;
			for (int i=0; i<N; i++) {
				char c = str.charAt(i);
				if (c == '[') {
					stack.push(c);
					if (stack.size() > max) max = stack.size();
				} else {
					stack.pop();
				}
			}
			sb.append((int)Math.pow(2, max)).append("\n");
		}
		
		System.out.print(sb);
		br.close();
	}

}
