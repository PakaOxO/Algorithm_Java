package level_03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 동철이의 프로그래밍 대회
public class SWEA_6958 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i=1; i<=T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int cnt = 0;
			int max = Integer.MIN_VALUE;
			for (int j=0; j<N; j++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				int sum = 0;
				for (int k=0; k<M; k++) {
					sum += Integer.parseInt(st2.nextToken());
				}
				if (sum >= max) {
					cnt = (sum == max) ? cnt + 1 : 1;
					max = sum;
				}
			}
			if (cnt != max) sb.append("#" + i + " " + cnt + " " + max + "\n");
			else sb.append("#" + i + " " + cnt + "\n");
		}
		System.out.println(sb.toString().trim());
	}

}
