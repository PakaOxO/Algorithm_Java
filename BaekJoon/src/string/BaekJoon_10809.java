package string;

import java.io.*;

// 알파벳 찾기
public class BaekJoon_10809 {
	static int[] cIdx = new int[26];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] cArr = br.readLine().toCharArray();
		
		for (int i=0; i<26; i++) {
			cIdx[i] = -1;
		}
		
		for (int i=0; i<cArr.length; i++) {
			char c = cArr[i];
			if (cIdx[c - 'a'] == -1) cIdx[c - 'a'] = i;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<26; i++) {
			if (i < 25) sb.append(cIdx[i]).append(" ");
			else sb.append(cIdx[i]);
		}
		System.out.println(sb);
		br.close();
	}

}
