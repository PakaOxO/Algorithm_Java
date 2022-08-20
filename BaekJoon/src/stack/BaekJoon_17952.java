package stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// 과제는 끝나지 않아!
public class BaekJoon_17952 {
	static Stack<Integer[]> stack;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		stack = new Stack<>();
		int N = Integer.parseInt(br.readLine());
		int total = 0;
		Integer[] curr = null;
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int isHW = Integer.parseInt(st.nextToken());
			// 과제가 없으면...
			if (isHW == 0) {
				if (curr == null) continue;
				// 이전에 하던 과제가 있으면
				curr[1]--;
				if (curr[1] == 0) {
					total += curr[0];
					if (stack.size() > 0) {
						curr = stack.pop();
					}
				}
				continue;
			}
			// 과제가 있으면...
			if (curr != null) {
				stack.push(curr);
			}
			int score = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			time--;
			// 받자마자 끝낼 수 있므면
			if (time == 0) {
				total += score;
				// 이전에 하던거 있으면 다시 꺼냄
				if (stack.size() > 0) curr = stack.pop();
				continue;
			}
			// 없으면 curr에 저장해서 관리
			curr = new Integer[2];
			curr[0] = score;
			curr[1] = time;
		}
		System.out.println(total);
		br.close();
	}

}
