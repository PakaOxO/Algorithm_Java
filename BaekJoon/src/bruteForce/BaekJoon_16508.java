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
 * 		2.2 만들 수 없으면 다음 조합 탐
 * 
 * 	3. 문장을 만들 수 있는 최소한의 비용을 출력 
 *
 */
public class BaekJoon_16508 {
	static int N;
	static int[][] price;
	static boolean[][] hasLetter;
	
	static void dfs(int start, int sum) {
		
		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String sentence = br.readLine();
		N = Integer.parseInt(br.readLine());
		
		price = new int[N][2];
		hasLetter = new boolean[N][26];
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			price[i][0] = i;
			price[i][1] = Integer.parseInt(st.nextToken());
			String str = st.nextToken();
			for (int j=0; j<str.length(); j++) {
				hasLetter[i][str.charAt(j) - 'a'] = true;
			}
		}
		
		Arrays.sort(price, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});
		
	}

}
