package dfs;

import java.io.*;
import java.util.*;

// 가르침
public class BaekJoon_1062 {
	static int N, K;
	static String[] words;
	static int[] isLearned;
	static boolean[] isVisited;
	static int max;
	
	static void dfs(int start, int lCnt) {
		if (lCnt == K) {
			int cnt = 0;
			// O(N*K) 시간복잡도
			for (int i=0; i<N; i++) {
				boolean flag = true;
				for (int j=4; j<words[i].length()-4; j++) {
					if (!isVisited[words[i].charAt(j) - 'a']) {
						flag = false;
						break;
					}
				}
				if (flag) cnt++;
			}
			if (cnt > max) max = cnt;
			return;
		}
		
		for (int i=start; i<26; i++) {
			if (isVisited[i]) continue;
			isVisited[i] = true;
			dfs(i, lCnt + 1);
			isVisited[i] = false;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		if (K < 5) {
			System.out.println(0);
			return;
		} else if (K == 26) {
			System.out.println(N);
			return;
		}
		
		isVisited = new boolean[26];
		isVisited['a' - 'a'] = true;
		isVisited['n' - 'a'] = true;
		isVisited['t' - 'a'] = true;
		isVisited['i' - 'a'] = true;
		isVisited['c' - 'a'] = true;
		
		words = new String[N];
		for (int i=0; i<N; i++) {
			words[i] = br.readLine();
		}
		
		dfs(0, 5);
		
		System.out.println(max);
		br.close();
	}

}
