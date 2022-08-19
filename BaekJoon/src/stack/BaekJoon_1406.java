package stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// 에디터
public class BaekJoon_1406 {
	static Stack<Character> rStack;
	static Stack<Character> lStack;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		lStack = new Stack<>();
		rStack = new Stack<>();
		
		String str = br.readLine();
		for (int i=0; i<str.length(); i++) {
			lStack.push(str.charAt(i));
		}
		
		int N = Integer.parseInt(br.readLine());
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char c = st.nextToken().charAt(0);
			if (c == 'L') {
				if (lStack.size() == 0) continue;
				rStack.push(lStack.pop());
				continue;
			}
			if (c == 'D') {
				if (rStack.size() == 0) continue;
				lStack.push(rStack.pop());
				continue;
			}
			if (c == 'B') {
				if (lStack.size() == 0) continue;
				lStack.pop();
				continue;
			}
			if (c == 'P') {
				char l = st.nextToken().charAt(0);
				lStack.push(l);
				continue;
			}
		}
		StringBuilder sb = new StringBuilder();
		while (lStack.size() > 0) {
			sb.append(lStack.pop());
		}
		sb.reverse();
		while (rStack.size() > 0) {
			sb.append(rStack.pop());
		}
		System.out.println(sb);
		br.close();
	}

}
