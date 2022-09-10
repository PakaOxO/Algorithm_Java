package bruteForce;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_5568, 카드 놓기 
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. N개의 수에서 K개의 숫자를 뽑을 수 있는 순열을 찾는 문제 
 * 	2. K개를 뽑는 과정에서 이번에 뽑힌 숫자가 10이상이면 기존 수에 100을 10미만이면 10을 곱해 자리수를 맞춤
 * 	3. K개를 사용해 만든 수를 Set에 넣어 중복 제거 
 * 	4. Set의 크기를 출력해 만들 수 있는 숫자의 개수를 리턴 
 *
 */
public class BaekJoon_5568 {
	static int N, K;
	static int[] arr;
	static boolean[] isVisited;
	static Set<Integer> set;
	
	static void dfs(int num, int cnt) {
		if (cnt == K) {
			set.add(num);
			return;
		}
		
		for (int i=0; i<N; i++) {
			if (isVisited[i]) continue;
			isVisited[i] = true;
			if (arr[i] >= 10) dfs(num * 100 + arr[i], cnt + 1);
			else dfs(num * 10 + arr[i], cnt + 1);
			isVisited[i] = false;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		arr = new int[N];
		isVisited = new boolean[N];
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		set = new HashSet<>();
		dfs(0, 0);
		System.out.println(set.size());
		br.close();
	}

}
