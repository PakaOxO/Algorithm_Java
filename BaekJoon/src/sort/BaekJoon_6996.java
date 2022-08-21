package sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 애너그램
public class BaekJoon_6996 {
	static int[] cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String word1 = st.nextToken();
			String word2 = st.nextToken();
			
			boolean flag = true;
			if (word1.length() != word2.length()) flag = false;
			
			if (flag) {
				cnt = new int[26];
				for (int i=0; i<word1.length(); i++) {
					cnt[word1.charAt(i) - 'a']++;
				}
				for (int i=0; i<word2.length(); i++) {
					cnt[word2.charAt(i) - 'a']--;
					if (cnt[word2.charAt(i) - 'a'] < 0) {
						flag = false;
						break;
					}
				}
			}
			
			if (flag) sb.append(word1).append(" & ").append(word2).append(" are anagrams.\n");
			else sb.append(word1).append(" & ").append(word2).append(" are NOT anagrams.\n");
		}
		System.out.print(sb);
		br.close();
	}

}
