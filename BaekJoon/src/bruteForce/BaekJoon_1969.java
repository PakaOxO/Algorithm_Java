package bruteForce;

import java.io.*;
import java.util.*;

/**
 * BaekJoon_1969,DNA
 * @author kevin-Arpe
 * 
 * Sketch Idea
 * 	1. DNA들을 입력 받으면서 각 자리(0~M)에 위치하는 문자의 개수 카운팅
 * 	2. 문자의 개수가 가장 많으면서 앞에 위치한 문자를 선택해 조합
 * 	3. DNA의 개수(N) - 해당 문자를 포함한 DNA 개수를 계산해 Hamming Distance 계
 * 	4. 조합된 문자와 Hamming Distance의 합을 출력 
 *
 */
public class BaekJoon_1969 {
	static int N, M;
	static int[][] cnt;
	static char[] type = { 'A', 'C', 'G', 'T' };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		cnt = new int[M][4];
		for (int i=0; i<N; i++) {
			String dna = br.readLine();
			for (int j=0; j<M; j++) {
				char c = dna.charAt(j);
				if (c == 'A') cnt[j][0]++;
				else if (c == 'C') cnt[j][1]++;
				else if (c == 'G') cnt[j][2]++;
				else cnt[j][3]++;
			}
		}
		
		int dist = 0;
		char[] comb = new char[M];
		for (int i=0; i<M; i++) {
			int max = 0;
			for (int j=1; j<4; j++) {
				if (cnt[i][j] > cnt[i][max]) max = j;
			}
			dist += N - cnt[i][max];
			comb[i] = type[max];
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(comb).append("\n").append(dist);
		System.out.println(sb);
		br.close();
	}

}

