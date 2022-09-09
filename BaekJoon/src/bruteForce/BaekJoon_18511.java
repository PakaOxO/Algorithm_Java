package bruteForce;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_18511, 큰 수 구성하기 
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 완전 탐색을 하면서 주어진 숫자로 만들 수 있는 모든 조합을 찾음
 * 	2. 찾는 과정에서 N보다 커지면 return
 * 	3. 탐색으로 얻어낸 숫자 중 가장 큰 수를 출력 
 *
 */
public class BaekJoon_18511 {
	static int N, M;
	static int[] nums;
	static int max;
	
	static void dfs(int num) {
		if (num > N) return;
		
		max = Math.max(max, num);
		
		for (int i=0; i<M; i++) {
			dfs(num * 10 + nums[i]);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nums = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<M; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0);
		System.out.println(max);
		br.close();
	}

}
