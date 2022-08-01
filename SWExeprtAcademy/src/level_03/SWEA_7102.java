package level_03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 준홍이의 카드놀이
public class SWEA_7102 {

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i=1; i<=T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[] sumCnt = new int[N+M+1];
			for (int j=1; j<=N; j++) {
				for (int k=1; k<=M; k++) {
					sumCnt[j+k]++;
				}
			}
			
			int max = Integer.MIN_VALUE;
			for (int j=0; j<sumCnt.length; j++) {
				max = Math.max(max, sumCnt[j]);
			}
			sb.append("#" + i + " ");
			for (int j=0; j<sumCnt.length; j++) {
				if (sumCnt[j] == max) sb.append(j + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString().trim());
	}

}
