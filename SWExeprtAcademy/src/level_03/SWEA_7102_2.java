package level_03;

import java.io.*;
import java.util.*;

// 준홍이의 카드놀이 
public class SWEA_7102_2 {
	static int N, M;
	static int[] cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			cnt = new int[N + M + 1];
			int max = 0;
			for (int i=1; i<=N; i++) {
				for (int j=1; j<=M; j++) {
					cnt[i+j]++;
					if (cnt[i+j] > max) max = cnt[i+j];
				}
			}
			sb.append("#").append(tc).append(" ");
			for (int i=2; i<N+M; i++) {
				if (max == cnt[i]) {
					sb.append(i);
					if (i < N+M-1) sb.append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.print(sb);
		br.close();
	}

}
