package bruteForce;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_14225, 부분 수열의 합 
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 숫자를 1개 뽑는 조합, 2개 뽑는 조합... N개 뽑는 조합을 탐색하면서 나올 수 있는 숫자의 합의 종류를 기록 
 * 	2. 모든 조합을 탐색한 뒤 숫자의 합 중 나오지 않은 숫자 중에서 가장 작은 수를 출력 
 *
 */
public class BaekJoon_14225 {
	static int N;
	static int[] arr;
	static boolean[] isVisited;
	
	static void dfs(int depth, int sum) {
		for (int i=depth; i<N; i++) {
			isVisited[sum + arr[i]] = true;
			dfs(i + 1, sum + arr[i]);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		br.close();
		Arrays.sort(arr);
		
		isVisited = new boolean[2000001];
		dfs(0, 0);
		
		int answer = 0;
		for (int i=1; i<2000001; i++) {
			if (!isVisited[i]) {
				answer = i;
				break;
			}
		}
		
		System.out.println(answer);
	}

}
