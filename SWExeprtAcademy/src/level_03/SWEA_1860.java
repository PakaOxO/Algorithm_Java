package level_03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 진기의 최고급 붕어빵
public class SWEA_1860 {
	static int[] p;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			p = new int[11112];
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			int last = Integer.MIN_VALUE;
			for (int i=0; i<N; i++) {
				int time = Integer.parseInt(st.nextToken());
				p[time]++;
				if (time > last) last = time;
			}
			
			boolean isPossible = true;
			int cnt = 0;
			for (int i=0; i<=last; i++) {
				if (i > 0 && i % M == 0) cnt += K;
				cnt -= p[i];
				if (cnt < 0) {
					isPossible = false;
					break;
				}
			}
			sb.append("#").append(tc).append(" ");
			if (isPossible) sb.append("Possible");
			else sb.append("Impossible");
			sb.append("\n");
		}
		System.out.print(sb);
		br.close();
	}

}
