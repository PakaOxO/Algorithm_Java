package sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 카드 바꿔치기
public class BaekJoon_18766 {
	static String[] before;
	static String[] after;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			before = new String[N];
			for (int i=0; i<N; i++) {
				before[i] = st.nextToken();
			}
			Arrays.sort(before);
			
			st = new StringTokenizer(br.readLine());
			after = new String[N];
			for (int i=0; i<N; i++) {
				after[i] = st.nextToken();
			}
			Arrays.sort(after);
			
			boolean flag = true;
			for (int i=0; i<N; i++) {
				if (!before[i].equals(after[i])) {
					flag = false;
					break;
				}
			}
			if (flag) sb.append("NOT CHEATER\n");
			else sb.append("CHEATER\n");
		}
		System.out.print(sb);
		br.close();
	}

}
