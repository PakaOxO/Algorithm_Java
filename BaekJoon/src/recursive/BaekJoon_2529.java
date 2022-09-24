package recursive;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_2529, 부등호
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 0~9의 숫자는 각각 하나씩 쓸 수 있으므로 숫자를 하나씩 넣어보며 부등호가 만족하는지 체크
 * 	2. 만들어진 숫자를 이전 min, max와 비교해 min과 max 갱신(9876543210과 같은 숫자는 int의 범위를 벗어나므로 long으로 관리)
 * 	3. max, min 출력
 *
 */
public class BaekJoon_2529 {
	static int N;
	static long min, max;
	static String strMin, strMax;
	static char[] arr;
	static char[] comb;
	static boolean[] isVisited;
	
	static void dfs(int prev, int depth) {
		if (depth > N) {
			String result = new String(comb);
			long num = Long.parseLong(result);
			if (num < min) {
				min = num;
				strMin = result;
			}
			if (num > max) {
				max = num;
				strMax = result;
			}
			return;
		}
		
		if (arr[depth - 1] == '<') {
			for (int i=prev+1; i<10; i++) {
				if (isVisited[i]) continue;

				comb[depth] = (char)(i + '0');
				isVisited[i] = true;
				dfs(i, depth + 1);
				isVisited[i] = false;
			}
		} else {
			for (int i=prev-1; i>=0; i--) {
				if (isVisited[i]) continue;
				
				comb[depth] = (char)(i + '0');
				isVisited[i] = true;
				dfs(i, depth + 1);
				isVisited[i] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new char[N];
		comb = new char[N + 1];
		isVisited = new boolean[10];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		br.close();
		
		min = Long.MAX_VALUE;
		max = Long.MIN_VALUE;
		for (int i=9; i>=0; i--) {
			comb[0] = (char)(i + '0');
			isVisited[i] = true;
			dfs(i, 1);
			isVisited[i] = false;
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(strMax).append("\n").append(strMin);
		System.out.println(sb);
	}

}
