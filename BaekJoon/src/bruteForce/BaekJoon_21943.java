package bruteForce;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_21943, 연산 최대로
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 먼저 괄호를 통해 모든 덧셈을 계산한 수들로 곱셈 연산을 하는 것이 가장 그리디한 풀이
 * 	2. 곱셈할 숫자는 최소 (곱셈 연산자 개수) + 1 이므로 완전 탐색을 통해 곱셈할 숫자의 위치에 숫자들의 합을 넣는다.
 * 	3. 모든 덧셈 연산이 종료되면 곱셈 연산을 수행한 뒤 최대값인지 판별한다.
 *
 */
public class BaekJoon_21943 {
	static int N;
	static int[] nums;
	static int[] opCnt;
	static int[] sums;
	static int max;
	
	static void dfs(int cnt, int idx) {
		if (cnt == N) {
			int multi = sums[0];
			for (int i=1; i<opCnt[1]+1; i++) {
				multi *= sums[i];
			}
			max = Math.max(max, multi);
			return;
		}
		
		for (int i=0; i<opCnt[1] + 1; i++) { 
			sums[i] += nums[idx];
			dfs(cnt + 1, idx + 1);
			sums[i] -= nums[idx];
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
		
		sums = new int[opCnt[1] + 1];
		sums[0] += nums[0];
		sums = new int[opCnt[1] + 1];
		max = 0;
		
		dfs(0, 0);
		
		System.out.println(max);
		br.close();
	}

}
