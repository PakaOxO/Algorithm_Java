package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 분산처리
public class BaekJoon_1009 {
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			String strA = st.nextToken();
			int a = Character.getNumericValue(strA.charAt(strA.length() - 1));
			int b = Integer.parseInt(st.nextToken());
			int answer = 1;
			for (int j=0; j<b; j++) {
				answer = (answer * a) % 10;
			}
			if (answer == 0) answer = 10;
			sb.append(answer + "\n");
		}
		System.out.println(sb.toString().trim());
		br.close();
	}

}
