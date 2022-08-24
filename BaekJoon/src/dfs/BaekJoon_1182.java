package dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 부분수열의 합
public class BaekJoon_1182 {
	static int N, S;
	static int[] nums;
	static int cnt;
	
	static void getCombination(int start, int sum) {
		if (start > 0 && sum == S) {
			cnt++;
		}
		
		for (int i=start; i<N; i++) {
			getCombination(i + 1, sum + nums[i]);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
	
		nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		cnt = 0;
		getCombination(0, 0);
		System.out.println(cnt);
	}

}
