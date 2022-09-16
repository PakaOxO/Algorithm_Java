package bruteForce;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_21943, 연산 최대로
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 
 *
 */
public class BaekJoon_21943 {
	static int N;
	static int[] nums;
	static int[] opCnt;
	static boolean[] comb;
	static int max;
	
	static void cal() {
		Deque<Integer> q = new LinkedList<>();
		for (int num : nums) q.addLast(num);
		for (int i=0; i<N-1; i++) {
			if (comb[i]) q.addFirst(q.removeFirst() + q.removeFirst());
			else q.addLast(q.removeFirst());
		}
		System.out.println(q);
		int result = 0;
		if (q.size() > 0) result = q.removeFirst();
		while (q.size() > 0) result *= q.removeFirst();
		
		max = Math.max(max, result);
	}
	
	static void dfs(int depth) {
		if (depth == N - 1) {
			System.out.println(Arrays.toString(comb));
			cal();
			return;
		}
		
		if (opCnt[0] > 0) {
			comb[depth] = true;
			opCnt[0]--;
			dfs(depth + 1);
			comb[depth] = false;
			opCnt[0]++;
		}
		if (opCnt[1] > 0) {
			opCnt[1]--;
			dfs(depth + 1);
			opCnt[1]++;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		nums = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		opCnt = new int[2];
		for (int i=0; i<2; i++) {
			opCnt[i] = Integer.parseInt(st.nextToken());
		}
		
		comb = new boolean[N - 1];
		max = 0;
		dfs(0);
		
		System.out.println(max);
		br.close();
	}

}
