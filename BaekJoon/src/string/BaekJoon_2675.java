package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 문자열 반복
public class BaekJoon_2675 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i=1; i<=T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			String S = st.nextToken();
			StringBuilder sb = new StringBuilder();
			for (int j=0; j<S.length(); j++) {
				for (int k=0; k<R; k++) sb.append(S.charAt(j));
			}
			System.out.println(sb);
		}
		br.close();
	}

}
