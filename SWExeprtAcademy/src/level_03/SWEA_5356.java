package level_03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 의석이의 세로로 말해요
public class SWEA_5356 {
	static String[] words;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc=1; tc<=T; tc++) {
			words = new String[5];
			int maxLen = Integer.MIN_VALUE;
			for (int i=0; i<5; i++) {
				words[i] = br.readLine();
				if (words[i].length() > maxLen) maxLen = words[i].length();
			}
			StringBuilder sb2 = new StringBuilder();
			for (int i=0; i<maxLen; i++) {
				for (int j=0; j<5; j++) {
					int len = words[j].length();
					if (len < i + 1) continue;
					sb2.append(words[j].charAt(i));
				}
			}
			sb.append("#").append(tc).append(" ").append(sb2).append("\n");
		}
		System.out.print(sb);
		br.close();
	}

}
