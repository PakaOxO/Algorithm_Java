package stack;

import java.io.*;
import java.util.*;

/**
 * 백준_17299, 오등큰수
 * @author arpeg
 * Sketch idea
 * 
 */

// 오등큰수
public class BaekJoon_17299 {
	static int[] arr;
	static int[] cnt;
	static int[] answer;
	static Stack<Integer> stack;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		arr = new int[N];
		cnt = new int[1000001];
		for (int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			cnt[num]++;
			arr[i] = num;
		}
		
		answer = new int[N];
		stack = new Stack<>();
		
		answer[N - 1] = -1;
		stack.push(arr[N - 1]);
		for (int i=N-2; i>=0; i--) {
			while (stack.size() > 0 && cnt[stack.peek()] <= cnt[arr[i]]) {
				stack.pop();
			}
			if (stack.size() > 0) answer[i] = stack.peek();
			else answer[i] = -1;
			stack.push(arr[i]);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<N; i++) {
			if (i < N - 1) sb.append(answer[i]).append(" ");
			else sb.append(answer[i]);
		}
		System.out.println(sb);
		br.close();
	}

}
