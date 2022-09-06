package dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BaekJoon_1182, 부분수열의 합
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 조합의 합이 S가 되는 경우의 개수를 찾는 문제이므로 먼저 나올 수 있는 모든 조합을 탐색
 * 	2. 크기가 1 이상인 조합을 탐색하면서 합이 S가 되는 시점에 cnt + 1
 * 	3. 모든 조합의 탐색이 끝난 후 cnt를 출력
 *
 */
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
		br.close();
	}

}
