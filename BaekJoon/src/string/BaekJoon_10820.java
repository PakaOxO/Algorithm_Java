package string;

import java.io.*;

// 문자열 분석
public class BaekJoon_10820 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str;
		while ((str = br.readLine()) != null) {
			int[] cnt = { 0, 0, 0, 0 };
			for (int i=0; i<str.length(); i++) {
				char c = str.charAt(i);
				if ((int)c == 32) cnt[3]++;
				else if (c >= '0' && c <= '9') cnt[2]++;
				else if (c >= 'A' && c <= 'Z') cnt[1]++;
				else cnt[0]++;
			}
			
			sb.append(cnt[0]).append(" ").append(cnt[1]).append(" ").append(cnt[2]).append(" ").append(cnt[3]).append("\n");
		}
		System.out.print(sb);
		br.close();
	}

}
