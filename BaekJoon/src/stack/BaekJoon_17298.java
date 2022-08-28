package stack;

import java.io.*;
import java.util.*;

// 오큰수
public class BaekJoon_17298 {
	static int[] arr;
	static Stack<Integer> stack;
	static int[] answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		arr = new int[N];
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		stack = new Stack<>();
		answer = new int[N];
		stack.push(0);
		for (int i=1; i<N; i++) {
			while (stack.size() > 0 && arr[stack.peek()] < arr[i]) {
				answer[stack.pop()] = arr[i];
			}
			stack.push(i);
		}
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<N; i++) {
			if (answer[i] == 0) sb.append(-1);
			else sb.append(answer[i]);
			
			if (i < N - 1) sb.append(" ");
		}
		System.out.print(sb);
		br.close();
	}

}