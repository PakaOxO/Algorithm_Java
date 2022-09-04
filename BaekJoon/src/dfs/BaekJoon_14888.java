package dfs;

import java.io.*;
import java.util.*;

// 연산자 끼워넣기
public class BaekJoon_14888 {
	static int N;
	static int[] nums;
	static int[] operatorCnt;
	static int min, max;
	
	static void dfs(int result, int cnt) {
		if (cnt == N) {
			if (result > max) max = result;
			if (result < min) min = result;
			return;
		}
		
		for (int i=0; i<4; i++) {
			if (operatorCnt[i] == 0) continue;
			operatorCnt[i]--;
			if (i == 0) dfs(result + nums[cnt], cnt + 1);
			else if (i == 1) dfs (result - nums[cnt], cnt + 1);
			else if (i == 2) dfs (result * nums[cnt], cnt + 1);
			else {
				if (result < 0) dfs(result * (-1) / nums[cnt] * (-1), cnt + 1);
				else dfs(result / nums[cnt], cnt + 1);
			}
			operatorCnt[i]++;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		operatorCnt = new int[4];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<4; i++) {
			operatorCnt[i] += Integer.parseInt(st.nextToken());
		}
		
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		dfs(nums[0], 1);
		
		System.out.println(max);
		System.out.println(min);
		br.close();
	}

}
