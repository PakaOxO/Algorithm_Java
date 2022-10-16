package backtracking;

import java.io.*;

// 애너그램
public class BaekJoon_6443 {
	static int len;
	static int[] lCnt;
	static char[] word;
	static StringBuilder sb;
	
	static void dfs(int cnt) {
		if (cnt == len) {
			sb.append(word).append("\n");
			return;
		}
		
		for (int i=0; i<26; i++) {
			if (lCnt[i] == 0) continue;
			lCnt[i]--;
			word[cnt] = (char)('a' + i);
			dfs(cnt + 1);
			lCnt[i]++;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc=1; tc<=T; tc++) {
			String str = br.readLine();
			len = str.length();
			lCnt = new int[26];
			for (int i=0; i<len; i++) {
				lCnt[str.charAt(i) - 'a']++;
			}
			word = new char[len];
			dfs(0);
		}
		System.out.print(sb);
		br.close();
	}

}
