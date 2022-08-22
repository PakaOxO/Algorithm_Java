package level_03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 안경이 없어!
public class SWEA_7272 {
	static int[] cnt = { 1, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str1 = st.nextToken();
			String str2 = st.nextToken();
			
			boolean isSame = true;
			if (str1.length() != str2.length()) {
				isSame = false;
			}
			
			if (isSame) {
				for (int i=0; i<str1.length(); i++) {
					if (cnt[str1.charAt(i) - 'A'] != cnt[str2.charAt(i) - 'A']) {
						isSame = false;
						break;
					}
				}
			}
			
			sb.append("#").append(tc).append(" ");
			if (isSame) sb.append("SAME");
			else sb.append("DIFF");
			sb.append("\n");
		}
		System.out.println(sb);
		br.close();
	}

}
