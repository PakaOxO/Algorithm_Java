package level_03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 퍼펙트 셔플
public class SWEA_3499 {
	static String[] deck;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int mid = (N % 2 == 0) ? N / 2 - 1 : N / 2;
			deck = new String[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i=0; i<N; i++) {
				deck[i] = st.nextToken();
			}
			sb.append("#").append(tc).append(" ");
			for (int i=0; i<=mid; i++) {
				sb.append(deck[i]).append(" ");
				if (i + mid + 1 < N) sb.append(deck[i + mid + 1]).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
		br.close();
	}

}
