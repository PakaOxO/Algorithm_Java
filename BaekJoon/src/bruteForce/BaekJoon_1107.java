package bruteForce;

import java.io.*;
import java.util.*;

// 리모컨
public class BaekJoon_1107 {
	static int N, M;
	static boolean[] isBroken;
	static Set<Integer> set;
	static int diffMin;
	
	static void dfs(int cnt, int num) {
		if (M == 10) return;
		if (N == 100) return;
		if (N == 0 && num > 100) return;
		if (N != 0 && num > N * 2 + 100) return;
		
		if (!isBroken[0] && num == 0) {
			set.add(0);
			cnt++;
		}
		
		if (cnt > 0) {
			if (Math.abs(N - num) < diffMin) diffMin = Math.abs(N - num);
			set.add(num);
		}
		
		for (int i=0; i<10; i++) {
			if (isBroken[i]) continue;
			if (num == 0 && i == 0) continue;
			dfs(cnt + 1, num * 10 + i);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		isBroken = new boolean[10];
		
		StringTokenizer st;
		if (M != 0) {
			st = new StringTokenizer(br.readLine());
			for (int i=0; i<M; i++) {
				isBroken[Integer.parseInt(st.nextToken())] = true;
			}
		}
		
		diffMin = Integer.MAX_VALUE;
		set = new HashSet<>();
		dfs(0, 0);
		
		if (N == 100) System.out.println(0);
		else if (M == 10) {
			System.out.println(Math.abs(N - 100));
		}
		else {
			Iterator<Integer> it = set.iterator();
			int minNum = Integer.MAX_VALUE;
			int minCnt = 100;
			while (it.hasNext()) {
				int num = it.next();
				int len = Integer.toString(num).length();
				if (Math.abs(num - N) == diffMin && len < minCnt) {
					minNum = num;
					minCnt = len;
				}
			}
			System.out.println(Math.min(Math.abs(N - minNum) + minCnt, Math.abs(N - 100)));
		}
		br.close();
	}

}
