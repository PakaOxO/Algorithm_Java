package string;

import java.io.*;

// 알파벳 개수
public class BaekJoon_10808 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		int[] cnt = new int[26];
		for (int i=0; i<str.length(); i++) {
			cnt[str.charAt(i) - 'a']++;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<26; i++) {
			if (i < 25) sb.append(cnt[i]).append(" ");
			else sb.append(cnt[i]);
		}
		System.out.println(sb);
		br.close();
	}

}
