package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 이상한 암호코드
public class BaekJoon_18129 {
	static int[] isVisited = new int[52];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String str = st.nextToken().toLowerCase();
		int N = Integer.parseInt(st.nextToken());
		
		int idx = 0;
		int cnt = 1;
		int len = str.length();
		StringBuilder sb = new StringBuilder();
		while (idx < len) {
			char c = str.charAt(idx);
			if (c == '0') {
				idx++;
				continue;
			}
			if (idx + 1 < len && c == str.charAt(idx + 1)) {
				cnt++;
				idx++;
				continue;
			}
			if (cnt < N) sb.append(0);
			else sb.append(1);
			str = str.replace(c, '0');
			cnt = 1;
			idx++;
		}
		System.out.println(sb);
		br.close();
	}

}
