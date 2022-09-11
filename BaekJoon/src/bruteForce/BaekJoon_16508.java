package bruteForce;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_16508, 전공책 
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. 먼저 가장 적은 개수부터 N개까지 뽑는 전공책의 개수를 늘려가며 전공책을 뽑는 조합 탐색
 * 
 * 	2. 각각의 조합에 대해 만드려고 하는 문장을 만들 수 있는지 체크
 * 		2.1 만들 수 있으면 현재 뽑은 전공책의 전체 가격을 확인(가격이 낮은 순이 우선적이므로 먼저 전공책을 가격에 대해 올림차순으로 정렬)
 * 		2.2 만들 수 없으면 다음 조합 탐색 
 * 
 * 	3. 문장을 만들 수 있는 최소한의 비용을 출력 
 *
 */
public class BaekJoon_16508 {
	static int N;
	static String sentence;
	static String[][] book;
	static int[] selected;
	static int min;
	
	static boolean check(int cnt) {
		int[] letter = new int[26];
		for (int i=0; i<cnt; i++) {
			String name = book[selected[i]][1];
			for (int j=0; j<name.length(); j++) {
				letter[name.charAt(j) - 'A']++;
			}
		}
		for (int i=0; i<sentence.length(); i++) {
			if (letter[sentence.charAt(i) - 'A'] == 0) return false;
			letter[sentence.charAt(i) - 'A']--;
		}
		return true;
	}
	
	static void dfs(int start, int cnt, int sum) {
		if (sum >= min) return;
		if (cnt > 0 && check(cnt)) {
			if (sum < min) min = sum;
		}
		
		for (int i=start; i<N; i++) {
			selected[cnt] = i;
			dfs(i + 1, cnt + 1, sum + Integer.parseInt(book[i][0]));
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sentence = br.readLine();
		N = Integer.parseInt(br.readLine());
		
		book = new String[N][2];
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			book[i][0] = st.nextToken();
			book[i][1] = st.nextToken();
		}
		
		Arrays.sort(book, new Comparator<String[]>() {
			@Override
			public int compare(String[] o1, String[] o2) {
				return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
			}
		});
		
		min = Integer.MAX_VALUE;
		selected = new int[N];
		dfs(0, 0, 0);
		
		if (min == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(min);
		br.close();
	}

}
