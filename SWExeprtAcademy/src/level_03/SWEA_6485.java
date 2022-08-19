package level_03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 삼성시의 버스 노선
public class SWEA_6485 {
	static int[] fromSt;
	static int[] toSt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			fromSt = new int[N];
			toSt = new int[N];
			for (int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				fromSt[i] = Integer.parseInt(st.nextToken());
				toSt[i] = Integer.parseInt(st.nextToken());
			}
			int P = Integer.parseInt(br.readLine());
			StringBuilder cnts = new StringBuilder();
			for (int i=0; i<P; i++) {
				int cnt = 0;
				int c = Integer.parseInt(br.readLine());
				for (int j=0; j<N; j++) {
					if (c < fromSt[j] || c > toSt[j]) continue;
					cnt++;
				}
				cnts.append(cnt);
				if (i < P - 1) cnts.append(" ");
			}
			sb.append("#").append(tc).append(" ").append(cnts).append("\n");
		}
		System.out.print(sb);
		br.close();
	}

}
